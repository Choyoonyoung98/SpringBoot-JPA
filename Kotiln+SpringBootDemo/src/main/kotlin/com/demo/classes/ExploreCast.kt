package com.demo.classes
import com.demo.classes.Course

fun main() {
    val course = Course(1, "Kotlin Programming", "yoonyoung")

    checkType(course)
    checkType("course")

    castNumber(1.0)
    //castNumber(1)

    val number = 1
    val numberDouble = number.toDouble()
    println(numberDouble)
}

fun castNumber(any: Any) {
    when(any) {
        any as Double -> println("Value is Double")
    }
}

fun checkType(type: Any) {
    when(type) {
        is Course -> {
            //val course = type as Course
            println(type.copy())
        }

        is String -> {
            println(type.lowercase())
        }
    }
}
