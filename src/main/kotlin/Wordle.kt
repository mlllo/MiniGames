package org.test

import java.util.*

fun main() {
    val dWord = DummyDictionary();
    val word = dWord.getRandomWord();
    val wordLength = word.length;
    val scanner = Scanner(System.`in`);

    println("If you want exit write 'exit'.\nWord have: $wordLength letters");
    while (true) {
        val answer = scanner.nextLine();

        if(answer == "new") {
            dWord.getRandomWord();
            return main();
        }else if (answer == "current") {
            println(word);
            println("Answer:");
            continue;
        }else if(answer == "exit") {
            return;
        }

        if(answer == word) {
            println("You win! Do you want to try again? Write yes/no.");
            val wAnswer = scanner.nextLine();
            if(wAnswer == "yes") {
                dWord.getRandomWord();
                return main();
            }else if(wAnswer == "no") {
                return;
            }else {
                println("UnCorrect!");
                return;
            }
        }else {
            println("Try again!");
            val hash = "⬛".repeat(wordLength);
            val hashMsg = hash.toCharArray();

            if(answer.length != wordLength) {
                println("Word must have $wordLength letters!");
                continue;
            }

            var x = 0
            while (x != word.length) {
                val aLetter = word[x];
                val bLetter = answer[x];
                if (aLetter == bLetter) {
                    hashMsg[x] = aLetter;
                }
                x++;
            }
            println(hashMsg);
        }

    }

}