package ru.volggtu

fun main() {
    val engText = "Hello World"

    val yandex = YandexImpl(engText)
    val translateJson = yandex.translate()

    val rusText = translateJson.text

    println("$engText - переводится как - $rusText")
}