object Actividad_mascota extends App{
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



    // Crear una mascota
    val mascota = new Mascota("Firulais", "Correr")

    // Mostrar información inicial
    mascota.mostrarInfo()

    // Cambiar la actividad favorita
    mascota.cambiarActividad("Jugar con la pelota")

    // Mostrar información actualizada
    mascota.mostrarInfo()
  
}

// Clase Mascota
class Mascota(val nombre: String, var actividadFavorita: String) {

  // Método para cambiar la actividad favorita
  def cambiarActividad(nuevaActividad: String): Unit = {
    actividadFavorita = nuevaActividad
    println(s"La actividad favorita de $nombre ahora es '$actividadFavorita'.")
  }

  // Método para mostrar información de la mascota
  def mostrarInfo(): Unit = {
    println(s"Mascota: $nombre, Actividad favorita: $actividadFavorita")
  }
}