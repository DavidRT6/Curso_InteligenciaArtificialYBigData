# Autor: David Roca Tauste

# creating table with TableDescriptor
# Importing necessary modules from PyFlink
from pyflink.table import (
    EnvironmentSettings,
    TableEnvironment,
    TableDescriptor,
    Schema,
    DataTypes,
)
from pyflink.table.expressions import col

# Setting the environment for streaming mode
env_settings = EnvironmentSettings.in_streaming_mode()
table_env = TableEnvironment.create(env_settings)

# EJERCICIO 1
"""
Crea la tabla con los datos simulados utilizando el conector “datagen” que contenga los siguientes campos:
- identificador de tipo entero siendo una secuencia de 1 a 10.
- temperatura de tipo double cuya temperatura mínima sea 15 y temperatura máxima sea 35.
"""
print("\nEJERCICIO 1")

table_env.execute_sql(
    """
    CREATE TABLE datos_temperaturas (
        id INT, 
        temperatura DOUBLE 
    ) WITH (
        'connector' = 'datagen',
        'rows-per-second' = '5',
        'fields.id.kind'='sequence',
        'fields.id.start'='1',
        'fields.id.end'='10',
        'fields.temperatura.min'='15',
        'fields.temperatura.max'='35'
    )
"""
)
tabla = table_env.from_path("datos_temperaturas")
tabla.execute().print()


# EJERCICIO 2
"""
Muestra sólo aquellos sensores cuya temperatura sea mayor a 30ºC y muestra la información como salida. (pista: filter)
"""
print("\nEJERCICIO 2")

altas_temperaturas = tabla.filter(col("temperatura") > 30)
altas_temperaturas.execute().print()


# EJERCICIO 3
"""
Simula un error aumentando todas las temperaturas en 2 grados (pista: sumar 2 a la columna tempertura) y muestra la información como salida.
"""
print("\nEJERCICIO 3")

temperaturas_incrementadas = tabla.select(
    col("id"),
    (col("temperatura") + 2).alias("temperatura_incrementada")
)
temperaturas_incrementadas.execute().print()


# EJERCICIO 4
"""
Crea un nueva tabla de sensores críticos utilizando “import DataTypes” con los identificadores 3, 4 y 7.
"""
print("\nEJERCICIO 4")

sensores_criticos = table_env.from_elements(
    elements=[(3,), (4,), (7,)]
).alias("id")
sensores_criticos.execute().print()


# EJERCICIO 5
"""
Realiza la unión entre los sensores simulados y los críticos mostrando sólo sus temperaturas. Para ello utiliza:
CREATE TEMPORARY VIEW
JOIN
FROM_PATH
"""
print("\nEJERCICIO 5")

table_env.create_temporary_view("temperaturas_incrementadas", temperaturas_incrementadas)
table_env.create_temporary_view("sensores_criticos", sensores_criticos)

tabla_union_sensores = table_env.sql_query("""
    SELECT sc.id, ti.temperatura_incrementada
    FROM sensores_criticos AS sc
    JOIN temperaturas_incrementadas AS ti
    ON sc.id = ti.id
""")

tabla_union_sensores.execute().print()
