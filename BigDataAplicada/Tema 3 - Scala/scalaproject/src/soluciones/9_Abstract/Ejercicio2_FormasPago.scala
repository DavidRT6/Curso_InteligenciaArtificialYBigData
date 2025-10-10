/*Ejercicio 2. Formas de pago
 Sistema de Formas de pago deber cumplir que:
    - Todas las formas de pago deben procesar el pago pasándole una cantidad.
    - La forma de pago Tarjeta de Crédito debe imprimir por pantalla: 
        "Procesando pago de [cantidad] con tarjeta de crédito"
    - La forma de pago PayPal debe imprimir por pantalla:
        "Procesando pago de [cantidad] con PayPal"
    - La forma de pago Transferencia Bancaria debe imprimir por pantalla:
        "Procesnado pago de [cantidad] mediante transferencia bancaria"
*/

// Clase abstracta o Trait base para los métodos de pago
abstract class FormaPago {
  def procesarPago(cantidad: Double): Unit
}

// Implementación para Tarjeta de Crédito
class TarjetaCredito extends FormaPago {
  def procesarPago(cantidad: Double): Unit = 
    println(s"Procesando pago de $cantidad con tarjeta de crédito")
}

// Implementación para PayPal
class PayPal extends FormaPago {
  def procesarPago(cantidad: Double): Unit = 
    println(s"Procesando pago de $cantidad con PayPal")
}

// Implementación para Transferencia Bancaria
class TransferenciaBancaria extends FormaPago {
  def procesarPago(cantidad: Double): Unit = 
    println(s"Procesando pago de $cantidad mediante transferencia bancaria")
}


object Ejercicio2 extends App {
  val tarjeta = new TarjetaCredito
  val paypal = new PayPal
  val transferencia = new TransferenciaBancaria

  tarjeta.procesarPago(100.0)      // Salida: Procesando pago de 100.0 con tarjeta de crédito
  paypal.procesarPago(200.0)       // Salida: Procesando pago de 200.0 con PayPal
  transferencia.procesarPago(300.0) // Salida: Procesando pago de 300.0 mediante transferencia bancaria
}