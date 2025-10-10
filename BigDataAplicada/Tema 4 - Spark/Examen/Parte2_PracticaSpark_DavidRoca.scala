// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Row

val spark = SparkSession.builder.appName("Parte2_PracticaSpark").getOrCreate()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 1

// COMMAND ----------

// MAGIC %md
// MAGIC ### Datos de vuelos

// COMMAND ----------

val schemaVuelos = new StructType()
  .add("id_vuelo", IntegerType)
  .add("id_aerolinea", IntegerType)
  .add("origen", StringType)
  .add("destino", StringType)
  .add("duracion", IntegerType)
  .add("capacidad", IntegerType)
  .add("fecha", StringType)

// COMMAND ----------

val datosVuelos = Seq(
  Row(1, 101, "JFK", "LAX", 360, 180, "2024-03-01"),
  Row(2, 102, "LAX", "ORD", 270, 200, "2024-03-02"),
  Row(3, 101, "ORD", "MIA", 180, 150, "2024-03-03"),
  Row(4, 103, "MIA", "ATL", 120, 220, "2024-03-04"),
  Row(5, 104, "ATL", "DFW", 150, 160, "2024-03-05"),
  Row(6, 105, "DFW", "SFO", 210, 190, "2024-03-06"),
  Row(7, 102, "SFO", "SEA", 120, 170, "2024-03-07"),
  Row(8, 101, "SEA", "JFK", 330, 175, "2024-03-08")
)

// COMMAND ----------

val dfVuelos = spark.createDataFrame(spark.sparkContext.parallelize(datosVuelos), schemaVuelos)
dfVuelos.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ### Datos de aerolíneas
// MAGIC

// COMMAND ----------

val schemaAerolineas = new StructType()
  .add("id_aerolinea", IntegerType)
  .add("nombre_aerolinea", StringType)
  .add("pais_origen", StringType)

// COMMAND ----------

val datosAerolineas = Seq(
  Row(101, "American Airlines", "USA"),
  Row(102, "Delta Airlines", "USA"),
  Row(103, "United Airlines", "USA"),
  Row(104, "Lufthansa", "Germany"),
  Row(105, "Air France", "France")
)

// COMMAND ----------

val dfAerolineas = spark.createDataFrame(spark.sparkContext.parallelize(datosAerolineas), schemaAerolineas)
dfAerolineas.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ### Datos de pasajeros

// COMMAND ----------

val schemaPasajeros = new StructType()
  .add("id_vuelo", IntegerType)
  .add("id_pasajero", IntegerType)
  .add("nombre_pasajero", StringType)
  .add("clase", StringType)

// COMMAND ----------

val datosPasajeros = Seq(
  Row(1, 1001, "Carlos López", "Económica"),
  Row(2, 1002, "Ana Martínez", "Business"),
  Row(3, 1003, "Luis Fernández", "Económica"),
  Row(4, 1004, "Sofía Ramírez", "Primera Clase"),
  Row(5, 1005, "Miguel Torres", "Económica"),
  Row(6, 1006, "Elena Ríos", "Business"),
  Row(7, 1007, "Pedro Suárez", "Económica"),
  Row(8, 1008, "Lucía Gómez", "Económica"),
)

// COMMAND ----------

val dfPasajeros = spark.createDataFrame(spark.sparkContext.parallelize(datosPasajeros), schemaPasajeros)
dfPasajeros.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 2

// COMMAND ----------

val vuelosConAerolineasDF = dfVuelos.join(dfAerolineas, "id_aerolinea")

// COMMAND ----------

val dfAgrupados = vuelosConAerolineasDF.join(dfPasajeros, "id_vuelo")
dfAgrupados.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 3

// COMMAND ----------

val dfPasajerosTransportados = dfAgrupados
  .groupBy("nombre_aerolinea")
  .agg(sum("capacidad").as("total_pasajeros_transportados"))
  .orderBy(desc("total_pasajeros_transportados"))

dfPasajerosTransportados.show()

// COMMAND ----------

