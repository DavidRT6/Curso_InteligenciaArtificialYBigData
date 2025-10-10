object ValuesVariablesTypes extends App {
//VALUES 
  // Ejemplo 1
  val x: Int = 42
  println(x)

  // Ejemplo 2
  val y = 42
  println(y)

  // Ejemplo 3: Esto no es posible hacerlo (está hecho aposta)
  // val t: Int = "Hola"
  // println(t)

  // Ejemplo 4
  val aTexto: String = "Hola"
  val aTexto1 = "adios"

  // Otra manera
  //val aTexto: String = "Hola";  val aTexto1 = "adios"

  // Ejemplo 5
  println("\nEJEMPLO 5:")
  val aBoolean: Boolean = false
  val aCaracter: Char = 'a'
  println(aCaracter)

  val aEntero: Int = x
  println(aEntero)

  // Short se representa en dos bytes en lugar de cuatro
  val aShort: Short = 4613
  // Este da error porque es un número demasiado grande
  // val aLong: Long = 3243254569489328
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14


  // VARIABLES
  var aVariable: Int = 4
  aVariable = 5

  val x1: Int = 42

  var x2: Int = 1
  x2 = 1
  x2 += 1
}
