object Anotaciones_Ejercicios extends App {
  /* Ejercicio 1: Mascota y su actividad favorita
    Simula la creación y gestión de una mascota con un nombre y una actividad favorita.

    Datos de la mascota:
    - Nombre
    - Actividad favorita

    Operaciones:
    - Cambiar la actividad favorita a Jugar con la pelota.
    - Mostrar la información actualizada de la mascota.

    Clase Mascota:
    - Contiene los parámetros de entrada nombre y actividad favorita
    - Métodos:
        - cambiarActividad(nuevaActividad: String): Cambia la actividad favorita de la mascota.
        - mostrarInfo(): Muestra los detalles de la mascota, incluyendo su nombre y actividad favorita.
  */

  println("\nEJERCICIO 1:")

  var mascota = new Mascota("Pancho", "Perseguir pájaros")
  mascota.mostrarInfo()
  mascota.cambiarActividad("Jugar con la pelota")
  mascota.mostrarInfo()


  /* Ejercicio 2 
  Ejercicio TiendaApp:
    Simula las operaciones de venta y reposición en una tienda.
    Datos del producto:
        - nombre: Camiseta
        - precio: 25
        - Cantidad en stock = 20
    Operaciones:
        - Vender 5 camisetas
        - Agregar 10 camisetas al stock
        - Mostrar información actualizada

    Clase Producto:
        - Contiene atributos para el nombre, precio y cantidad en stock.
        - Métodos:
            - vender(cantidad: Int): Reduce el stock si hay suficiente cantidad disponible y la cantidad es mayor que 0.
            Muestra un mensaje de error por pantalla si no hay suficiente stock o si la cantidad es inválida.
            - agregarStock(cantidad: Int): Aumenta el stock si la cantidad es mayor que 0.
            Muestra un mensaje de error por pantalla si la cantidad es inválida.
            - mostrarInfo(): Imprime por pantalla los detalles del producto (Producto, precio y cantidad)
  */

  println("\nEJERCICIO 2:")

  var producto = new Producto("Camiseta", 25.0, 20)
  producto.mostrarInfo()
  producto.vender(5)
  producto.agregarStock(10)
  producto.mostrarInfo()

  /* 
  Clase CuentaBancaria:
    - Contiene parámetros de entrada para el número de cuenta, saldo actual de la cuenta.
    - Métodos:
    - depositar(cantidad: Double):
        1.- Incrementa el saldo si la cantidad es mayor que 0.
            Muestra el siguiente mensaje por pantalla con el total depositado y el saldo actual:
            "Se han depositado 500 en la cuenta 987654321. Saldo actual: 1500"
        2.- Muestra el siguiente mensaje por pantalla si la cantidad es menor de 0 o igual a 0:
            "No se puede depositar una cantidad negativa o cero"

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
   */

  println("\nEJERCICIO 3:")
  var cuentaBancaria = new CuentaBancaria(123465, 3210.0)

  cuentaBancaria.depositar(500.0)
  cuentaBancaria.depositar(-1.0)
  cuentaBancaria.retirar(300.0)
  cuentaBancaria.retirar(10000.0)

  cuentaBancaria.mostrarInfo()

}


// EJERCICIO 1
class Mascota(nombre: String, var actividadFavorita: String) {
  def cambiarActividad(nuevaActividad: String): Unit = actividadFavorita = nuevaActividad
  def mostrarInfo(): Unit = {
    println(s"\nDetalles de la mascota:\n  -Nombre: $nombre\n  -Actividad favorita: $actividadFavorita")
  }
}


// EJERCICIO 2
class Producto(nombre: String, precio: Double, var stock: Int) {
    def vender(cantidad: Int): Unit = {
        if (cantidad > 0) {
            if (stock >= cantidad) stock -= cantidad
            else println(s"No queda stock suficiente. Stock actual: $stock")
        }
        else println("La cantidad introducida es inválida")
    }
    
    def agregarStock(cantidad: Int): Unit = {
        if (cantidad > 0) stock += cantidad
        else println("La cantidad introducida es inválida")
    }

    def mostrarInfo(): Unit = println("\nDetalles del producto:\n" +
      s" -Nombre: $nombre\n" +
      s" -Precio: $precio\n" +
      s" -Cantidad: $stock")
}


// EJERCICIO 3
class CuentaBancaria(numeroCuenta: Int, var saldoActual: Double) {
    def depositar(cantidad: Double): Unit = {
        if (cantidad > 0) {
            saldoActual += cantidad
            println(s"Se han depositado $cantidad euros en la cuenta $numeroCuenta. Saldo actual: $saldoActual")
        }
        else println("No se puede depositar una cantidad negativa o cero.")
    }

    def retirar(cantidad: Double): Unit = {
        if (cantidad > 0) {
            if (cantidad <= saldoActual) {
                saldoActual -= cantidad
                println(s"Se han retirado $cantidad euros de la cuenta $numeroCuenta. Saldo actual: $saldoActual")
            }
            else println(s"No hay suficiente saldo para retirar $cantidad euros. Saldo actual: $saldoActual")
        }
        else println("No se puede retirar una cantidad negativa o cero.")
    }
    
    def mostrarInfo(): Unit = {
        println("\nInformación de la cuenta:\n" +
          s" -Número de cuenta: $numeroCuenta\n" +
          s" -Saldo actual: $saldoActual")
    }
}