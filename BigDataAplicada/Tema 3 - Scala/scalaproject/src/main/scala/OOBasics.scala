object `OOBasics` extends App {
  val persona = new Persona ("Carlos", 25)
  println(persona.edad)
  println(persona.x)
  persona.saluda("Daniel")
  persona.saluda()

  // EJERCICIOS
  // 1)
  println(s"\nEJERCICIOS:")
  println("EJERCICIO 1:")
  val escritor = new Escritor("Miguel", "Redondo", 2001)
  val escritor2 = new Escritor("Carlos", "Cuadrado", 1973)
  val novela = new Novela("Estrellas", 2022, escritor)

  println(escritor.nombreCompleto())
  println(novela.edadAutor())
  println(novela.edadAutor2)
  println(novela.escritoPor(escritor))
  println(novela.escritoPor(escritor2))

  // 2)
  println(s"\nEJERCICIO 2:")

  val contador = new Contador(0)
  contador.incrementarContador()
  contador.incrementarContador()
  contador.imprimirContador()
  contador.decrementarContador()
  contador.imprimirContador()

  /*  
  val contador = new Contador(0)
  contador.imprimirContador()
  contador.numero = contador.incrementarContador()
  contador.imprimirContador()
  contador.numero = contador.incrementarContador()
  contador.numero = contador.incrementarContador()
  contador.imprimirContador()
  */
}

//constructor
class Persona (nombre: String, val edad: Int) {
    //cuerpo
    val x = 2 //son campos
    println (1 + 3) //expresiones

    //método --//overloading
    def saluda(nombre: String): Unit = println(s"${this.nombre} dice: Hola, $nombre")
    def saluda(): Unit = println (s"Hola, Yo soy $nombre")

    //def saluda(): Int = 43 --> En este caso el compilado sí se confude

    //multiple constructores
    def this(nombre: String) = this(nombre,0)
    def this() = this ("Juan Carlos")
}

//los parámetros de la clase no son CAMPOS si no tiene escrito delante la palabra reservada "val"


// EJERCICIOS
// 1)
class Escritor(nombre: String, primerApellido: String, val anyo: Int) {     // El anyo es val para que sea un atributo público
    def nombreCompleto(): String = nombre + " " + primerApellido
}

class Novela(nombre: String, anyoRealizacion: Int, autor: Escritor) {
    def edadAutor(): Int = anyoRealizacion - autor.anyo
    def edadAutor2: Int = anyoRealizacion - autor.anyo
    def escritoPor(autor: Escritor): Boolean = if (autor == this.autor) true else false
}

// 2)
class Contador(var numero: Int) {
    var num = 0

    def incrementarContador(): Unit = num += 1
    def decrementarContador(): Unit = num -= 1

    def imprimirContador(): Unit = println(num)
}

/* 
class Contador(var numero: Int) {
    def incrementarContador(): Int = numero + 1
    def decrementarContador(): Int = numero - 1

    def imprimirContador(): Unit = println(numero)
}
*/