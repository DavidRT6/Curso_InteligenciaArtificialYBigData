object EjercicioPropuesto extends App {
  // David Roca Tauste
  // EJERCICIO PROPUESTO
  val reservaEntradas = ReservaEntradas("Concierto de Rock", 50)

  var infoOperacion = reservaEntradas.reservar(10)
  println(infoOperacion)

  infoOperacion = reservaEntradas.cancelarReserva(5)
  println(infoOperacion)

  infoOperacion = reservaEntradas.reservar(60)
  println(infoOperacion)

  infoOperacion = reservaEntradas.mostrarInfo()
  println(infoOperacion)
}

class ReservaEntradas(evento: String, var entradasDisp: Int) {
    val entradasTotales = entradasDisp

    def reservar(numEntradas: Int): String = {
        if (numEntradas > 0) {
            if (numEntradas <= entradasDisp) {
                entradasDisp -= numEntradas
                s"Se han reservado las $numEntradas entradas correctamente!"
            }
            else s"No quedan suficientes entradas. Entradas disponibles: $entradasDisp."
        }
        else "La cantidad introducida no es válida."
    }

    def cancelarReserva(numEntradas: Int ): String = {
        if (numEntradas > 0) {
            if ((numEntradas + entradasDisp) <= entradasTotales) {
                entradasDisp += numEntradas
                s"La cancelación de las $numEntradas entradas se ha realizado correctamente!"
            } 
            else s"La cantidad introducida es incorrecta. Solamente se puede cancelar un total de ${entradasTotales - entradasDisp} entradas."
        }
        else "La cantidad introducida no es válida."
    }

    def mostrarInfo(): String = s"La cantidad de entradas disponibles para el '$evento' es de: $entradasDisp."
}