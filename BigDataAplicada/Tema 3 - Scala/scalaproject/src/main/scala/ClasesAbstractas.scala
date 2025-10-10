/*Ejercicio 1. Dispositivos electrónicos

  El sistema de Dispositivos electrónicos debe realizar las siguientes acciones:
  - Encender: imprime por pantalla "El dispositivo está encendido"
  - Apagar: imprime por pantalla "El dispositivo está apagado"

  El dispositivo Teléfono debe realizar la acción de Llamar a un número
  imprimiendo por pantalla "Llamando al número [número]"

  El dispositivo Tablet debe realizar la acción de navegar Web
  imprimiendo por pantalla "Navegando a [url]"
*/
object ClasesAbstractas_1 extends App {
  val dispositivo1 = new Dispositivo {}
  dispositivo1.encender()
  dispositivo1.apagar()
  println()

  val dispositivo2 = new Telefono {}
  dispositivo2.encender()
  dispositivo2.llamar()
  dispositivo2.apagar()
  println()

  val dispositivo3 = new Tablet {}
  dispositivo3.navegar()
}

trait Dispositivo {
    def encender(): Unit = println("El dispositivo está encendido")
    def apagar(): Unit = println("El dispositivo está apagado")
}

class Telefono extends Dispositivo {
    def llamar(): Unit = println("Llamando al número [número]")
}

class Tablet extends Dispositivo {
    def navegar(): Unit = println("Navegando a [url]")
}


// EJERCICIO 2
object ClasesAbstractas_2 extends App {
  val pago1 = new TarjetaCredito
  pago1.procesarPago(12.33)

  val pago2 = new Paypal
  pago2.procesarPago(33.6)

  val pago3 = new Transferencia
  pago3.procesarPago(1233.1)
}

abstract class FormaPago {}

class TarjetaCredito extends FormaPago {
    def procesarPago(cantidad: Double): Unit = println(s"Procesando pago de $cantidad con tarjeta de crédito")
}

class Paypal extends FormaPago {
    def procesarPago(cantidad: Double): Unit = println(s"Procesando pago de $cantidad con PayPal")
}

class Transferencia extends FormaPago {
    def procesarPago(cantidad: Double): Unit = println(s"Procesando pago de $cantidad mediante transferencia bancaria")
}


// EJERCICIO 3
object ClasesAbstractas_3 extends App {
  

}

abstract class Electrodomestico {}



trait ConectividadWifi {
    def conectarWifi(): Unit = println("Conectando el electrodoméstico a la red Wi-Fi")
}

trait ProgramacionAutomatica {
    def programar(tiempo: String): Unit = println
}


// EJERCICIO 4
object ClasesAbstractas_4 extends App {
  

}

abstract class Robot(modelo: String, bateria: Int) {

}