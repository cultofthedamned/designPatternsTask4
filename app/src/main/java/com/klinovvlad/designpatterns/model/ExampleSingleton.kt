package com.klinovvlad.designpatterns.model

class ExampleSingleton private constructor() {

    fun createData(): List<ExampleData> {
        val items = (0 until 20).map { i ->
            ExampleData("first name$i second name$i")
        }
        return items
    }

    companion object {
        @Volatile
        private var INSTANCE: ExampleSingleton? = null
        private val LOCK = Any()

        fun getInstance(): ExampleSingleton {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = ExampleSingleton()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}