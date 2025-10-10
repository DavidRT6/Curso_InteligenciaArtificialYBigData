object Funciones extends App {

// Función 1
def aFuncion1(a: String, b: Int): String = {
a + " " + b
}

println(aFuncion1("Hola", 3))

// Función 2
def aFuncion2(a: String, b: Int) = {
  a + " " + b
}

println(aFuncion2("Hola", 3))

// Función 3
def aParametrosFuncion(): Int = 42
println(aParametrosFuncion())
// println(aParametrosFuncion)

// Función 4
// Cuando necesites bucles, usa recursividad
def aRecursivaFuncion1(aString: String, n: Int): String = {
  if (n == 1) aString
  else aString + aRecursivaFuncion1(aString, n - 1)
}

println(aRecursivaFuncion1("Hola", 3))

// Función 5
def principalFuncion (n: Int): Int = {
    def secundariaFuncion (a: Int, b: Int): Int = a + b
    secundariaFuncion(n, n - 1)
}

println(principalFuncion(33))


// EJERCICIOS
// 1. Función de saludar func􀆟on (nombre, edad) => "Hola, mi nombre es $nombre y tengo $edad años."
def saludar(nombre: String, edad: Int) = {
    var salida = "Hola, mi nombre es "+ nombre +" y tengo " + edad + " años."
    println(salida)
}

println("\nEJERCICIO 1:")
saludar("David", 19)

// 2. Función factorial 1 * 2 * 3 * 4 * 5 * ... * n
def factorial(limite: Int): Int = {
  var i = 0
  var multiplicador = 1
  val bucle = while (i < limite) {
    if (i != 0) {
      multiplicador *= i
    }
    i += 1
  }
  
  return multiplicador
}

val limite = 5
var valorFactorial = factorial(limite)
println("\nEJERCICIO 2:")
println("El valor factorial hasta " + limite + " es: " + valorFactorial)

// 3. Función de test si el número es primo
println("\nEJERCICIO 3:")

// Primo
def esPrimo(i: Int): Boolean = {
  if (i <= 1) false
  else if (i == 2) true
  else !(2 to (i - 1)).exists(x => i % x == 0)
}

println(esPrimo(13))

// Primo, pero con valores pequeños
def primito(i: Long, divisor: Int = 2): Boolean = {
  if (i <= 1) false
  else if (divisor > math.sqrt(i)) true
  else if (i % divisor == 0) false
  else primito(i, divisor + 1)
}

println(primito(44))
// Da error porque el número es muy grande
// println(primito(485720934857209348571))

}
