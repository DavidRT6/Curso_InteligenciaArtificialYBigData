// David Roca Tauste

object CaseClass extends App {
  // EJERCICIO 1
  println("\nEJERCICIO 1:")
  case class Libro(titulo: String, autor: String, anyoPublicacion: Int)

  val libro = Libro("1984", "Anónimo", 1986)
  println(libro)


  // EJERCICIO 2
  println("\nEJERCICIO 2:")
  case class Operacion(a: Int, b: Int, tipoOperacion: String)

  def procesarOperacion(operacion: Operacion): Unit = {
    operacion match {
      case Operacion(a, b, tipoOp) if tipoOp == "suma" => println(s"Suma de $a y $b: ${a+b}")
      case Operacion(a, b, tipoOp) if tipoOp == "resta" => println(s"Resta de $a y $b: ${a-b}")
      case Operacion(a, b, tipoOp) if tipoOp == "multiplicacion" => println(s"Multiplicación de $a y $b: ${a*b}")
    }
  }


  var op = Operacion(1, 5, "suma")
  procesarOperacion(op)
  
  op = Operacion(9, 43, "resta")
  procesarOperacion(op)

  op = Operacion(8, 3, "multiplicacion")
  procesarOperacion(op)
}



object Enums {
  // EJERCICIO 3
  enum ColoresPrimarios {
    case ROJO, AZUL, AMARILLO

    def imprimirColor(): Unit = {
        if (this == ROJO) println(s"Color a imprimir: $this")
        else if (this == AZUL) println(s"Color a imprimir: $this")
        else if (this == AMARILLO) println(s"Color a imprimir: $this")
        else println("Color no disponible.")
    }
  }

  val colorRojo: ColoresPrimarios = ColoresPrimarios.ROJO
  val colorAzul: ColoresPrimarios = ColoresPrimarios.AZUL
  val colorAmarillo: ColoresPrimarios = ColoresPrimarios.AMARILLO

  def main(args: Array[String]): Unit = {
    colorRojo.imprimirColor()
    colorAzul.imprimirColor()
    colorAmarillo.imprimirColor()
  }
}