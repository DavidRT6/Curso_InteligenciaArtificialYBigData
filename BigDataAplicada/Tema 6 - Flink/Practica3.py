# Autor: David Roca Tauste

# Importaciones
from pyflink.table import (
    EnvironmentSettings,
    TableEnvironment,
    TableDescriptor,
    Schema,
    DataTypes,
)
from pyflink.table.expressions import col
from pyflink.table.udf import udf
import pandas as pd


# EJERCICIO 1: Configurando entorno en modo batch
"""
Configurar PyFlink en modo batch y crear dos tablas temporales a partir de datos simulados de la
tabla de usuarios y de la tabla views (visualizaciones).
"""
print("\nEJERCICIO 1")

env_settings = EnvironmentSettings.in_batch_mode()
table_env = TableEnvironment.create(env_settings)

print("Tabla usuarios")
usuarios = table_env.from_elements(
    [
        (1, "Alice", "USA"),
        (2, "Bob", "Canada"),
        (3, "Carla", "USA"),
        (4, "David", "Mexico"),
        (5, "Eva", "Canada"),
    ],
    ["user_id", "nombre", "pais"],
)
usuarios.execute().print()

print("Tabla visualizaciones")
visualizaciones = table_env.from_elements(
    [
        (101, 1, "A1", 10, "2024-12-01"),
        (102, 1, "A2", 30, "2024-12-02"),
        (103, 2, "A2", 15, "2024-12-03"),
        (104, 3, "A1", 5, "2024-12-03"),
        (105, 4, "A3", 20, "2024-12-04"),
        (106, 5, "A1", 50, "2024-12-04"),
        (107, 2, "A4", 25, "2024-12-05"),
        (108, 5, "A2", 35, "2024-12-05"),
        (109, 1, "A3", 40, "2024-12-06"),
        (110, 4, "A1", 60, "2024-12-06"),
    ],
    ["view_id", "user_id", "video_id", "watch_time_minutes", "fecha"],
)
visualizaciones.execute().print()


# EJERCICIO 2
"""
Calcular el tiempo total de visualización por usuario usando Table API
"""
print("\nEJERCICIO 2")

tiempo_visualizacion_usuario = visualizaciones.group_by(col("user_id")) \
    .select(
        col("user_id"),
        col("watch_time_minutes").sum.alias("tiempo_total")
    )

"""
tiempo_visualizacion_usuario = tiempo_visualizacion_usuario.join(usuarios) \
    .where(tiempo_visualizacion_usuario.user_id == usuarios.user_id) \
    .select(
        usuarios.nombre,
        tiempo_visualizacion_usuario.tiempo_total
    )
"""
    
tiempo_visualizacion_usuario.execute().print()


# EJERCICIO 3
"""
Obtener el país con mayor tiempo de visualización total usando SQL
"""
print("\nEJERCICIO 3")

table_env.create_temporary_view("usuarios", usuarios)
table_env.create_temporary_view("visualizaciones", visualizaciones)

consulta_sql = """
SELECT u.pais, SUM(v.watch_time_minutes) AS tiempo_total
FROM visualizaciones v
JOIN usuarios u ON v.user_id = u.user_id
GROUP BY u.pais
ORDER BY tiempo_total DESC
LIMIT 1
"""

pais_mayor_tiempo_visualizacion = table_env.sql_query(consulta_sql)
pais_mayor_tiempo_visualizacion.execute().print()


# EJERCICIO 4
"""
Promedio de tiempo de visualización por video usando Table API
"""
print("\nEJERCICIO 4")

tiempo_promedio_video = visualizaciones.group_by(col("video_id")) \
    .select(
        col("video_id"),
        col("watch_time_minutes").avg.alias("promedio_tiempo_visualizacion")
    )

tiempo_promedio_video.execute().print()


# EJERCICIO 5
"""
Contar cuántos usuarios únicos vieron cada video (SQL)
"""
print("\nEJERCICIO 5")

usuarios_unicos_video = table_env.sql_query("""
    SELECT
        video_id,
        COUNT(DISTINCT user_id) AS usuarios_unicos
    FROM visualizaciones
    GROUP BY video_id
""")

usuarios_unicos_video.execute().print()


# EJERCICIO 6
"""
Obtener los 3 usuarios con más minutos vistos (SQL)
"""
print("\nEJERCICIO 6")

consulta_sql = """
SELECT u.nombre, SUM(v.watch_time_minutes) AS tiempo_total
FROM visualizaciones v
JOIN usuarios u ON v.user_id = u.user_id
GROUP BY u.nombre
ORDER BY tiempo_total DESC
LIMIT 3
"""

usuarios_mas_tiempo_visto = table_env.sql_query(consulta_sql)
usuarios_mas_tiempo_visto.execute().print()


# EJERCICIO 7
"""
Determinar qué día tuvo más visualizaciones en total (Table API)
"""
print("\nEJERCICIO 7")

dia_mas_visualizaciones = visualizaciones.group_by(col("fecha")) \
    .select(
        col("fecha"),
        col("view_id").count.alias("total_visualizaciones")
    ) \
    .order_by(col("total_visualizaciones").desc) \
    .limit(1)

dia_mas_visualizaciones.execute().print()