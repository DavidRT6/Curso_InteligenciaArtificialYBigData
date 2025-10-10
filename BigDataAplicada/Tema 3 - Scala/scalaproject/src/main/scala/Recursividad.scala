object Recursividad extends App {
    // Función 1
  def factorial (n:Int):Int=
    if(n<=1) 1
    else {
        val resultado = n*factorial (n-1)
        resultado
    }
  
  //Este da error.
  //println(factorial(50000))

  // Función 2
  def otroFactorial(n:Int):Int = {
    def factCalcula (x:Int, acumulador: Int): Int=
        if (x<=1) acumulador
        else factCalcula(x-1, x*acumulador)

    factCalcula(n,1)
  }

  //println(otroFactorial(50000))


  // EJERCICIOS
  // 1. Función que concatena una cadena n veces
    def factorialCadena (cadena:String, n:Int): String = {
    def factConcatena (x:Int, cadenaTotal: String): String =
        if (x<1) cadenaTotal
        else factConcatena(x-1, cadenaTotal+cadena)

    var cadenaTotal = ""
    factConcatena(n,cadenaTotal)
    }

    println(factorialCadena("Saludos ", 6))

    // El mío funciona, pero esta es la solución.
    def concatenaTailRec (aString: String, n: Int, acumulador: String): String =
        if (n <= 0) acumulador
        else concatenaTailRec(aString, n - 1, aString + acumulador)

    println(concatenaTailRec("Hola", 12, ""))
}
