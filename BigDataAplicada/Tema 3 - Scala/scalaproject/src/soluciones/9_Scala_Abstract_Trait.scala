object AbstractDataTypes extends App {
/* Diapositiva 1*/

  //abstract
  abstract class Animal {
    val TipoCriatura : String
    def comer: Unit
  }

  val animal  = new Animal
 

  /* Diapositiva 2*/
  
  //abstract
  abstract class Animal {
    val TipoCriatura : String
    def comer: Unit
  }

  class Perro extends Animal {
    override val TipoCriatura: String = "Doméstico"
    def comer: Unit = println ("comer perro")
   }
 

 /* Diapositiva 3*/
 
  //abstract
  abstract class Animal {
    val TipoCriatura : String
    def comer: Unit
  }

  class Perro extends Animal {
    override val TipoCriatura: String = "Perro"
    def comer: Unit = println ("comer perro")
   }


  //traits (rasgos)
  trait Carnivoro {
    def comer (animal: Animal): Unit
  }

  class Cocodrilo extends Animal with Carnivoro {
    val TipoCriatura: String = "croc"
    def comer: Unit = println("ñam ñam")
    def comer(animal: Animal): Unit =
         println(s"Yo sou un cocodrilo y me como ${animal.TipoCriatura}")
  }
  val perro = new Perro
  val croc = new Cocodrilo
  croc.comer (perro)
  */

  /* Diapositiva 4*/
  
  //abstract
  abstract class Animal {
    val TipoCriatura : String
    def comer: Unit
  }

  class Perro extends Animal {
    override val TipoCriatura: String = "Perro"
    def comer: Unit = println ("comer perro")
   }


  //traits (rasgos)
  trait Carnivoro {
    def comer (animal: Animal): Unit
  }

  trait SangreFria 

  class Cocodrilo extends Animal with Carnivoro with SangreFria {
    val TipoCriatura: String = "croc"
    def comer: Unit = println("ñam ñam")
    def comer(animal: Animal): Unit =
         println(s"Yo sou un cocodrilo y me como ${animal.TipoCriatura}")
  }
  val perro = new Perro
  val croc = new Cocodrilo
  croc.comer (perro)

  /*Diapositiva 5*/

  //rasgos vs clases
  //abstract
  abstract class Animal {
    val TipoCriatura : String ="Salvaje"
    def comer: Unit
  }

  class Perro extends Animal {
    override val TipoCriatura: String = "Perro"
    def comer: Unit = println ("comer perro")
   }


  //traits (rasgos) vs Clases abstractas
  // 1- rasgos (traits) no tienen parámetros constructores
     /* Ejemplo: no permite parámetros 
     
            trait Carnivoro (name: String) {
            def comer (animal: Animal): Unit
            val prefiereComida: String ="Carne fresca"
            }
       */
   // 2- multiples rasgos (traits) pueden heredar por la misma clase
    /*class Cocodrilo extends Animal with Carnivoro with SangreFria {
      ....
    }
    */

   //3 - Rasgos = comportamiento, clases abstractas  = cosas
  //

   trait Carnivoro  {
    def comer (animal: Animal): Unit
    val prefiereComida: String ="Carne fresca"
  }

  trait SangreFria 

  class Cocodrilo extends Animal with Carnivoro with SangreFria {
    override val TipoCriatura: String = "croc"
    def comer: Unit = println("ñam ñam")
    def comer(animal: Animal): Unit =
         println(s"Yo sou un cocodrilo y me como ${animal.TipoCriatura}")
  }
  val perro = new Perro
  val croc = new Cocodrilo
  croc.comer (perro)


}