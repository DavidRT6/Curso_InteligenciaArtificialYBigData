object CallByValueName extends App {
  def llamadaPorValor (x: Long): Unit = {
    println("Por valor " + x)
    println("Por valor " + x)
  }

  def llamadaPorNombre (x: => Long): Unit = {
    println("Por nombre " + x)
    println("Por nombre " + x)
  }

  llamadaPorValor(System.nanoTime())
  llamadaPorNombre(System.nanoTime())


  // Ejercicio 1: Explica la diferencia de resultado de imprimePrimer
  def Infinito(): Int = 1 + Infinito()
  def imprimePrimer(x: Int, y: => Int) = println(x)

  // Bucle infinito
  //imprimePrimer(Infinito(), 34)
  imprimePrimer(34, Infinito())
}
