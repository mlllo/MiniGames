package org.test

import java.util.*

fun main() {
    val dWord = DummyDictionary();
    val word = dWord.getRandomWord().uppercase(Locale.getDefault());
    val wordLength = word.length;
    val scanner = Scanner(System.`in`);

    println("If you want exit write 'exit'.\nWord have: $wordLength letters");
    while (true) {
        var answer = scanner.nextLine();

        if(answer.equals("new", ignoreCase = true)) {
            dWord.getRandomWord();
            return main();
        }else if (answer.equals("current", ignoreCase = true)) {
            println(word);
            println("Answer:");
            continue;
        }else if(answer.equals("exit", ignoreCase = true)) {
            return;
        }

        if(answer.equals(word, ignoreCase = true)) {
            println("You win! Do you want to try again? Write yes/no.");
            answer = scanner.nextLine()
            if(answer.equals("yes", ignoreCase = true)) {
                dWord.getRandomWord();
                return main();
            }else if(answer.equals("no", ignoreCase = true)) {
                return;
            }else {
                println("UnCorrect!");
            }
        }else if(!answer.equals(word, ignoreCase = true)){
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
                if (aLetter.equals(bLetter, ignoreCase = true)) {
                    hashMsg[x] = aLetter;
                }
                x++;
            }
            println(hashMsg);
        }

    }

}