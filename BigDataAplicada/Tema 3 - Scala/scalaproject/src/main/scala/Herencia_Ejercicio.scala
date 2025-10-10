object Herencia_Ejercicio extends App {
  // David Roca Tauste

  /*
    Contexto:
    Se necesita modelar distintos tipos de vehículos utilizando herencia en Scala.
    La clase base debe definir un comportamiento y un atributo predeterminados,
    mientras que las clases hijas sobrescribirán estos elementos para agregar comportamientos específicos.

    Clase Vehiculo
        Crea una clase sellada llamada Vehiculo para restringir su extensión a un solo archivo.
        Atributo: val TipoVehiculo con valor predeterminado "General".
        Método de conducir, que imprima "Conduciendo vehículo".
    Clase Hija: Coche
        Crea una clase Coche que extienda la clase Vehiculo.
        Sobrescribe el atributo TipoVehiculo para que sea personalizado al crear una instancia.
        Sobrescribe el método conducir de la clase padre. El nuevo método debe:
            Llamar al método original conducir de la clase padre utilizando super.conducir.
            Imprimir "Conduciendo coche".

    Llamadas:
        Crea una instancia de la clase Coche indicando el tipo de vehículo (por ejemplo, "Sedán").
        Imprime el valor de TipoVehiculo de la instancia.
        Llama al método conducir para verificar el comportamiento sobrescrito.
  */

  val vehiculo = new Coche("Sedán")
  println(vehiculo.tipoVehiculo)
  vehiculo.conducir

}

class Vehiculo() {
    val tipoVehiculo = "General"
    def conducir = println("Conducir vehículo")
}

class Coche(override val tipoVehiculo: String) extends Vehiculo {
    override def conducir = {
        super.conducir
        println("Conduciendo coche")
    }
}