class RunFunctions {

    private val archive=Archive(archiveArr=mutableMapOf<String, String>())

    fun archiveRun():Unit {
        while(true){

            if(Values.mainArr.size>0) {
                println("Напишите \"создать архив\" для создания архива, \"выбрать архив\" для выбора архива или \"выход\" для выхода из программы.")
                var res=Values.scan.nextLine()
                if(res.lowercase().trim()=="создать архив"){
                    while(true) {
                        println("Укажите название архива или напишите \"назад\" для возврата в меню.")
                        res = Values.scan.nextLine()
                        if(res.trim()==""){
                            println("Название не должно быть пустым. Попробуйте ещё раз.")
                            continue
                        }else if(res.lowercase().trim()=="назад"){
                            break
                        }
                        Values.mainArr.put(res, archive)
                        println("Архив ${res} создан.")
                        break
                    }
                }else if(res.lowercase().trim()=="выбрать архив"){

                    while (true) {
                        println("Для выбора архива укажите его название или напишите \"назад\" для возврата в меню. Сейчас есть архивы: ${mapToString(Values.mainArr)}")
                        res=Values.scan.nextLine()
                        if(res.lowercase().trim()=="назад"){
                            break
                        }
                        if(Values.mainArr[res]==null){
                            println("Название архива указано неверно. Попробуйте ещё раз.")
                            continue
                        }else{
                            return notes(res)
                        }
                    }

                }else if(res.lowercase().trim()=="выход"){
                    break
                }else{
                    println("Неверная команда. Попробуйте ещё раз.")
                    continue
                }
            }else{
                println("Напишите \"создать архив\" для создания архива или \"выход\" для выхода из программы.")
                var res=Values.scan.nextLine()
                if(res.lowercase().trim()=="создать архив"){
                    while(true) {
                        println("Укажите название архива или напишите \"назад\" для возврата в меню.")
                        res = Values.scan.nextLine()
                        if(res.trim()==""){
                            println("Название не должно быть пустым. Попробуйте ещё раз.")
                            continue
                        }else if(res.trim()=="назад"){
                            break
                        }
                        Values.mainArr.put(res, archive)
                        println("Архив ${res} создан.")
                        break
                    }
                }else if(res.lowercase().trim()=="выбрать архив"){
                    println("Для выбора архива сначала создайте хотя бы один архив. Попробуйте ещё раз.")
                    continue
                }else if(res.lowercase().trim()=="выход"){
                    break
                }else{
                    println("Неверная команда. Попробуйте ещё раз.")
                    continue
                }
            }

        }

    }

    private fun mapToString(arr: MutableMap<String, Archive>): String{
        val arr2= mutableListOf<String>()
        for(i in arr.keys){
            arr2.add(i)
        }
        return arr2.joinToString(", ")
    }

    private fun notes(archiveName: String): Unit{
        while (true){
            if(Values.mainArr[archiveName]?.notesLength()!!>0) {
                println("Напишите \"создать заметку\" для создания заметки, \"выбрать заметку\" для выбора заметки или \"назад\" для возврата.")
                var res=Values.scan.nextLine()
                if(res.lowercase().trim()=="создать заметку"){
                    while(true) {
                        println("Укажите название заметки или напишите \"назад\" для возврата.")
                        res = Values.scan.nextLine()
                        if(res.trim()==""){
                            println("Название не должно быть пустым. Попробуйте ещё раз.")
                            continue
                        }else if(res.lowercase().trim()=="назад"){
                            break
                        }
                        val str=res
                        println("Укажите текст заметки или напишите \"назад\" для выхода из интерфейса создания заметок.")
                        res = Values.scan.nextLine()
                        if(res.trim()==""){
                            println("Текст заметки не должен быть пустым. Укажите название и текст заметки повторно.")
                            continue
                        }else if(res.lowercase().trim()=="назад"){
                            break
                        }
                        println(Values.mainArr[archiveName]?.makeNote(str, res))
                        break
                    }

                }else if(res.lowercase().trim()=="выбрать заметку"){

                    while (true) {

                        println("Для просмотра текста заметки укажите её название или напишите \"назад\" для возврата. Сейчас есть заметки: ${Values.mainArr[archiveName]?.showNotes()}")
                        res=Values.scan.nextLine()
                        if(res.lowercase().trim()=="назад"){
                            break
                        }
                        if(Values.mainArr[archiveName]?.showTextNote(res)==null){
                            println("Название заметки указано неверно. Попробуйте ещё раз.")
                            continue
                        }else{
                            println("Текст заметки: "+Values.mainArr[archiveName]?.showTextNote(res))
                        }
                    }

                }else if(res.lowercase().trim()=="назад"){
                    return archiveRun()
                }else{
                    println("Неверная команда. Попробуйте ещё раз.")
                    continue
                }
            }else{
                println("Напишите \"создать заметку\" для создания заметки или \"назад\" для возврата.")
                var res=Values.scan.nextLine()
                if(res.lowercase().trim()=="создать заметку"){
                    while(true) {
                        println("Укажите название заметки или напишите \"назад\" для возврата.")
                        res = Values.scan.nextLine()
                        if(res.trim()==""){
                            println("Название не должно быть пустым. Попробуйте ещё раз.")
                            continue
                        }else if(res.lowercase().trim()=="назад"){
                            break
                        }
                        val str=res
                        println("Укажите текст заметки или напишите \"назад\" для выхода из интерфейса создания заметок.")
                        res = Values.scan.nextLine()
                        if(res.trim()==""){
                            println("Текст заметки не должен быть пустым. Укажите название и текст заметки повторно.")
                            continue
                        }else if(res.lowercase().trim()=="назад"){
                            break
                        }
                        println(Values.mainArr[archiveName]?.makeNote(str, res))
                        break
                    }

                }else if(res.lowercase().trim()=="выбрать заметку"){
                        println("Вам нужно создать хотя бы одну заметку.")
                }else if(res.lowercase().trim()=="назад"){
                    return archiveRun()
                }else{
                    println("Неверная команда. Попробуйте ещё раз.")
                    continue
                }

        }

        }

    }

}