// David Roca Tauste

object FuncionesApartado12 extends App {
  /*
  EJERCICIO 1:
  Realiza una función con dos parámetros de tipo cadena y el resultado es su concatenación.
  */
  val concatenaCadenas = new Function2[String, String, String] {
    override def apply(string1: String, string2: String): String = string1 + string2
  }

  println("\nEJERCICIO 1:")
  println(concatenaCadenas("hola", "Buenos días"))


  /* 
  EJERCICIO 2:
  Define una función que toma como argumentos un entero y otra función que la cual toma
  otro entero y retorna otro entero:
    - ¿Cuál es el tipo de esta función? Respuesta: es una función de 3 argumentos (2 de entrada y 1 de salida)
    - ¿Cómo hacer esto?
  */
  val funcionEntero = new Function2[Int, Function1[Int, Int], Int] {
    override def apply(num: Int, funcionElevar: Function1[Int, Int]): Int = funcionElevar.apply(num)
  }

  val elevarAlCuadrado = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * x
  }

  val resultado = funcionEntero.apply(7, elevarAlCuadrado)

  println("\nEJERCICIO 2:")
  println(s"El resultado es: $resultado")
}



object FuncionesOrdenSuperiorHOF extends App {
  // EJERCICIO 1
  def superMult(x: Int): Int => Int = new Function1[Int, Int] {
    def apply(y: Int): Int = x * y
  }

  val multPorCinco: Int => Int = superMult(5)

  println("EJERCICIO 1:")
  println(multPorCinco(7))


  // EJERCICIO 2
  // Manera 1
  def superConcatenar(prefijo: String): String => String = {
    (texto: String) => prefijo + " " + texto
  }

  // Manera 2
  def superConcatenar2(prefijo: String): String => String = new Function1[String, String] {
    def apply(texto: String): String = prefijo + " " + texto
  }

  val concatenarHola: String => String = superConcatenar("Hola")
  val concatenarHola2: String => String = superConcatenar2("Hola")

  println("\nEJERCICIO 2:")
  println(concatenarHola("qué tal"))
  println(concatenarHola2("buenos días"))


  // EJERCICIO 3
  println("\nEJERCICIO 3:")

  // Tarea 1
  def generaMensaje(saludo: String, nombre: String, mensaje: String): String = {
    return s"$saludo, $nombre: $mensaje"
  }

  // Tarea 2
  def saludoCliente(nombre: String, mensaje: String): String = {
    return generaMensaje("Estimado Cliente", nombre, mensaje)
  }

  // Tarea 3
  val mensajeCompleto = saludoCliente("Carlos", "Su pedido ha sido enviado con éxito")
  println(mensajeCompleto)

  // Tarea 4
  val mensajeCompleto2 = generaMensaje("Hola", "María", "Gracias por registrarse en nuestra plataforma")
  println(mensajeCompleto2)
}