package com.klinovvlad.designpatterns.model.builders

class ExampleBuilderClass private constructor(
    val firstString: String,
    val secondString: String,
    val thirdString: String
) {

    class Builder {

        private var firstString: String = ""
        private var secondString: String = ""
        private var thirdString: String = ""

        fun firstString(firstString: String): Builder {
            this.firstString = firstString
            return this
        }

        fun secondString(secondString: String): Builder {
            this.secondString = secondString
            return this
        }

        fun thirdString(thirdString: String): Builder {
            this.thirdString = thirdString
            return this
        }

        fun build(): ExampleBuilderClass {
            return ExampleBuilderClass(firstString, secondString, thirdString)
        }

    }

}