/*Ejercicio 1. Dispositivos electrónicos
 El sistema de Dispositivos electrónicos debe realizar las siguientes acciones:
    - Encender: imprime por pantalla "El dispositivo está encendido"
    - Apagar: imprime por pantalla "El dispositivo está apagado"

  El dispositivo Teléfono debe realizar la acción de Llamar a un número 
     imprimiendo por pantalla "Llamando al número [número]"
  El dispositivo Tablet deber realizar la acción de navegar Web 
     imprimiendo por pantalla "Navengando a [url]"
*/

/* 
Los traits en Scala suelen usarse para definir comportamientos comunes o interfaces. 
Aquí, Dispositivo actúa como un contrato que garantiza que 
cualquier clase que lo implemente 
tendrá las funciones encender y apagar.

Aunque las abstract classes también pueden definir métodos abstractos y concretos, 
los traits son más idóneos cuando el objetivo principal
es compartir comportamiento sin necesidad de definir una jerarquía rígida.
 */



 

// Trait base para los dispositivos
trait Dispositivo {
  def encender(): Unit = println("El dispositivo está encendido")
  def apagar(): Unit = println("El dispositivo está apagado")
}

// Clase Teléfono que implementa Dispositivo
class Telefono extends Dispositivo {
  def llamar(numero: String): Unit = println(s"Llamando al número $numero")
}

// Clase Tablet que implementa Dispositivo
class Tablet extends Dispositivo {
  def navegarWeb(url: String): Unit = println(s"Navegando a $url")
}

// Programa principal
object Ejercicio extends App {
  val telefono = new Telefono
  val tablet = new Tablet

  telefono.encender()            // Salida: El dispositivo está encendido
  telefono.llamar("123-456")     // Salida: Llamando al número 123-456
  telefono.apagar()              // Salida: El dispositivo está apagado

  tablet.encender()              // Salida: El dispositivo está encendido
  tablet.navegarWeb("www.scala-lang.org") // Salida: Navegando a www.scala-lang.org
  tablet.apagar()                // Salida: El dispositivo está apagado
}