object `18_AllThePatterns` extends App {
    // EJERCICIO 1
    val productos = Map(
        "1" -> Map("descripcion" -> "Lavadora"),
        "2" -> Map("descripcion" -> "Llave inglesa"),
        "3" -> Map("descripcion" -> "Aspiradora"),
        "4" -> Map("descripcion" -> "Taladro"),
        "5" -> Map("descripcion" -> "Martillo")
    )

    /*  
    def obtenerDescripcionProducto(productos: Map["Int", "String"], id: Int): String = {
        productos.get(id) match {

        }
    }
    */


    // EJERCICIO 2
    def comprobarTipo() = {

    }



    // EJERCICIO 3
    def sumarNumeros(tupla: (Int, (Int, Int))): Int = {
        val (primero, (segundo, tercero)) = tupla
        
        return primero + segundo + tercero
    }

    val tupla = (1, (2, 3))
    println(s"La suma de los números es: ${sumarNumeros(tupla)}")
}
