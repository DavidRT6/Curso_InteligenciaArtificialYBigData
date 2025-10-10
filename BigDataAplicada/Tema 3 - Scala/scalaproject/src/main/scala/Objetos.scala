object Objetos extends App {
  /* Crea una clase Libro que tenga un título y un autor. 
    Usa el companion object para:
    - Crear un libro con un título y autor específicos
    - Crear un libro anónimo con título "Desconocido" y autor "Anónimo"

    Ejercicio:
    1 - Crear un libro con un título "1984" y el autor "George Orwell"
    2 - Crear un libro anónimo
    3 - Imprimir por pantalla los detalles de ambos libros
  */

  // EJERCICIO 1
  println("EJERCICIO 1:")

  var libro = new Libro("1984", "George Orwell")
  println(libro.mostrarDetalles())
  println(Libro.mostrarDetalles())


  // Solución
  /* 
  val libro = Libro.crear("1984", "George Orwell")
  println(s"\nDetalles del libro:\n -Título: ${libro.titulo}\n -Autor: ${libro.autor}")

  val libroAnonimo = Libro2.anonimo()
  */
}

class Libro(titulo: String, autor: String) {
    def mostrarDetalles(): String = s"\nDetalles del libro:\n -Título: $titulo\n -Autor: $autor"
}

object Libro {
    val titulo = "Desconocido"
    val autor = "Anónimo"

    def mostrarDetalles(): String = s"\nDetalles del libro:\n -Título: $titulo\n -Autor: $autor"
}

// Solución
/*  
class Libro2(val titulo: String, val autor: String) {}

object Libro2 {
    def crear(titulo: String, autor: String): Libro = new Libro(titulo, autor)
    def anonimo(): Libro = new Libro("Desconocido", "Anónimo")
}
*/