val dfDuracionPromedioVuelo = dfAgrupados
  .groupBy("nombre_aerolinea")
  .agg(max("duracion").as("duracion_promedio"))
  .orderBy(desc("duracion_promedio"))

dfDuracionPromedioVuelo.show()

// COMMAND ----------

val dfVuelosPorAerolinea = vuelosConAerolineasDF
  .groupBy("nombre_aerolinea")
  .agg(count("nombre_aerolinea").as("vuelos_operados"))
  .orderBy(desc("vuelos_operados"))

dfVuelosPorAerolinea.show()

// COMMAND ----------

val dfRutasFrecuentes = dfVuelos
  .groupBy("origen")
  .agg(count("origen").as("num_veces_ruta_repetida"))
  .orderBy(desc("num_veces_ruta_repetida"))

dfRutasFrecuentes.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 4

// COMMAND ----------

val dfPasajerosPorVuelo = dfAgrupados
  .groupBy("id_vuelo")
  .agg(count("id_pasajero").as("cantidad_pasajeros"))
  .orderBy(desc("cantidad_pasajeros"))

val dfAgrupadoConPasajeros = dfAgrupados.join(dfPasajerosPorVuelo, "id_vuelo")

val dfOcupacionVuelo = dfAgrupadoConPasajeros
  .withColumn("porcentaje_ocupacion", col("cantidad_pasajeros") / col("capacidad"))
  .select("id_vuelo", "porcentaje_ocupacion")

dfOcupacionVuelo.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 5

// COMMAND ----------

val dfDestinosCubiertos = dfAgrupados
  .groupBy("nombre_aerolinea")
  .agg(count("destino").as("destinos_cubiertos"))
  .orderBy(desc("destinos_cubiertos"))

dfDestinosCubiertos.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 6

// COMMAND ----------

val dfVueloMasLargo = dfVuelos
  .groupBy("origen")
  .agg(max("duracion").as("duracion"))
  .orderBy(desc("duracion"))
  .limit(1)

dfVueloMasLargo.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 7

// COMMAND ----------

val dfPasajerosPorClase = dfPasajeros
  .groupBy("clase")
  .agg(count("clase").as("pasajeros_utilizado_servicio"))
  .orderBy(desc("pasajeros_utilizado_servicio"))

dfPasajerosPorClase.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 8

// COMMAND ----------

/*
val schemaVuelos = new StructType()
  .add("id_vuelo", IntegerType)
  .add("id_aerolinea", IntegerType)
  .add("origen", StringType)
  .add("destino", StringType)
  .add("duracion", IntegerType)
  .add("capacidad", IntegerType)
  .add("fecha", DateType)

val dfVuelosFormateado = spark.createDataFrame(spark.sparkContext.parallelize(datosVuelos), schemaVuelos)

val dfVuelosPorMes = dfVuelosFormateado
  .groupBy(col("fecha").month)
  .agg(count("fecha").as("vuelos"))
  .orderBy(desc("vuelos"))

*/

val dfVuelosPorMes = dfVuelos
  .groupBy("fecha")
  .agg(count("fecha").as("vuelos"))
  .orderBy(desc("vuelos"))

dfVuelosPorMes.show()

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 9

// COMMAND ----------

dfVuelos.createOrReplaceTempView("dfVuelos")
dfAerolineas.createOrReplaceTempView("dfAerolineas")
dfPasajeros.createOrReplaceTempView("dfPasajeros")
dfAgrupados.createOrReplaceTempView("dfAgrupados")

// COMMAND ----------

// MAGIC %md
// MAGIC ---
// MAGIC ## Ejercicio 10

// COMMAND ----------

// MAGIC %md
// MAGIC Si pulsas para editar el Markdown de abajo se ve bien.

// COMMAND ----------

