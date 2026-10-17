package com.example.first // или ваше имя пакета, посмотрите вверху файла

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editSymbol = findViewById<EditText>(R.id.editSymbol)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val input = editSymbol.text.toString()

            // Проверка, что введён ровно один символ
            if (input.length != 1) {
                tvResult.text = "Введите ровно один символ"
                return@setOnClickListener
            }

            val symbol = input[0]

            // Использование when
            when {
                // Если это не латинская строчная буква
                !symbol.isLowerCase() || symbol !in 'a'..'z' -> {
                    tvResult.text = "Ошибка: символ '$symbol' не является латинской строчной буквой. Программа завершена."
                    // Завершаем выполнение (эмуляция выхода из программы)
                    finish()
                }
                // Если гласная
                symbol in listOf('a', 'i', 'e', 'o', 'u') -> {
                    tvResult.text = "Это гласные буквы"
                }
                // Иначе — согласная
                else -> {
                    tvResult.text = "Это согласные буквы"
                }
            }
        }
    }
}