 //constructores
   class Persona (nombre: String, edad: Int) 
   
   class Adulto (nombre: String, edad: Int, carnetConducir: String) extends Persona (nombre, edad)
  
   class Animal {
        val TipoCriatura = "Salvaje"
        protected def comer = println("comer comer")
   }

   class Gato extends Animal {
    def comerGato = {
        comer //el método protegido sí se será accesible desde la subclase, pero no es accesible fuera de la clase
        println("comida gato")
    }
   }

   val gato = new Gato //instancia de la clase Cat
   //gato.comer
   gato.comerGato

   //overriding --anulando
   class Perro extends Animal {
      override val TipoCriatura = "Domestica"
      override def comer = println("comer perro")
   }

   class Perro (TipoPerro: String) extends Animal {
        override val TipoCriatura = TipoPerro
    }
    

    val perro = new Perro ("Indiferente")
    println(perro.TipoCriatura)
    

    //tipo sustitución: polimorfismo
    class Animal {
        val TipoCriatura = "Salvaje"
        def comer = println("comer comer")
   }
  
    class Perro (override val TipoCriatura: String) extends Animal {
      override def comer = println("comer perro")
    }
    val esAnimal: Animal = new Perro ("Ni idea")
    esAnimal.comer
    
   //super
   class Animal {
        val TipoCriatura = "Salvaje"
        def comer = println("comer comer")
   }
   class Perro2 (override val TipoCriatura: String) extends Animal {
    override def comer ={
       super.comer
       println ("comer perro 2") 
    }
   }
   val perro2 = new Perro2 ("domestica")
   perro2.comer
  

  //impedir la anulación
  //1- utilizar la palabra reservada final
  
  class Animal {
    val TipoCriatura = "Salvaje"
    final def comer = println("comer comer")
  }
  
  class Perro (override val TipoCriatura: String) extends Animal {
    override def comer = {
        super.comer
        println("comer Perro")
    }
  }
  

  //2- utilizar final en toda la clase
  
   final class Animal {
    val TipoCriatura = "Salvaje"
     def comer = println("comer comer")
  }
  
  class Perro (override val TipoCriatura: String) extends Animal {
    override def comer = {
        super.comer
        println("comer Perro")
    }
  }
  

  //3- sellar la clase = extender clases en este fichero, para prevenir la extensión en otros ficheros
  sealed class Animal {
    val TipoCriatura = "Salvaje"
    def comer = println ("comer comer")
  }

  class Perro (override val TipoCriatura: String) extends Animal {
    override def comer = {
        super.comer
        println("comer Perro")
    }
  }
}