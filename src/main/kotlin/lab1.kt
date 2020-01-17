package ru.vstu

import java.util.Scanner

fun main() {
    println("Hello in yandex translate-console")
    println("`exit` - stop command")
    val read = Scanner(System.`in`)

    var check = true
    while (check) {
        val engText = read.nextLine()

        if("exit" == engText){
            check = false
        } else {
            val yandex = YandexImpl(engText)
            val translateJson = yandex.translate()

            val rusText = translateJson.text

            println("$engText - переводится как - $rusText")
        }
    }
    println("Good bye!")
}