// David Roca Tauste

object `16_Map` extends App {
  // EJERCICIO 1
  val numeros = List(4, 6, 8, 7, 5, 3, 9)
  val numerosAlCuadrado = numeros.map(numero => numero * numero)

  println("EJERCICIO 1:")
  println(numerosAlCuadrado)


  // EJERCICIO 2
  val palabras = List("hola", "adios", "buenos", "días", "tardes")
  val palabrasMayuscula = palabras.map(palabra => palabra.toUpperCase())

  println("\nEJERCICIO 2:")
  println(palabrasMayuscula)


  // EJERCICIO 3
  val nombresCompletos = List("Miguel Pérez", "Sara García", "Sergio Fernández", "Lucía González")

  def transformarNombre(nombreCompleto: String): String = {
    var partesNombre = nombreCompleto.split(" ")
    return s"${partesNombre(1)}, ${partesNombre(0)}"
  }

  val nombresTransformados = nombresCompletos.map(nombre => transformarNombre(nombre))

  println("\nEJERCICIO 3:")
  println(s"Nombres transformados: ${nombresTransformados.mkString(" | ")}")
}
