// David Roca Tauste

object Secuencias extends App {
  // EJERCICIO
  val temperaturas = Seq(8, 20, 18, 22, 16, 19, 21)
  println("EJERCICIO 1:")

  // Apartado 1
  println(temperaturas)

  // Apartado 2
  println(temperaturas.max())

  // Apartado 3
  println(temperaturas.min())

  // Apartado 4
  val promedio = temperaturas.sum() / temperaturas.size
  println(promedio)

  // Apartado 5
  val secuenciaOrdenada = temperaturas.sorted
  println(secuenciaOrdenada.reverse)

  // Apartado 6
  println(temperaturas ++ Seq(23))

  // Apartado 7
  println(temperaturas.filter(_ >= 20))
}

/* 
Ejercicio:
Sistema debe generar horarios de clases para un día específico. Hay 10 clases en el día, y cada clase dura 1 hora, comenzando a las 8 de la mañana y terminando a las 17 de la tarde.
Resuelve las siguientes tareas utilizando Rangos:

1.- Genera un rango de horas para las clases, teniendo en cuenta que comienzan a las 8 (hora incluida) y terminan a las 17 (hora excluida) e imprime por pantalla.
2.- Asigna a cada una de las horas que hay clase el siguiente mensaje e imprime por pantalla:
"Clase en la hora X" --> cambia el valor X por la hora actual.
3.- Calcula el total de clases del día usando el rango y muestra el resultado. "Número total de clases: X" --> X el valor calculado.
4.- Imprime por pantalla un mensaje cada dos horas, indicando que hay un descanso --< PISTA: (8 until 17 by 2) --> "by 2" avanza el rango de dos en dos
*/
object Rangos extends App {
  // Apartado 1
  val clases: Seq[Int] = 8 until 17
  clases.foreach(println)

  // Apartado 2
  clases.foreach(clase => println(s"Clase en la hora $clase"))

  // Apartado 3
  val clasesTotales = clases.size
  println(clasesTotales)

  // Apartado 4
  val clasesConDescanso = (8 until 17 by 2)
  clasesConDescanso.foreach(clase => println(s"DESCANSO a las $clase"))
}