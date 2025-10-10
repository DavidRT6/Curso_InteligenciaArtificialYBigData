// Databricks notebook source
//Analizar los salarios de sus empleados en diferentes departamentso para obtener información clave sobre la distribución de los sueldos.


// COMMAND ----------

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Row

// Crear sesión de Spark 
val spark = SparkSession.builder.appName("AnalisisSalarios").getOrCreate()

// Definir el esquema de los datos
val schema = new StructType()
  .add("id", IntegerType)
  .add("nombre", StringType)
  .add("departamento", StringType)
  .add("salario", DoubleType)
  

// COMMAND ----------

// Datos de empleados
val datos = Seq(
  Row(1, "Miguel", "IT", 50000.0),
  Row(2, "Laura", "RRHH", 42000.0),
  Row(3, "Carlos", "Finanzas", 55000.0),
  Row(4, "Ana", "Marketing", 58000.0),
  Row(5, "Daniel", "IT", 48000.0),
  Row(6, "Lilyan", "Finanzas", 57000.0)
)

print(datos)

// COMMAND ----------

// Crear el DataFrame con el esquema
val df = spark.createDataFrame(spark.sparkContext.parallelize(datos), schema)

// Mostrar los datos cargados
df.show()

// COMMAND ----------

// Agrupar por departamento y calcular salario promedio
val dfAgrupado = df
  .groupBy("departamento")
  .agg(avg("salario").as("salario_promedio"))

// Mostrar los resultados
dfAgrupado.show()

// COMMAND ----------

// Ordenar de mayor a menor salario promedio
val dfOrdenado = dfAgrupado
  .orderBy(desc("salario_promedio"))

// Mostrar resultados ordenados
dfOrdenado.show()

// COMMAND ----------

// Crear vista temporal para consultas SQL
df.createOrReplaceTempView("salarios")

// COMMAND ----------

// Consulta SQL en Spark
val dfSQL = spark.sql("""
  SELECT departamento, AVG(salario) AS salario_promedio
  FROM salarios
  GROUP BY departamento
  ORDER BY salario_promedio DESC
""")

// Mostrar resultados de SQL
dfSQL.show()
