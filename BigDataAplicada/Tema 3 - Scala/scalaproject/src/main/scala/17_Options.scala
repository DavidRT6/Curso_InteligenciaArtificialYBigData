import scala.util.Random
import scala.util.Try

object Scala_Options extends App {
    //Option para representar la presencia o ausencia de valores
    val config: Map [String, String] = Map (
        "host" -> "176.45.36.1",
        "port" -> "80"
    )
    class Connection {
        def connect = "Conectado" //conectado algún servidor
    }
    object Connection {
      val random = new Random (System.nanoTime())
      def apply (host: String, port:String): Option [Connection] = 
         if (random.nextBoolean()) Some (new Connection)
         else None
    }
    val host = config.get ("host")
    val port = config.get ("port")
    /* 
       if (h != null)
        if (p != null)
            return Connection.apply (h ,p)
       return null
     */
    val connection = host.flatMap (h => port.flatMap (p => Connection.apply (h, p)))
    /* 
       if (c != null)
         return c.connect
        return null
     */
    val connectionStatus = connection.map(c => c.connect)
    // if (connectionStatus == null) println (None) else print (Some(connectionStatus.get))
    println(connectionStatus)
    /* 
       if (status 1= null)
       println(status)
     */
    connectionStatus.foreach(println)

   /* es el mismo código?*/
    config.get ("host")
        .flatMap(host => config.get("port")
            .flatMap(port => Connection(host, port))
            .map(connection => connection.connect))
        .foreach(println)

    //for-comprehensions
    val forConnectionStatus = for {
        host <- config.get ("host")
        port <- config.get ("port")
        connection <- Connection (host,port)
    } yield connection.connect
    forConnectionStatus.foreach(println)
}


// David Roca Tauste
object Ejercicios_Options extends App {
/* Ejercicio
Tenemos un sistema que almacena información de usuarios en una base de datos. La información se representa de la siguiente manera:
    - Map [String, Map [String, String]] donde:
        - El primer parámetro String corresponde al Identificador del usuario : "IdUsuario"
        - El segundo parámetro Map [String, String] corresponde a los siguientes datos:
            - Nombre del usuario "nombre"
            - Saldo de la cuenta bancaria "saldo"

Realizar un método que tenga como parámetro de entrada el Identificador del usuario y que realice las siguientes acciones:
    1.- Buscar el IdUsuario en el sistema
    2.- Si el IdUsuario existe, debéis extraer el nombre y el saldo del usuario
    3.- Si tiene saldo, entonces debes convertir ese saldo a un valor numérico para aumentarlo 10%.
    4.- Imprime por pantalla el nombre del usuario con el nuevo saldo obtenido. En caso de que el usuario no exista, 
        o no haya datos no debes imprimir ningún resultado.

Datos del ejercicio:
    (IdUsuario, nombre, saldo) --> ("1", "Carlos", "100")
    (IdUsuario, nombre, saldo) --> ("2", "Ana", "200")
    (IdUsuario, nombre, saldo) --> ("3", "Luis") --> OJO: NO TIENE SALDO
*/

  // Datos usuarios
  val usuarios: Map[String, Map[String, String]] = Map(
    "1" -> Map("nombre" -> "Carlos", "saldo" -> "100"),
    "2" -> Map("nombre" -> "Ana", "saldo" -> "200"),
    "3" -> Map("nombre" -> "Luis", "saldo" -> "")
  )

  // Id del usuario a elegir
  //val idUsuario = "2"
  val idUsuario = "3"
  //val idUsuario = "4"

  // Actualizar saldo
  val forActualizarSaldo = for {
    datosUsuario <- usuarios.get(idUsuario)
    nombre <- datosUsuario.get("nombre")
    saldo <- datosUsuario.get("saldo")

    if saldo.nonEmpty
    saldoNum <- Try(saldo.toDouble).toOption
  } yield {
    s"Usuario $idUsuario:\n" +
      s" - Nombre: $nombre\n" +
      s" - Saldo nuevo: ${saldoNum * 1.10}"
  }

  // Crear mensaje en caso de que no tenga saldo
  val resultado = forActualizarSaldo match {
    case Some(valor) => valor
    
    case None => usuarios.get(idUsuario) match {
      case Some(datosUsuario) =>
        val nombre = datosUsuario.get("nombre").getOrElse("")
        (s"Usuario $idUsuario:\n" +
            s" - Nombre: $nombre\n" +
            s" - Saldo nuevo: no tiene saldo")
        
      case None => ""
    }
  }

  // Mostrar mensaje
  println(resultado)
}
