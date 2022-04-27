package com.klinovvlad.designpatterns.model.decorators


open class ExampleDecorator(protected var dinner: Dinner): Dinner {

    override fun getFood(): String {
        return dinner.getFood()
    }

}

interface Dinner {
    fun getFood() : String
}

class Borsch : Dinner {
    override fun getFood(): String {
        return "Water, Potato, Onion"
    }
}

class Chicken(dinner: Dinner) : ExampleDecorator(dinner) {
    override fun getFood(): String {
        return dinner.getFood() + ", Chicken"
    }
}

class SourCream(dinner: Dinner) : ExampleDecorator(dinner) {
    override fun getFood(): String {
        return dinner.getFood() + ", Sour Cream"
    }
}




