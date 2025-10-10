// Autor: David Roca Tauste

object `1Eval_Actividades` extends App {
  /* ACTIVIDAD 1
  En una tienda de frutas, cada fruta tiene un precio por unidad. Se necesita realizar las
  siguientes operaciones sobre una lista de compras de un cliente:
    1. Filtrar las frutas cuyo precio por unidad sea mayor a 3.
    2. Calcular el precio total para cada fruta filtrada considerando la cantidad comprada.
    3. Generar una lista de mensajes indicando cuánto se gastará por cada fruta en el formato:
    “Fruta: <nombre>, Total: <total>”
  */

  case class Fruta(nombre: String, precio: Double, cantidad: Int)

  val frutas = List(
    Fruta("Manzana", 3.2, 3),
    Fruta("Pera", 1.3, 6),
    Fruta("Melocotón", 8.5, 1),
    Fruta("Granada", 0.7, 5),
    Fruta("Cerezas", 0.4, 5),
    Fruta("Naranja", 3.01, 9)
  )

  // Apartado 1
  val frutasPrecioFiltrado = frutas.filter(_.precio > 3)

  // Apartado 2
  val frutasPrecioTotal = frutasPrecioFiltrado.map(fruta => (fruta.nombre, fruta.precio * fruta.cantidad))

  // Apartado 3
  val listaCompra = frutasPrecioTotal.map {
    // La fórmula ${(precioTotal * 100).round / 100.0} sirve para redondear el precio total a dos decimales y
    // que así sea más claro el resultado.
    case (nombre, precioTotal) => s"\nFruta: $nombre, Total: ${(precioTotal * 100).round / 100.0}"
  }

  print("\nACTIVIDAD 1:")
  listaCompra.foreach(print)



  /* ACTIVIDAD 2
  Sistema de notificaciones que genera mensajes personalizados para los usuarios.

  1. Realizar una función denominada “generaMensaje” con los siguientes parámetros de
  entrada:
    - tipo cadena para indicar el saludo.
    - tipo cadena para indicar el nombre.
    - tipo cadena para indicar el mensaje.
  El resultado de la función debe devolver los tres parámetros en un solo mensaje con el
  siguiente formato:
  saludo, nombre: mensaje.

  2.- Hacer uso de la función generaMensaje para crear otra función denominada
  “saludoCliente” que utilice el saludo “Estimado Cliente”.

  3.- Genera un mensaje completo utilizando saludoCliente para un cliente llamado Carlos con
  el contenido “Su pedido ha sido enviado con éxito”.

  4.- Genera e imprime otro mensaje directamente utilizando generaMensaje con los valores:
  “Hola”, “María”, “Gracias por registrarse en nuestra plataforma”
  */
  println("\n\nACTIVIDAD 2:")

  // Apartado 1
  def generaMensaje(saludo: String, nombre: String, mensaje: String): String = {
    return s"$saludo, $nombre: $mensaje"
  }

  // Apartado 2
  def saludoCliente(nombre: String, mensaje: String): String = {
    return generaMensaje("Estimado Cliente", nombre, mensaje)
  }

  // Apartado 3
  val mensajeCompleto = saludoCliente("Carlos", "Su pedido ha sido enviado con éxito")
  println(mensajeCompleto)

  // Apartado 4
  val mensajeCompleto2 = generaMensaje("Hola", "María", "Gracias por registrarse en nuestra plataforma")
  println(mensajeCompleto2)
}