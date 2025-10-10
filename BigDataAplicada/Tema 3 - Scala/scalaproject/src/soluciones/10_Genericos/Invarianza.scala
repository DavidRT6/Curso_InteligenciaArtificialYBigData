// Definimos una clase genérica Caja
class Caja[T](val contenido: T) {
  def obtener: T = contenido
}
// Jerarquía de tipos
class Fruta
class Manzana extends Fruta
class Platano extends Fruta
object InvarianzaSencilla extends App {
  // Creamos una caja para manzanas
  val cajaManzana: Caja[Manzana] = new Caja(new Manzana)
  // La invarianza NO permite asignarla a una caja de frutas
  // val cajaFruta: Caja[Fruta] = cajaManzana // Esto da un ERROR
  // Trabajamos con cada caja en su propio tipo
  println(cajaManzana.obtener.getClass.getSimpleName) // Salida: Manzana
}