import scala.compiletime.ops.float
object StringOps extends App {
  val str: String = "Hola, eztoy aprendiendo a escribih"

  // 1. charAt --> accede al carácter en el índice 2 de la cadena
  println(str.charAt(2))

  // 2. subString --> devuelve los carácteres de la posición 7 hasta 11
  println(str.substring(7,11))

  // 3. split --> se utiliza para dividir la cadena en partes
  // toList convierte un aaray resultante del split en una lista de Scala
  println(str.split(" ").toList)

  // 4. startsWith --> verifica si el string comienza por el valor indicado
  println(str.startsWith("Hola"))

  // 5. replace --> reemplaza un carácter por otro
  println(str.replace(" ", "-"))

  // 6. toLowerCase --> convierte todos los carácteres de la cadena en minúsculas
  println(str.toLowerCase())

  // 7. length --> devuelve la longitud
  println(str.length)

  // 8. +: operador para añadir al inicio de la cadena. :+ operador para añadir al final de la cadena
  val aNumberString = "2"
  val aNumber = aNumberString.toInt

  println("a" +: aNumberString :+ "z")

  // 9. reverse --> imprime al revés la cadena
  println(str.reverse)

  // 10. take (2) --> devuelve los dos primeros carácteres de la cadena
  println(str.take(2))

  // 11. Scala-specific: String interpolators ---s-interpolators
  // Esto permite insertar valores de variables directamente en el texto utilizando el símbolo 's'
  val name = "David"
  val edad = "19"
  val presenta = s"Hola, mi nombre es $name y tengo $edad años"
  val otroPresenta = s"Hola, mi npmbre es $name y cumpliré ${edad+1} años"
  println(otroPresenta)

  // 12. F-interpolators
  /* 
  El prefijo f permite especificar el formato para los valores interpolados dentro de la cadena.
  %nombre%s --> %s: Indica que el valor de la variable nombre debe tratarse como una cadena de texto (string).
  $velocidad%2.2f --> %f: Indica que el valor de velocidad es un número en punto flotante (float).
  2.2:
    El primer 2 especifica que el número tendrá un ancho mínimo de 2 carácteres (rellenará espacios si el número es más corto).
    El segundo 2 especifica que tendrá 2 dígitos después del punto decimal.
  */
  val velocidad = 1.2f
  val nombre = "Roberto"
  println(f"$nombre%s puede comer $velocidad%2.2f bocadillos por minuto")

  // 13. raw-interpolator --> los carácteres especiales se imprimen literalmente, sin efectos especiales.
  println("Esto es una \n nueva linea")
  println(raw"Esto es una \n nueva linea")
  val linea = "Esto es una \n nueva linea"
  println(raw"$linea")


  /* 
  Ejercicio. Calcula descuento:
    Realiza una función que reciba los siguientes parámetros:
        - precio del producto
        - porcentaje de descuento
    
        La función debe calcular el precio final después de aplicar el descuento.
        Si el descuento es mayor o igual a 50, debe devolver una advertencua:
            "Precio final: [preciofinal]. ¡Descuento muy alto!"
        Si el descuento es menor a 50, simplemente devuelve:
            "Precio final: [preciofinal]"

    Una vez implementada la función, realiza las siguientes llamadas:
        - Calcula descuento precio de 100.
        - Calcula descuento precio de 200 y descuento de 20.
        - Calcula descuento precio de 300 y descuento de 50.
   */

   println("\nEJERCICIO: CALCULA DESCUENTO")

   def calcPrecioFinal(precio: Int, porcDescuento: Int): Unit = {
    var precioFinal = precio - (porcDescuento*precio/100)
    var diferencia = precio - precioFinal

    if (diferencia >= 50) println(s"Precio final: $precioFinal. ¡Descuento muy alto!")
    else println(s"Precio final: $precioFinal")
   }

   calcPrecioFinal(100, 0)
   calcPrecioFinal(200, 20)
   calcPrecioFinal(300, 50)
}
