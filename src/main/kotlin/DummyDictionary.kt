package org.test

class DummyDictionary : Dictionary {
    override fun getRandomWord(): String {

        val word = arrayOf("test1", "test2", "test3", "test4", "test5", "test6", "test7", "test8", "test9", "test10", "test11");
        return word.random();

    }
}