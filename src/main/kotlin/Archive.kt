import java.util.Scanner

object Values {
    val scan = Scanner(System.`in`)
    val mainArr = mutableMapOf<String, Archive>()

}

data class Archive(val archiveArr: MutableMap<String, String>){
    fun makeNote(str: String, str2: String): String{
        archiveArr.put(str, str2)
        return "Создана заметка \"$str\" с текстом \"$str2\"."
    }

    fun showNotes(): String{
        val arr = mutableListOf<String>()
        for(str in archiveArr.keys){
            arr.add(str)
        }
        return arr.joinToString(", ")
    }

    fun showTextNote(str: String): String? {
        return archiveArr[str]
    }

    fun notesLength(): Int{
        return archiveArr.size
    }


}