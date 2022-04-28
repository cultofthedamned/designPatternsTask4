package com.klinovvlad.designpatterns.model

class ExampleSingleton private constructor() {

    companion object {
        @Volatile
        private var INSTANCE: ExampleSingleton? = null
        private val LOCK = Any()

        private fun createData(): List<ExampleData> {
            val items = (0 until 20).map { i ->
                ExampleData("first name$i second name$i")
            }
            return items
        }

        fun getData(): List<ExampleData> {
            return (INSTANCE ?: synchronized(LOCK) {
                INSTANCE ?: createData()
            }) as List<ExampleData>
        }
    }
}