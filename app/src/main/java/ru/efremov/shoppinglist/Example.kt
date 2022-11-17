package ru.efremov.shoppinglist

open class Rectangle(
    private var a: Int,
    private var b: Int,
) {

    open fun setWidth(width: Int) {
        a = width
    }

    open fun setHeight(height: Int) {
        b = height
    }

    fun getWidth(): Int = a

    fun getHeight(): Int = b

    fun area() = a * b
}

class Square(
    private var side: Int
) : Rectangle(side, side) {

    override fun setWidth(width: Int) {
        super.setWidth(width)
        super.setHeight(width)
    }

    override fun setHeight(height: Int) {
        super.setHeight(height)
        super.setWidth(height)
    }
}

fun main() {
    test()
}

private fun test() {
    val rect = Rectangle(10, 10)
    println(rect.area() == 100)
    println(rect.getWidth() == 10)
    println(rect.getHeight() == 10)
    rect.setWidth(5)
    rect.setHeight(20)
    println(rect.area() == 100)
    println(rect.getWidth() == 20)
    println(rect.getHeight() == 5)
}