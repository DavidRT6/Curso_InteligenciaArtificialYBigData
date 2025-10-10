object FuncionesAnonimas extends App {
  // Función anónima
  val fDoble = (x: Int) => x * 2

  // Es lo mismo que la anterior
  val fDoble2: Int => Int = x => x * 2

  // Múltiples parámetros
  val suma = (a: Int, b: Int) => a + b

  // Sin parámetros
  val haceAlgo = () => 3
  val haceAlgo2: () => Int = () => 3

  println(haceAlgo)
  println(haceAlgo2())
}


object FuncionesOrdenSuperior extends App {
  // Función nVeces
  def nVeces (f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nVeces (f, n-1, f(x))

  val unoMas = (x: Int) => x + 1
  println("\nFunción n veces:")
  println(nVeces(unoMas, 10, 1))

  // Curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y

  println("\nCurried functions:")
  println(add3(10))
  println(superAdder(3)(10))



  //val superMult: Int => (Int => Int) = 
}