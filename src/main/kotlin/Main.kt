val homophonicTable = mapOf(
    'А' to (0..68).map { it.toString().padStart(3, '0') },
    'Б' to (69..81).map { it.toString().padStart(3, '0') },
    'В' to (82..132).map { it.toString().padStart(3, '0') },
    'Г' to (133..144).map { it.toString().padStart(3, '0') },
    'Д' to (145..159).map { it.toString().padStart(3, '0') },
    'Е' to (160..230).map { it.toString().padStart(3, '0') },
    'Ё' to (231..231).map { it.toString().padStart(3, '0') },
    'Ж' to (232..241).map { it.toString().padStart(3, '0') },
    'З' to (242..250).map { it.toString().padStart(3, '0') },
    'И' to (251..310).map { it.toString().padStart(3, '0') },
    'Й' to (311..311).map { it.toString().padStart(3, '0') },
    'К' to (312..343).map { it.toString().padStart(3, '0') },
    'Л' to (344..382).map { it.toString().padStart(3, '0') },
    'М' to (383..415).map { it.toString().padStart(3, '0') },
    'Н' to (416..470).map { it.toString().padStart(3, '0') },
    'О' to (471..564).map { it.toString().padStart(3, '0') },
    'П' to (565..584).map { it.toString().padStart(3, '0') },
    'Р' to (585..609).map { it.toString().padStart(3, '0') },
    'С' to (610..653).map { it.toString().padStart(3, '0') },
    'Т' to (654..705).map { it.toString().padStart(3, '0') },
    'У' to (706..722).map { it.toString().padStart(3, '0') },
    'Ф' to (723..727).map { it.toString().padStart(3, '0') },
    'Х' to (728..732).map { it.toString().padStart(3, '0') },
    'Ц' to (733..742).map { it.toString().padStart(3, '0') },
    'Ч' to (743..748).map { it.toString().padStart(3, '0') },
    'Ш' to (749..754).map { it.toString().padStart(3, '0') },
    'Щ' to (755..761).map { it.toString().padStart(3, '0') },
    'Ъ' to (762..762).map { it.toString().padStart(3, '0') },
    'Ы' to (763..777).map { it.toString().padStart(3, '0') },
    'Ь' to (778..788).map { it.toString().padStart(3, '0') },
    'Э' to (789..793).map { it.toString().padStart(3, '0') },
    'Ю' to (794..803).map { it.toString().padStart(3, '0') },
    'Я' to (804..853).map { it.toString().padStart(3, '0') },
    ' ' to (854..999).map { it.toString().padStart(3, '0') },
)

fun main() {
    println("Введите сообщение для шифрования:")
    val message = readLine()?.uppercase() ?: ""

    val encryptedMessage = encryptMessage(message)
    println("Зашифрованное сообщение:")
    println(encryptedMessage.joinToString(" "))

    val decryptedMessage = decryptMessage(encryptedMessage)
    println("Расшифрованное сообщение:")
    println(decryptedMessage)
}

fun encryptMessage(message: String): List<String> {
    val encrypted = mutableListOf<String>()
    for (char in message) {
        val codes = homophonicTable[char]
        if (codes != null) {
            val randomCode = codes.random()
            encrypted.add(randomCode)
        } else {
            println("Символ '$char' не найден в таблице!")
        }
    }
    return encrypted
}

fun decryptMessage(encryptedMessage: List<String>): String {
    val reverseTable = homophonicTable.flatMap { (char, codes) ->
        codes.map { it to char }
    }.toMap()

    val decrypted = StringBuilder()
    for (code in encryptedMessage) {
        val char = reverseTable[code]
        if (char != null) {
            decrypted.append(char)
        } else {
            println("Код '$code' не найден в таблице!")
        }
    }
    return decrypted.toString()
}
