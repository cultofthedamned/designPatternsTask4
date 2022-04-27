package com.klinovvlad.designpatterns.model.factories

import com.klinovvlad.designpatterns.model.ExampleData

class ExampleDataFactory {

    interface TakeData {
        fun showData(integer: Int): ExampleData
    }

    class FirstData : TakeData {
        override fun showData(integer: Int): ExampleData {
            return ExampleData("first$integer second$integer")
        }
    }

    class SecondData : TakeData {
        override fun showData(integer: Int): ExampleData {
            return ExampleData("first$integer second$integer")
        }
    }

    companion object {
        fun createSingleData(integer: Int): ExampleData {
            return when(integer) {
                1 -> {
                    FirstData().showData(integer)
                }
                2 -> {
                    SecondData().showData(integer)
                }
                else -> {
                    ExampleData("null$integer null$integer")
                }
            }
        }
    }

}