// MAGIC %md
// MAGIC Resultados obtenidos:
// MAGIC  - Ejercicio 3:
// MAGIC   - Apartado 1:
// MAGIC
// MAGIC +-----------------+-----------------------------+
// MAGIC | nombre_aerolinea|total_pasajeros_transportados|
// MAGIC +-----------------+-----------------------------+
// MAGIC |American Airlines|                          505|
// MAGIC |   Delta Airlines|                          370|
// MAGIC |  United Airlines|                          220|
// MAGIC |       Air France|                          190|
// MAGIC |        Lufthansa|                          160|
// MAGIC +-----------------+-----------------------------+
// MAGIC
// MAGIC   - Apartado 2:
// MAGIC +-----------------+-----------------+
// MAGIC | nombre_aerolinea|duracion_promedio|
// MAGIC +-----------------+-----------------+
// MAGIC |American Airlines|              360|
// MAGIC |   Delta Airlines|              270|
// MAGIC |       Air France|              210|
// MAGIC |        Lufthansa|              150|
// MAGIC |  United Airlines|              120|
// MAGIC +-----------------+-----------------+
// MAGIC
// MAGIC   - Apartado 3:
// MAGIC +-----------------+---------------+
// MAGIC | nombre_aerolinea|vuelos_operados|
// MAGIC +-----------------+---------------+
// MAGIC |American Airlines|              3|
// MAGIC |   Delta Airlines|              2|
// MAGIC |       Air France|              1|
// MAGIC |  United Airlines|              1|
// MAGIC |        Lufthansa|              1|
// MAGIC +-----------------+---------------+
// MAGIC
// MAGIC   - Apartado 4:
// MAGIC +------+-----------------------+
// MAGIC |origen|num_veces_ruta_repetida|
// MAGIC +------+-----------------------+
// MAGIC |   JFK|                      1|
// MAGIC |   LAX|                      1|
// MAGIC |   ORD|                      1|
// MAGIC |   MIA|                      1|
// MAGIC |   ATL|                      1|
// MAGIC |   DFW|                      1|
// MAGIC |   SFO|                      1|
// MAGIC |   SEA|                      1|
// MAGIC +------+-----------------------+
// MAGIC
// MAGIC
// MAGIC  - Ejercicio 4:
// MAGIC +--------+--------------------+
// MAGIC |id_vuelo|porcentaje_ocupacion|
// MAGIC +--------+--------------------+
// MAGIC |       1|0.005555555555555556|
// MAGIC |       2|               0.005|
// MAGIC |       3|0.006666666666666667|
// MAGIC |       4|0.004545454545454545|
// MAGIC |       5|             0.00625|
// MAGIC |       6|0.005263157894736842|
// MAGIC |       7|0.005882352941176...|
// MAGIC |       8|0.005714285714285714|
// MAGIC +--------+--------------------+
// MAGIC A partir de esta tabla, podemos observar que el porcentaje de ocupación en los vuelos no supera en ningún caso el 0'1%.
// MAGIC
// MAGIC
// MAGIC  - Ejercicio 5:
// MAGIC +-----------------+------------------+
// MAGIC | nombre_aerolinea|destinos_cubiertos|
// MAGIC +-----------------+------------------+
// MAGIC |American Airlines|                 3|
// MAGIC |   Delta Airlines|                 2|
// MAGIC |  United Airlines|                 1|
// MAGIC |        Lufthansa|                 1|
// MAGIC |       Air France|                 1|
// MAGIC +-----------------+------------------+
// MAGIC
// MAGIC
// MAGIC  - Ejercicio 6:
// MAGIC +------+--------+
// MAGIC |origen|duracion|
// MAGIC +------+--------+
// MAGIC |   JFK|     360|
// MAGIC +------+--------+
// MAGIC La ruta con el vuelo más largo es JFK-LAX, con un total de 360 minutos.
// MAGIC
// MAGIC
// MAGIC  - Ejercicio 7:
// MAGIC +-------------+----------------------------+
// MAGIC |        clase|pasajeros_utilizado_servicio|
// MAGIC +-------------+----------------------------+
// MAGIC |    Económica|                           5|
// MAGIC |     Business|                           2|
// MAGIC |Primera Clase|                           1|
// MAGIC +-------------+----------------------------+
// MAGIC A partir de esta tabla, podemos observar que 5 pasajeros han volado en clase "Económica", 2 en "Business" y 1 en "Primera Clase".