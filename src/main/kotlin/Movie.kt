//29, 30, 31
/*
class Movie  {
    val name="Titanic" //Si les pongo var, puedo cambiar sus valores desde otra parte
    val duration=90
    val isAvailable=true
}
*/
//30
class Movie (var name: String, var duration: Int, var isAvailable: Boolean, var trailer:Trailer?=null) {
//Si les pongo var, puedo cambiar sus valores desde otra parte
//también se pueden poner valores de argumentos por defecto
//igual, puede haber sobrecarga de constructores

    //33
    companion object{ //encierra métodos estáticos y constantes estáticas

        private const val FRAME_RATE_HD=60 // se le pone private solo por sugerencia de IDE
        private const val FRAME_RATE_SD=24
        private const val SECONDS_IN_A_MINUTE=60

        fun getTotalFrames(duration: Int, isHd: Boolean):Int{ //Al ser companion hay que pasarle parámetro duration, aunque sea atributo de la clase
            //No obstante, las constantes y métodos del companion object sí se pueden usar fuera de él
            return if(isHd) {
                FRAME_RATE_HD * SECONDS_IN_A_MINUTE * duration
            }else{
                FRAME_RATE_SD * SECONDS_IN_A_MINUTE * duration
            }
        }
    }

    private var v=false

    fun play(): Unit { //también se pueden asignar valores por defecto a los argumentos
        if(isAvailable){
            if(duration>0){
                for (i in 0 until duration step duration / 10) {
                    println("Playing movie $name")
                }
                v=true
            }else {
                println("Playing movie duration is zero or less than zero")

            }
        }else{
            println("Movie $name is not available")
        }
    }

    fun pause(){
        println("Movie paused")
    }

    fun played():Boolean{
        return if(v){
            println("${name} had played: true")
            this.pause()
            true
        }else{
            println("${name} had played: false")
            false
        }
    }

    fun playTrailer(){
        /* Esto se hace en cualquier lenguaje para dar manejo al nullPointerException
        if(trailer==null) {
            println("No movie trailer avilable")
        } else {
            trailer!!.play(name) //Con !! se le da manejo a null y aparecerá nullPointerException
        }
        */
        trailer?.play(name) ?: println("No movie trailer available")//Esto lo hace kotlin para darle manejo más limpio a nullPointerException.
        //Si trailer es null, lo que hay a la derecha de ? no se ejecuta.
    }

    override fun toString(): String {
        return "Nombre: $name -  Duración: $duration min"
    }


}