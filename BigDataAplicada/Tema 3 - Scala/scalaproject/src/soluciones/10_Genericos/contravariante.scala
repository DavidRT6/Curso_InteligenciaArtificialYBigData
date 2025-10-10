// Definimos una jerarquía de clases
class Documento
class Reporte extends Documento
class Factura extends Documento
// Definimos una clase contravariante
class Impresora[-A] {
  def imprimir(documento: A): Unit = println(s"Imprimiendo ${documento.getClass.getSimpleName}")
}
object Contravariante extends App {
   // Una impresora que puede imprimir cualquier tipo de documento
  val impresoraGeneral: Impresora[Documento] = new Impresora[Documento]
  // Como es contravariante, podemos asignarla a una impresora específica para reportes
  val impresoraReporte: Impresora[Reporte] = impresoraGeneral
  // Usamos la impresora específica para imprimir un reporte
  impresoraReporte.imprimir(new Reporte)
  // También podemos imprimir facturas porque la impresora original acepta cualquier Documento
   impresoraGeneral.imprimir(new Factura)
}

