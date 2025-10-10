// David Roca Tauste

object Exceptions extends App {
  /* EJERCICIO 1. Calculadora
   - suma (x,y)
   - restar (x,y)
   - multiplicar (x,y)
   - dividir (x,y)

  Throw
   - OverflowException si suma (x,y) excede int.MAX_VALUE
   - UnderflowException si la resta (x,y) excede int.MIN_VALUE
   - MathCalculationException si la división por 0
  */

  import java.lang.ArithmeticException
  class OverflowException extends Exception("Se ha producido una excepción de tipo: OverflowException")
  class UnderflowException extends Exception("Se ha producido una excepción de tipo: UnderflowException")
  class MathCalculationException extends Exception("No está permitido dividir entre 0")

  def sumar(x: Int, y: Int): Int = {
    val resultado = x + y
    if (resultado > Int.MaxValue) throw new OverflowException
    if (resultado < Int.MinValue) throw new UnderflowException
    return resultado
  }

  def restar(x: Int, y: Int): Int = {
    val resultado = x - y
    if (resultado > Int.MaxValue) throw new OverflowException
    if (resultado < Int.MinValue) throw new UnderflowException
    return resultado
  }

  def multiplicar(x: Int, y: Int): Int = {
    val resultado = x * y
    if (resultado > Int.MaxValue) throw new OverflowException
    if (resultado < Int.MinValue) throw new UnderflowException
    return resultado
  }

  def dividir(x: Int, y: Int): Int = {
    if (y == 0) throw new MathCalculationException
    
    val resultado = x / y
    return resultado
  }


  try {
    println(sumar(Int.MaxValue, 1))
  } catch {
    case e: OverflowException => println(e.getMessage)
  }

  try {
    println(restar(Int.MinValue, 1))
  } catch {
    case e: UnderflowException => println(e.getMessage)
  }

  try {
    println(multiplicar(Int.MaxValue, 5))
  } catch {
    case e: OverflowException => println(e.getMessage)
  }

  try {
    println(dividir(6, 0))
  } catch {
    case e: MathCalculationException => println(e.getMessage)
  }
}
