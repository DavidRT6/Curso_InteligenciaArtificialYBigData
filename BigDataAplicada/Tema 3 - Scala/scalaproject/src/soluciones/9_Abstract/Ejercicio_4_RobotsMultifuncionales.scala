/*Ejercicio 4: Robots Multifuncionales
Sistema para modelar diferentes tipos de robots que contienen las características de:
    - Modelo que devuelve el modelo del robot, por ejemplo, "ModeloX".
    - Bateria que devuelve el nivel de batería del robot, por ejemplo, 80.
    - Estado que devuelve el mensaje por pantalla de "El robot [modelo] tien [bateria]% de batería"

    Algunos de los modelos de robots pueden levantar peso imprimiendo por pantalla:
        "El robot está levantando [peso] kg."
    Algunos de los modelos de robots puede asistir a personas imprimiento por pantalla:
        "El robot está asistiendo a [persona]."


     Existe dos tipos de robot:
        - Robot que se denomina Obrero que realiza los trabajos pesados.
        - Robot que se denomina Asistente que realiza la asistencia a personas

*/

abstract class Robot {
  def modelo: String
  def bateria: Int
  def estado(): Unit = println(s"El robot $modelo tiene $bateria% de batería.")
}

// Trait TrabajoPesado
trait TrabajoPesado {
  def levantarPeso(peso: Int): Unit = println(s"El robot está levantando $peso kg.")
}

// Trait AsistenciaHumana
trait AsistenciaHumana {
  def asistir(persona: String): Unit = println(s"El robot está asistiendo a $persona.")
}

// Clase RobotObrero que mezcla TrabajoPesado
class RobotObrero(val modelo: String, val bateria: Int) extends Robot with TrabajoPesado

// Clase RobotAsistente que mezcla AsistenciaHumana
class RobotAsistente(val modelo: String, val bateria: Int) extends Robot with AsistenciaHumana

object Ejercicios4 extends App {
  val obrero = new RobotObrero("Obrero-3000", 80)
  val asistente = new RobotAsistente("Asistente-2000", 90)

  obrero.estado()               // Salida: El robot Obrero-3000 tiene 80% de batería.
  obrero.levantarPeso(150)      // Salida: El robot Obrero-3000 está levantando 150 kg.

  asistente.estado()            // Salida: El robot Asistente-2000 tiene 90% de batería.
  asistente.asistir("Juan")     // Salida: El robot Asistente-2000 está asistiendo a Juan.
}