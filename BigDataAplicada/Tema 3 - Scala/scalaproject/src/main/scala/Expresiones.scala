object Expresiones extends App {
// 1. Expresión
val x = 1 + 2
println(x)

// 2. Expresión
println(2 + 3 * 4) // + - * /

// 3. Expresión, se evalúa como boolean
println(1 == x) // == != > >= < <=

// 4. Expresión
println((1 == x) || (1 != x)) // && || operadores lógicos

// 5. Expresión
var aVariable = 2
aVariable += 3 // también podemos trabajar con -= *= /=
println(aVariable) // el valor devuelto será 5

// Instrucciones (algo que haga la computadora) vs Expresiones (algo que tiene un valor)
println("\nINTRUCCIONES:")
val aCondicion = true
val aCondicionValor = if (aCondicion) 5 else 3 // IF como expresión no como instrucción
println(aCondicionValor)
println(if(aCondicion) 5 else 3)
println(1 + 3)

// Los bucles en Scala no se realizan así
var i = 0
while (i < 10) {
    print(i)
    i += 1
}
println()

// Se realizan así
var j = 0
val valWhile = while (j < 10) {
    print(j)
    j += 1
}
println()

// BLOQUES DE CÓDIGO
println("\nBLOQUES DE CÓDIGO:")
val aCodBloque = {
    val t = 2
    val z = t + 2

    if (z > 2) "hola" else "adiós"
}
println(aCodBloque)

}