package ru.volggtu

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField


fun main() {
    TranslateWindow()
}

class TranslateWindow : JFrame("translate online") {
    private val labelInput = JLabel().apply {
        text = "Введите слово:"
        setBounds(5, 0, 100, 40)
    }

    private val labelText = JLabel().apply {
        text = "Перевод:"
        setBounds(5, 25, 100, 40)
    }

    private val labelOutput = JLabel().apply {
        text = "Привет мир!"
        setBounds(100, 25, 395, 30)
    }

    private val textInput = JTextField().apply {
        text = "Hello world!"
        setBounds(100, 0, 395, 30)
    }

    private val translateBtn = JButton("Перевести").apply {
        setBounds(5, 55, 100, 30)
    }

    init {
        add(translateBtn)
        add(labelInput)
        add(labelText)
        add(labelOutput)
        add(textInput)
        setSize(500, 150)

        translateBtn.addActionListener {
            labelOutput.text = YandexImpl(textInput.text).translate().text
        }

        layout = null
        isVisible = true
        defaultCloseOperation = EXIT_ON_CLOSE
    }
}
