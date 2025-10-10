// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Row

val spark = SparkSession.builder.appName("Ejercicio2").getOrCreate()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 1

// COMMAND ----------

// MAGIC %md
// MAGIC ### Ventas

// COMMAND ----------

val schemaVentas = new StructType()
  .add("id_venta", IntegerType)
  .add("id_producto", IntegerType)
  .add("cantidad", IntegerType)
  .add("precio_unitario", DoubleType)

// COMMAND ----------

val datosVentas = Seq(
  Row(1, 101, 2, 15.0),
  Row(2, 102, 1, 25.0),
  Row(3, 101, 3, 15.0),
  Row(4, 103, 5, 10.0),
  Row(5, 104, 2, 30.0)
)

// COMMAND ----------

val dfVentas = spark.createDataFrame(spark.sparkContext.parallelize(datosVentas), schemaVentas)
dfVentas.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ### Productos

// COMMAND ----------

val schemaProductos = new StructType()
  .add("id_producto", IntegerType)
  .add("nombre_producto", StringType)
  .add("categoria", StringType)

// COMMAND ----------

val datosProductos = Seq(
  Row(101, "Camiseta", "Ropa"),
  Row(102, "Zapatos", "Calzado"),
  Row(103, "Gorra", "Accesorios"),
  Row(104, "Chaqueta", "Ropa")
)

// COMMAND ----------

val dfProductos = spark.createDataFrame(spark.sparkContext.parallelize(datosProductos), schemaProductos)
dfProductos.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 2

// COMMAND ----------

val dfAgrupado = dfVentas.join((dfProductos), dfVentas("id_producto") === dfProductos("id_producto"))

display(dfAgrupado)

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 3

// COMMAND ----------

/*
val df1 = dfAgrupado
  .agg()
*/

// COMMAND ----------

val df2 = dfAgrupado
  .groupBy("categoria")
  .agg(sum("precio_unitario").as("suma_total"))

df2.show()

// COMMAND ----------

val df3 = df2
  .orderBy(desc("suma_total"))

df3.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 4

// COMMAND ----------

dfAgrupado.createOrReplaceTempView("dfAgrupado")


// COMMAND ----------

val dfSQL = spark.sql("""
  SELECT departamento, AVG(salario) AS salario_promedio
  FROM dfAgrupado
  GROUP BY categoria
  ORDER BY salario_promedio DESC
""")

dfSQL.show()
