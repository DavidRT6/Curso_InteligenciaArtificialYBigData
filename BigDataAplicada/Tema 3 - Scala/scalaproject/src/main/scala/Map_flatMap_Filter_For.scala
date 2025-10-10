// David Roca Tauste

object Map_flatMap_Filter_For extends App {
  /* EJERCICIO 1
  Dada una lista de alumnos y alumnas con sus nombres y una lista de asignaturas disponibles,
  genera todas las combinaciones posibles en ambas creando una cadena con el siguiente formato:
    "Nombre del estudiante" está inscrito en "Asignaturas"
  */
  val alumnos = List("Pepe", "Sara", "Miguel", "Laura")
  val asignaturas = List("Física", "Economía", "Matemáticas", "E.F.", "Castellano")

  val forCombinaciones = for {
    alum <- alumnos
    asig <- asignaturas
  } yield "" + alum + " está inscrito/a en " + asig + "\n"

  println("EJERCICIO 1:")
  println(forCombinaciones)


  /* EJERCICIO 2
  En una tienda de frutas, cada fruta tiene un precio por unidad. Se necesita realizar las siguientes
  operacuibes sobre una lista de compras de un cliente:
    1. Filtrar las frutas cuyo precio por unidad sea mayor a 3
    2. Calcular el precio total para cada fruta filtrada considerando la cantidad comprada
    3. Generar una lista de mensajes indicando cuánto se gastará por cada fruta en el formato:
      "Fruta: <nombre>, Total: <total>"
  */
  case class Fruta(nombre: String, precio: Double, cantidad: Int)

  val frutas = List(
    Fruta("Manzana", 3.2, 3),
    Fruta("Pera", 1.3, 6),
    Fruta("Melocotón", 8.5, 1),
    Fruta("Granada", 0.7, 5),
    Fruta("Cerezas", 0.4, 5),
    Fruta("Naranja", 3.01, 9)
  )

  // Parte 1
  val frutasPrecioFiltrado = frutas.filter(_.precio > 3)

  // Parte 2
  val frutasPrecioTotal = frutasPrecioFiltrado.map(fruta => (fruta.nombre, fruta.precio * fruta.cantidad))

  // Parte 3
  val listaCompra = frutasPrecioTotal.map {
    case (nombre, precioTotal) => s"\nFruta: $nombre, Total: $precioTotal"
  }

  println("\nEJERCICIO 2:")
  println("En formato lista:\n" + listaCompra)

  print("\nSin formato lista:")
  listaCompra.foreach(print)
}


  // EJERCICIO 2
  /*
  val frutas = List("Manzana", "Pera", "Melocotón", "Granada", "Cerezas")
  val precios = List(3.2, 1.3, 8.5, 0.7, 2.2, 0.4)
  println("\nEJERCICIO 2:")

  // Parte 1
  val frutasPrecioMayorQue3 = precios.filter(_ > 3).flatMap(p => frutas.map(f => "" + f + ": " + p))
  println(frutasPrecioMayorQue3)

  val prueba1 = for {
    p <- precios.filter(_ > 3)
    frut <- frutas
  } yield "" + frut + ": " + p

  println(prueba1)
  */