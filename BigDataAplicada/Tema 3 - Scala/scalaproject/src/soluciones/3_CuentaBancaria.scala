object Cuenta_bancaria extends App {
  /* Ejercicio 2: Cuenta Bancaria
  Simula las operaciones básicas de una cuenta bancaria.
   Datos de la cuenta:
      Número de cuenta: 987654321
      Saldo inicial: 1000
    Operaciones:
      - Depositar 500
      - Retirar 200
      - Intentar retirar 1500 (¡cuidado excede el saldo!)
      - Mostrar información de la cuenta bancaria actualizada

    Clase CuentaBancaria:
      - Contiene parámetros de entrada para el número de cuenta, saldo actual de la cuenta.
      - Métodos:
           - depositar(cantidad: Double): 
             1.- Incrementa el saldo si la cantidad es mayor que 0. 
                 Muestra el siguiente mensaje por pantalla con el total depositado y el saldo actual:
                   "Se han depositado 500 en la cuenta 987654321. Saldo actual: 1500"
             2.- Muestra el siguiente mensaje por pantalla si la cantidad es menor de 0 o 
             igual a 0:
                 " No se puede depositar una cantidad negativa o cero" 
            
            ***Pista: saldo += cantidad

           - retirar(cantidad: Double): Disminuye el saldo si la cantidad es mayor que 0 y 
              no excede el saldo disponible. 
              1.- Si la cantidad es mayor que saldo muestra el siguiente mensaje por pantalla:
                "No hay suficiente saldo para retirar 1500. Saldo actual: 1300"
              2.- Si la cantidad es menor que saldo muestra el siguiente mensaje por pantalla:
                "Se han retirado 200 de la cuenta 987654321. Saldo actual: 1300"
              3.- Si la cantidad es negativa o 0 muestra el siguiente mensaje por pantalla:
                "No se puede retirar una cantidad negativa o cero"
            ***Pista: saldo -= cantidad

            - mostrarInfo(): Muestra los detalles de la cuenta, incluyendo el número de cuenta y el saldo actual.
  */








 // Crear una cuenta bancaria
  val cuenta = new CuentaBancaria("987654321", 1000.0)

  // Mostrar información inicial
  cuenta.mostrarInfo()

  // Operaciones con la cuenta
  cuenta.depositar(500)       // Depositar 500
  cuenta.retirar(200)         // Retirar 200
  cuenta.retirar(1500)        // Intentar retirar 1500 (saldo insuficiente)
  cuenta.mostrarInfo()        // Mostrar información actualizada

}

// Clase CuentaBancaria
class CuentaBancaria(val numeroCuenta: String, var saldo: Double) {

  // Método para depositar dinero
  def depositar(cantidad: Double): Unit = {
    if (cantidad > 0) {
      saldo += cantidad
      println(s"Se han depositado $cantidad en la cuenta '$numeroCuenta'. Saldo actual: $saldo")
    } else {
      println("No se puede depositar una cantidad negativa o cero.")
    }
  }

  // Método para retirar dinero
  def retirar(cantidad: Double): Unit = {
    if (cantidad > saldo) {
      println(s"No hay suficiente saldo para retirar $cantidad. Saldo actual: $saldo")
    } else if (cantidad > 0) {
      saldo -= cantidad
      println(s"Se han retirado $cantidad de la cuenta '$numeroCuenta'. Saldo actual: $saldo")
    } else {
      println("No se puede retirar una cantidad negativa o cero.")
    }
  }

  // Método para mostrar información de la cuenta
  def mostrarInfo(): Unit = {
    println(s"Cuenta: $numeroCuenta, Saldo: $saldo")
  }
}