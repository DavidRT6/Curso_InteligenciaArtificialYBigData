// David Roca Tauste

object Ejercicios_Repaso extends App {
  /* EJERCICIO 1
  Gestión de tienda de productos electrónicos donde cada producto tiene un nombre, un precio y una categoría. Realizaremos las siguientes operaciones:

    Filtrar los productos con un precio mayor a 100.
    Obtener los nombres de los productos de una categoría específica.
    Expandir la lista de productos en función de su categoría utilizando flatMap.
    Aplicar una oferta de descuento de 20% a los productos que tengan un precio mayor a 200.
    Clasificar los productos según su categoría utilizando match.
  */
  println("EJERCICIO 1:")

  case class Producto(nombre: String, precio: Double, categoria: String)

  // Lista de productos
  val productos = List(
    Producto("Lavadora", 600.0, "Electrodomésticos"),
    Producto("Nevera", 900.0, "Electrodomésticos"),
    Producto("Ordenador", 1500.0, "Informática"),
    Producto("Monitor", 90.0, "Informática"),
    Producto("Teclado", 20.0, "Periféricos")
  )

  // Apartado 1: filtrar los productos con un precio mayor a 100
  val productosMayoresQue100 = productos.filter(_.precio > 100)

  println("Productos con un precio mayor a 100:")
  productosMayoresQue100.foreach(println)

  // Apartado 2: obtener los nombres de los productos de una categoría específica
  val categoriaEspecifica = "Electrodomésticos"
  val nombresCategoria = productos.filter(_.categoria == categoriaEspecifica).map(_.nombre)

  println(s"\nNombres de los productos de la categoría \"$categoriaEspecifica\":")
  nombresCategoria.foreach(println)

  // Apartado 3: expandir la lista de productos en función de su categoría utilizando flatMap
  // No he acabado de entender el enunciado, así que he hecho esto
  val listaExpandida = productos.flatMap(producto => List(producto.nombre, producto.categoria))

  println("\nLista expandida:")
  listaExpandida.foreach(println)

  // Apartado 4: aplicar una oferta de descuento de 20% a los productos con precio mayor a 200
  val productosOferta = productos.map { producto =>
    if (producto.precio > 200) producto.copy(precio = producto.precio * 0.8)
    else producto
  }

  println("\nProductos con descuento aplicado (con precio mayor a 200):")
  productosOferta.foreach(println)

  // Apartado 5: clasificar los productos según su categoría utilizando match
  val productosPorCategoria = productos.groupBy(_.categoria).map {
    case (categoria, listaProductos) => s"Categoría: $categoria" -> listaProductos.map(_.nombre)
  }

  println("\nClasificación de productos por categoría:")
  productosPorCategoria.foreach {
    case (categoria, nombres) =>
      println(categoria)
      nombres.foreach(nombre => println(s" - $nombre"))
  }


  /* EJERCICIO 2
    Imagina que estás desarrollando un sistema para una librería en línea donde cada libro tiene un título, un precio y un género 
    (por ejemplo, "Ficción", "No Ficción", "Ciencia", etc.). 
    El sistema debe permitir realizar varias operaciones sobre una lista de libros, tales como: 
        filtrar los libros cuyo precio sea superior a 20, obtener los títulos de los libros de un género específico, 
        expandir la lista de libros para incluir tanto el título como el género, 
        aplicar un descuento del 10% a los libros cuyo precio sea superior a 50, 
        y finalmente clasificar los libros según su género utilizando match. 
    El objetivo es utilizar las funciones map, flatMap, filter y match para resolver estos problemas de manera eficiente.
  */
  println("\nEJERCICIO 2:")

  case class Libro(titulo: String, precio: Double, genero: String)

  // Lista de libros
  val libros = List(
    Libro("Los Juegos del Hambre", 50.0, "Ficción"),
    Libro("El Principito", 15.0, "Fantasía"),
    Libro("Sherlock Holmes", 25.0, "Misterio"),
    Libro("El Señor de los Anillos", 60.0, "Ficción"),
    Libro("Geronimo Stilton", 55.0, "Fantasía")
  )

  // Apartado 1: filtrar los libros cuyo precio sea superior a 20
  val librosCaros = libros.filter(_.precio > 20)

  println("Libros cuyo precio es superior a 20:")
  librosCaros.foreach(println)

  // Apartado 2: obtener los títulos de los libros de un género específico
  val generoEspecifico = "Ficción"
  val titulosGeneroEspecifico = libros.filter(_.genero == generoEspecifico).map(_.titulo)

  println(s"\nTítulos del género \"$generoEspecifico\":")
  titulosGeneroEspecifico.foreach(println)

  // Apartado 3: expandir la lista de libros para incluir tanto el título como el género
  val tituloConGenero = libros.flatMap(libro => List(libro.titulo, libro.genero))

  println("\nLista expandida:")
  tituloConGenero.foreach(println)

  // Apartado 4: aplicar un descuento del 10% a los libros cuyo precio sea superior a 50
  val librosConDescuento = libros.map { libro =>
    if (libro.precio > 50) libro.copy(precio = libro.precio * 0.9)
    else libro
  }

  println("\nLibros con descuento aplicado (con precio mayor a 50):")
  librosConDescuento.foreach(println)

  // Apartado 5: clasificar los libros según su género utilizando match
  val librosPorGenero = libros.groupBy(_.genero).map {
    case (genero, listaLibros) => s"Género: $genero" -> listaLibros.map(_.titulo)
  }

  println("\nClasificación de libros por género:")
  librosPorGenero.foreach {
    case (genero, titulos) =>
      println(genero)
      titulos.foreach(titulo => println(s" - $titulo"))
  }   
}


// David Roca
object Ultimos_Ejercicios extends App {
  println("\nEJERCICIO 3:")

  case class Entrada(nombre: String, edad: Int, email: String)

  /*  
  val entradas = Map(
    "1" -> Map("nombre" -> "Miguel", "edad" -> 16, "correo" -> "mig@gmail.com"),
    "2" -> Map("nombre" -> "Marcos", "edad" -> 17, "correo" -> "mar@gmail.com"),
    "3" -> Map("nombre" -> "Sara", "edad" -> 18, "correo" -> "sar@gmail.com"),
    "4" -> Map("nombre" -> "Laura", "edad" -> 19, "correo" -> "lau@gmail.com")
  )
  */

  val entradas = List(
    Entrada("Miguel", 16, "mig@gmail.com"),
    Entrada("Marcos", 17, "mar@gmail.com"),
    Entrada("Sara", 18, "sar@gmail.com"),
    Entrada("Laura", 19, "lau@gmail.com")
  )

  val mayoresEdad = entradas.filter(_.edad >= 18).map(_.nombre.toUpperCase())

  // Manera 1
  println("Manera 1:")
  println(mayoresEdad)

  // Manera 2
  println("Manera 2:")
  mayoresEdad.foreach(println)
}