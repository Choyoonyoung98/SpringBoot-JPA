package com.demo.basics
import com.demo.function.courseName
import com.demo.function.topLevelFunciton

fun main() {
    val name: String = "Yoonyoung"
    println(name)
    // name = "soyoung" (x)

    var age: Int = 34
    println(age)
    age = 35
    println(age)

    val num = topLevelFunciton()
    println("Num is : $num")

    println("courseName: $courseName")
}