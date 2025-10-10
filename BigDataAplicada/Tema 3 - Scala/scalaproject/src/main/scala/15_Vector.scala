// David Roca Tauste

import scala.util.Random
object Vectorizar extends App {
    // En primer lugar, se crea un vector de enteros, con los valores 1, 2 y 3. Después de eso, se imprime el vector.
    val vector: Vector[Int] = Vector (1,2,3)
    println(vector)

    // Se inicializan dos variables.
    //vector vs lists
    val maxRuns = 1000
    val maxCapacity = 1000000

    /* 
    La función getWriteTime mide el tiempo necesario para realizar una operación de actualización (collection.updated)
    en una colección, en este caso con una lista y un vector.

    Pasos:
    - Recibe una colección y genera valores aleatorios con Random.
    - Realiza maxRuns iteraciones.
    - En cada iteración:
      · Registra el tiempo antes y después de la operación de actualización.
      · Calcula el tiempo transcurrido.
    - Devuelve el tiempo de actualización promedio en nanosegundos, el cual se calcula dividiendo la suma de 
      los tiempos entre el número de iteraciones.
    */
    def getWriteTime (collection: Seq[Int]): Double = {
       val r = new Random
       val times = for {
        it <- 1 to maxRuns
       } yield {
        val currentTime = System.nanoTime()
        collection.updated(r.nextInt(maxCapacity),r.nextInt)
        System.nanoTime - currentTime
       }

       times.sum * 1.0 / maxRuns
    }

    // Se crean dos variables, una lista y un vector, que van desde el número 1 hasta el 1000000.
    val numberLists = (1 to maxCapacity).toList
    val numberVector = (1 to maxCapacity).toVector
    
    // Se llama a la función getWriteTime() con ambas variables y se imprime el tiempo que ha tardado cada una en realizar la operación.
    println(getWriteTime(numberLists))
    println(getWriteTime(numberVector))
}


object ArrayList extends App {
  // EJERCICIO
  // Apartado 1
  val temperaturas = List(12, 14, 11, 17)
  var temperaturasAnyadidas = temperaturas :+ 19 :+ 21

  println("Apartado 1:")
  println(s"Temperaturas registradas: ${temperaturasAnyadidas.mkString(" ")}")


  // Apartado 2
  val puntuaciones = Array(56, 72, 86, 43, 67, 49)
  val promedio = puntuaciones.sum.toDouble / puntuaciones.length

  println("\nApartado 2:")
  println(s"Puntuaciones: ${puntuaciones.mkString(" ")}")
  println(s"Prodemio: $promedio")


  // Apartado 3
  val listaCompra = List("Manzanas", "Vino", "Sandía", "Pasta de dientes")
  listaCompra +: "Agua"

  println("\nApartado 3:")
  println(s"Lista de la compra: ${listaCompra.mkString(" ")}")


  // Apartado 4
  val inventario = Array(3, 2, 5, 9, 12)
  val inventarioOriginal = inventario
  inventario(2) = 6
  inventario(4) = 3
  inventario(1) = 1

  println("\nApartado 4:")
  println(s"Inventario original: ${inventarioOriginal.mkString(" ")}")
  println(s"Inventario modificado: ${inventario.mkString(" ")}")
}
