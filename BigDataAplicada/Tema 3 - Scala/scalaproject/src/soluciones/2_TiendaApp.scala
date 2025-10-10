object TiendaApp extends App{

/* 
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
     - Contiene parámetros de entrada para el nombre, precio y cantidad en stock.
     - Métodos:
        - vender(cantidad: Int): Reduce el stock si hay suficiente cantidad disponible y
         la cantidad es mayor que 0.
          Muestra un mensaje de error por pantalla si no hay suficiente 
          stock o si la cantidad es inválida.
          *** Pista: cantidadEnStock -= cantidad

        - agregarStock(cantidad: Int): Aumenta el stock si la cantidad es mayor que 0. 
          Muestra un mensaje por pantalla de la cantidad añadida.
          ***Pista: cantidadEnStock += cantidad

        - mostrarInfo(): Imprime por pantalla los detalles del producto (Producto, precio
         y cantidad)

  */


 // Simulación de operaciones
 // Crear un producto
  val producto = new Producto("Camiseta", 25.0, 20)

  // Mostrar información inicial
  producto.mostrarInfo()

  // Operaciones con el producto
  producto.vender(5)          // Vender 5 camisetas
  producto.agregarStock(10)   // Agregar 10 camisetas al stock
  producto.mostrarInfo()      // Mostrar información actualizada
}


// Clase Producto
class Producto(val nombre: String, var precio: Double, var cantidadEnStock: Int) {

  // Método para vender productos
  def vender(cantidad: Int): Unit = {
    if (cantidad <= cantidadEnStock) {
      cantidadEnStock -= cantidad
      println(s"Se han vendido $cantidad unidades de '$nombre'. Stock restante: $cantidadEnStock")
    } else {
      println(s"No hay suficiente stock de '$nombre'. Stock actual: $cantidadEnStock")
    }
  }

  // Método para agregar stock
  def agregarStock(cantidad: Int): Unit = {
    cantidadEnStock += cantidad
    println(s"Se han agregado $cantidad unidades de '$nombre'. Stock actual: $cantidadEnStock")
  }

  // Método para mostrar información del producto
  def mostrarInfo(): Unit = {
    println(s"Producto: $nombre, Precio: $$precio, Stock: $cantidadEnStock")
  }
}