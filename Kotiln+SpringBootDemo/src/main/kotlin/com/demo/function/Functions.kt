package com.demo.function

fun main() {
    val unit = printName("yoonyoung")
    println("unit is $unit")

    var result = addition(1, 2)
    println("Result is $result")

    var result1 = addition_approach1(1, 2)
    println("Result is $result1")
}

fun addition_approach1(x: Int, y: Int) = x + y

fun addition(x: Int, y: Int): Int {
    return x + y
}

fun printName(name: String) {
    println("Name is $name")
}
