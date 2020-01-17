package ru.vstu

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TranslateTest {

    private val mockkYandex = mockk<Yandex>()

    @Test
    fun `checking parsing incoming json`() {
        val word0 = "friend"
        val word1 = "asdfasdf"
        val word2 = "допоможи"

        every { mockkYandex.queryWithParams(word0) } returns """{"code": 200,"lang": "en-ru","text": ["друг"]}"""
        every { mockkYandex.queryWithParams(word1) } returns """{"code": 200,"lang": "en-ru","text": ["asdfasdf"]}"""
        every { mockkYandex.queryWithParams(word2) } returns """{"code": 200,"lang": "en-ru","text": ["помоги"]}"""

        val yandex0 = YandexImpl(word0).translate()
        assertEquals("друг", yandex0.text)

        val yandex1 = YandexImpl(word1).translate()
        assertEquals("перевод отсутствует", yandex1.text)

        val yandex2 = YandexImpl(word2).translate()
        assertEquals("помоги", yandex2.text)
    }
}