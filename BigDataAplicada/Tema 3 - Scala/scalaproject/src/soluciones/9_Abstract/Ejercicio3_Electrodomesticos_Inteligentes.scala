/*Ejercicio 3: Electrodomésticos Inteligentes
 El sistema de Electrodomésticos Inteligentes debe cumplir que:
    - Algunos electrodomésticos tienen la función de conexión WiFi que imprime por pantalla
      "Conectando el electrodomésticos a la red WiFi"
    - Algunos otros tienen la función de programación automática donde se les pasa el tiempo e 
    imprime por pantalla "Programando electrodoméstico a las [tiempo]"

    El electrodoméstico Lavadora puede conectarse a WiFi y ser programada.
    El electrodoméstico Refrigerador puede conectarse a WiFi.
*/

// Trait para conexión a Wi-Fi
trait ConectividadWifi {
  def conectarWifi(): Unit = println("Conectando el electrodoméstico a la red Wi-Fi")
}

// Trait para programación automática
trait ProgramacionAutomatica {
  def programar(tiempo: String): Unit = println(s"Programando electrodoméstico a las $tiempo")
}

// Clase Lavadora que mezcla ambos traits
class Lavadora extends ConectividadWifi with ProgramacionAutomatica

// Clase Refrigerador que solo mezcla el trait ConectividadWifi
class Refrigerador extends ConectividadWifi

object Ejercicio3 extends App {
  val lavadora = new Lavadora
  val refrigerador = new Refrigerador

  println("Lavadora:")
  lavadora.conectarWifi()         // Salida: Conectando el electrodoméstico a la red Wi-Fi
  lavadora.programar("08:00 AM")  // Salida: Programando electrodoméstico a las 08:00 AM

  println("\nRefrigerador:")
  refrigerador.conectarWifi()     // Salida: Conectando el electrodoméstico a la red Wi-Fi
  // refrigerador.programar("09:00 AM") // Error: Refrigerador no puede ser programado
}