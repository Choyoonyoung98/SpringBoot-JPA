package com.demo.function

val courseName = "Kotlin Programming"

fun topLevelFunciton(): Int {
    return (0..100).random()
}

fun main() {
    val num = topLevelFunciton()
    println("Num is : $num")
}