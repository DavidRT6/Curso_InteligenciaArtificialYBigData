// Definimos una clase genérica covariante
class Contenedor[+T](val item: T) {
  def obtener: T = item
}
// Jerarquía de tipos
class Objeto
class Coche extends Objeto
class Bicicleta extends Objeto
object CovarianzaSencilla extends App {
  // Creamos un contenedor para un coche
  val contenedorCoche: Contenedor[Coche] = new Contenedor(new Coche)
  // Debido a la covarianza (+T), podemos tratar el contenedor de coches
  // como un contenedor de objetos
  val contenedorObjeto: Contenedor[Objeto] = contenedorCoche
  // Trabajamos con el contenedor como si fuera de tipo Objeto
  println(contenedorObjeto.obtener.getClass.getSimpleName) // Salida: Coche
}