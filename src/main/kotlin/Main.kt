//29, 30
fun main(args: Array<String>) {

    val movie1=Movie("Titanic",90,false)
    //val n=movie.name
    //val d=movie.duration
    //val a=movie.isAvailable
    //var r=movie.playMovie(n,d,a)

    //var r=movie1.play()

    //println("$n movie had played: $r")

    //31
    //println("${movie1.name} had played: $r")
    //if(r){
        //movie1.pause()
    //}
    movie1.play()
    movie1.played() //Comprueba si se reprodujo y entonces pausa

    val movie2=Movie("ET",0,true)
    movie2.play()
    movie2.played() //Comprueba si se reprodujo y entonces pausa

    val movie3=Movie("Dexter's Lab",50,true)
    movie3.play()
    movie3.played() //Comprueba si se reprodujo y entonces pausa

    println(movie1.toString()) //...pero si se van a traer otras variables (procesamiento), sí
    println(movie2.toString())

    println(movie1) //para imprimir no se necesitó el método sobreescrito toString...
    println(movie2)

    //32
    var a:Int=1
    var b:Int?=null //no se permite darle un valor de null a menos qué ?
    //print(a+b!!) //avisa en tiempo de compilación si la variable no está inicializada. Agregándole el !!, aparece el nullPointerException

    movie1.playTrailer() //se protegió nulabilidad de trailer con ? a la derecha

    //33
    val frames= Movie.getTotalFrames(movie1.duration,true) //forma de llamar un método estático...
    //se llama a través de la clase y no del objeto
    println("Total frames of ${movie1.name} is: $frames")
}

