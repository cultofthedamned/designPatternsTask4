package com.klinovvlad.designpatterns.model

object ExampleDataHolder {

    fun createData(): List<ExampleData> {
        val items = (0 until 20).map { i ->
            ExampleData("first name$i second name$i")
        }
        return items
    }

}