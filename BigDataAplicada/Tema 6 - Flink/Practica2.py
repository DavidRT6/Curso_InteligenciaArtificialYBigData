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
Crea un entorno en modo batch para procesamiento por lotes.
"""
env_settings = EnvironmentSettings.in_batch_mode()
table_env = TableEnvironment.create(env_settings)


# EJERCICIO 2
"""
Define la tabla orders con los siguientes datos:
- Alicia, España, 1500
- Roberto, Alemania, 2300
- Esther, Francia, 1239
"""
print("\nEJERCICIO 2")

orders = table_env.from_elements(
    [('Alicia', 'España', 1500), ('Roberto', 'Alemania', 2300), ('Esther', 'Francia', 1239)],
    ['nombre', 'pais', 'ingreso']
)
orders.execute().print()


# EJERCICIO 3
"""
Crea una UDF tipo Pandas, definida con lambda:
- columnas nombre, país e ingreso
- multiplica por 2 el ingreso
- devuelve un DataFrame con nombre e ingreso ajustado
"""
funcion_duplicar_ingresos = udf(
    lambda x: pd.concat([x.nombre, x.ingreso * 2], axis=1),
    result_type=DataTypes.ROW(
        [
            DataTypes.FIELD("nombre", DataTypes.STRING()),
            DataTypes.FIELD("ingreso_ajustado", DataTypes.INT()),
        ]
    ),
    func_type="pandas",
)


# EJERCICIO 4
"""
Aplica esta función a la tabla.
"""
orders = orders.map(funcion_duplicar_ingresos)


# EJERCICIO 5
"""
Imprime el resultado final con los ingresos corregidos.
"""
print("\nEJERCICIO 3, 4 y 5")
orders.execute().print()