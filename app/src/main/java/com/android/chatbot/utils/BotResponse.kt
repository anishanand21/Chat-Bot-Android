package com.android.chatbot.utils

import com.android.chatbot.utils.Constants.OPEN_GOOGLE
import com.android.chatbot.utils.Constants.OPEN_SEARCH

object BotResponse {

    fun basicResponse(_message: String): String {

        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when {

            //Hello
            message.contains("hello|hi|hey") -> {
                when(random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Hey!"
                    else -> "error"
                }
            }

            //How are you
            message.contains("how are you") -> {
                when(random) {
                    0 -> "I'm doing fine, thanks for asking!"
                    1 -> "I'm hungry"
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")

                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    answer.toString()

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Gets the current time
            message.contains("time") && message.contains("?") -> {
                Time.timestamp()
            }

            //Open Google
            message.contains("open") && message.contains("google") -> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search") -> {
                OPEN_SEARCH
            }

            else -> {
                when(random) {
                    0 -> "I don't understand..."
                    1 -> "Idk"
                    2 -> "Try asking me something different1"
                    else -> "error"
                }
            }
        }
    }

}