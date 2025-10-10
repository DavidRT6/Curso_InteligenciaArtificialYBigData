object `NumeroEsPrimo` extends App {
  // David Roca

  // EJERCICIO 3
  // Función de test para comprobar si un número es primo o no.
  def esPrimo(numero: Int): Boolean = {
    if (numero <= 1) return false
    else if (numero == 2) return true
    else if (numero % 2 == 0) return false
    else {
        !(3 to Math.sqrt(numero).toInt by 2).exists(i => numero % i == 0)
    }
  }

  var numero = 29
  // Manera más óptima
  if (esPrimo(numero)) println("El número " + numero + " es primo!") else println("El número " + numero + " no es primo.")

  // Manera más legible
  /* 
  if (esPrimo(numero)) {
    println("El número " + numero + " es primo!")
  } else {
    println("El número " + numero + " no es primo.")
  }
 */
}


/* 
Explicación función: !(3 to Math.sqrt(numero).toInt by 2).exists(i => numero % i == 0)
---
Vamos a desglosar esta expresión paso a paso para entender cómo funciona:

Expresión:
!(3 to Math.sqrt(numero).toInt by 2).exists(i => numero % i == 0)

1. 3 to Math.sqrt(numero).toInt by 2:
- 3 to Math.sqrt(numero).toInt: Esto genera un rango de números que empieza en 3 y termina en la raíz cuadrada del número (numero), convertida a entero. Por ejemplo, si numero = 17, la raíz cuadrada es aproximadamente 4.12, y al convertir a entero obtenemos 4. Así que el rango será 3 to 4, que contiene solo el número 3.
- by 2: Esto indica que queremos iterar solo por los números impares en ese rango. Por ejemplo, si el rango inicial es 3 to 10, con by 2 obtendremos 3, 5, 7, 9.
Resultado: Una lista de números impares entre 3 y la raíz cuadrada del número.

2. .exists(i => numero % i == 0):
- exists: Es un método en Scala que verifica si al menos un elemento en la colección cumple con una condición. Si encuentra uno que cumple, devuelve true; si no encuentra ninguno, devuelve false.
- i => numero % i == 0: Esta es una función lambda que toma un número i del rango y verifica si numero % i es igual a 0. Esto comprueba si i divide a numero sin residuo.
Resultado: Devuelve true si algún número impar entre 3 y la raíz cuadrada de numero divide a numero. De lo contrario, devuelve false.

3. Negación con !:
- El operador ! invierte el resultado de exists. Si exists devuelve true (es decir, encontró un divisor), el ! lo convierte en false. Si no encontró divisores (exists devuelve false), el ! lo convierte en true.

Significado final:
- Si ningún número impar en el rango divide al número, el resultado será true (porque no tiene divisores, es primo).
- Si algún número impar lo divide, el resultado será false (porque no es primo).
-----
-----
Ejemplo práctico:
Supongamos que queremos verificar si numero = 17 es primo:

1. Rango:
3 to Math.sqrt(17).toInt by 2 → 3 to 4 by 2 → [3].

2. exists:
- Evalúa si 17 % i == 0 para i = 3. Resultado: 17 % 3 = 2 (no es divisible).
- Como no se encuentra ningún divisor, exists devuelve false.

Negación:
- !false → true.
Resultado: 17 es primo.

Espero que esta explicación aclare cómo funciona la expresión.
---
 */