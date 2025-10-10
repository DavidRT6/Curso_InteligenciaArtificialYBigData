object Ejercicios extends App {
  // David Roca Tauste

  // EJERCICIO 1
  /* Calcular si un número es divisible por otro
  En esta función el primer parámetro se pasa por llamada por valor y el segundo parámetro (divisor) se pasa por llamada por nombre.
    - Si el divisor es igual 0 entonces muestra el siguiente mensaje:
        "El divisor no puede ser 0"
    - Si el divisor es mayor 0 entonces muestra el siguiente mensaje:
        "Calculando si número es divisible por el divisor"
        **número es el valor del parámetro y divisor es el valor del parámetro
  */

  def calcDivisor(numero: Int, divisor: Int): String = {
    if (divisor == 0) "\nEl divisor no puede ser 0"
    else {
        return(
            "\nCalculando si el número es divisible por el divisor\n" +
            s"$numero es el valor del parámetro y $divisor es el valor del parámetro"
        )
    }
  }

  println("\nEJERCICIO 1")
  println(calcDivisor(6, 3))
  println(calcDivisor(6, 0))
  println(calcDivisor(7, 2))


  // EJERCICIO 2
  /* Calcular el total de un pedido con impuestos y envío
  La función que calcula el total de un pedido en línea, donde la función recibe como parámetros:
    - Subtotal: Valor total de los productos
    - Tasa de impuesto: El porcentaje de impuestos a pagar
    - Envio: El coste de envío a pagar

  Una vez realizado el cálculo la función debe devolver un mensaje que muestre la siguiente información con los valores formateados con dos decimales.
    - Precio total
    - Subtotal
    - Tasa de impuestos
    - Envio
  */

  def calcTotalPedido(subtotal: Double, impuesto: Int, envio: Double): String = {
    var precioTotal = subtotal + subtotal*impuesto/100 + envio

    return (
        f"\n- El precio total es: $precioTotal%.2f\n" +
        f"- Subtotal: $subtotal%.2f\n" +
        f"- Tasa de impuestos: $impuesto%.2f\n" +
        f"- Envio: $envio%.2f"
    )
  }

  println("\nEJERCICIO 2")
  println(calcTotalPedido(12.00, 4, 3.75))
  println(calcTotalPedido(33.33, 9, 9.99))


  // EJERCICIO 3
  /* Buscar un elemento en una lista
  Implementa una función que busque si el número existe en la lista de números,
  devolviendo verdadero o falso según sea el caso.
  - Parámetros de la función serán los siguientes:
      List[Int] --> lista de enteros
      numero de tipo Int

      *** Pista:
          Lista.head --> obtenemos el primer elemento de la lista
          Lista.tail --> es una nueva lista que contiene todos los elementos de la lista original excepto el primero
  */

  def buscarNumero(lista: List[Int], numero: Int): Boolean = {
    if (lista.isEmpty) return false
    
    var numeroActual = lista.head
    if (numero == numeroActual) return true
    
    buscarNumero(lista.tail, numero)
  }

  println("\nEJERCICIO 3")
  var listaEj3: List[Int] = List(1,2,3,4,5,6,7,8,9)
  var numero = 10
  if(buscarNumero(listaEj3, numero)) println(s"Se ha encontrado el número $numero!")
  else println(s"El número $numero no se encuentra en la lista.")


  // EJERCICIO 4
  /* Inversión de una lista
  Escribe una función recursiva que reciba una lista y devuelva la misma lista pero invertida.
  Parámetros:
    - Lista de enteros. Lista[Int]

      *** Pista:
          - Nil --> es una lista vacía y es una construcción esencial para trabajar en Scala.
            Se utiliza para terminar la recursión de una lista y sirve como marcador de final de una lista
          - lista.last --> obtener el último elemento de la lista o lanza una excepción si la lista está vacía.
          - lista.init --> para obtener todos los elementos de una lista excepto el último.
  */

  def listaInvertida(lista: List[Int], inversion: List[Int] = List()): List[Int] = {
    if (lista.isEmpty) inversion
    else {
      var numeroFinal = lista.last
      listaInvertida(lista.init, inversion :+ numeroFinal)   // El operador :+ añade el número al final de la lista.
    }
  }

  println("\nEJERCICIO 4")
  val listaOriginal: List[Int] = List(11, 21, 31, 41, 51, 61, 71, 81, 99)
  val listaInvertidaResultado = listaInvertida(listaOriginal)

  println(s"Lista original: $listaOriginal")
  println(s"Lista invertida: $listaInvertidaResultado")


  // EJERCICIO 5
  /* Contar la cantidad de veces que aparece un carácter en una cadena
  Escribe una función recursiva que reciba una cadena de texto y un carácter y devuelva el número de veces que el
  carácter aparece en la cadena.
  Parámetros de entrada:
      - Cadena de texto String y un carácter Char.
  */

  def contarCaracter(cadena: String, caracter: Char): Int = {
    if (cadena.isEmpty) 0
    else {
      val coincidencia = if (cadena.head == caracter) 1 else 0

      val resto = contarCaracter(cadena.tail, caracter)   // Obtiene el número de veces que ha aparecido el carácter.
      coincidencia + resto   // Suma la coincidencia actual al conteo total.
    }
  }

  println("\nEJERCICIO 5")
  val texto = "Hola buenos días"
  val caracterBuscado = 'a'

  val numVeces = contarCaracter(texto, caracterBuscado)
  println(s"El carácter '$caracterBuscado' aparece $numVeces veces en la cadena '$texto'.")

  // Otra manera de hacer el print
  // println(s"El carácter '$caracterBuscado' aparece ${contarCaracter(texto, caracterBuscado)} veces en la cadena '$texto'.")

}
