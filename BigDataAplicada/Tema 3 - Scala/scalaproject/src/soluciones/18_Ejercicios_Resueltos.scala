object Ejercicios extends App {

  /* Ejercicio 1:
        Dado un mapa de productos, escribe una función que reciba el Identificador de un producto y devuelva la descripción.
        Si no se encuentra, devuelve la siguiente descripción "Producto no disponible"
  */
   /*Ejercicio 1*/ 
    def obtenerDescripcionProducto(productos: Map[Int, String], id: Int): String = {
     productos.get(id) match {
         case Some(descripcion) => descripcion
         case None => "Producto no disponible"
       }
    }

   val productos = Map(1 -> "Laptop", 2 -> "Smartphone", 3 -> "Tablet")
   println(obtenerDescripcionProducto(productos, 2)) // Salida: Smartphone
   println(obtenerDescripcionProducto(productos, 5)) // Salida: Producto no disponible
  
  /*Ejercicio 2
      Crea una función que reciba un valor de tipo Any y determine si es un número, una cadena, un boolean o algo más. 
      Imprime por pantalla una descripción que indique el tipo.
  */

  /*Ejercicio 2*/
   def identificarTipo(valor: Any): String = {
   valor match {
    case i: Int => s"El valor es un número entero: $i"
    case s: String => s"El valor es una cadena: '$s'"
    case b: Boolean => s"El valor es un booleano: $b"
    case _ => "El valor es de un tipo desconocido"
    }
 }

   println(identificarTipo(42))         // Salida: El valor es un número entero: 42
   println(identificarTipo("Scala"))   // Salida: El valor es una cadena: 'Scala'
   println(identificarTipo(true))      // Salida: El valor es un booleano: true
   println(identificarTipo(3.14))      // Salida: El valor es de un tipo desconocido

  /*Ejercicio 3
      Crea una función que reciba una tupla anidada del tipo (Int, (Int, Int)) y devuelva la suma de todos los números
  */

   /*Ejercicios 3*/
   def sumarTuplaAnidada(tupla: (Int, (Int, Int))): Int = {
   tupla match {
      case (a, (b, c)) => a + b + c
   }
 }

  val tupla = (1, (2, 3))
  println(sumarTuplaAnidada(tupla)) // Salida: 6

}