package com.demo.classes

data class Course (
    val id: Int,
    val name: String,
    val author: String
)

fun main() {
    val course1 = Course(1, "Good story", "yoonyoung")
    println(course1)

    val course2 = Course(1, "Good story", "yoonyoung")
    println("Checking Object Equality: ${course1 == course2}") //true

    val course3 = course2.copy(
        id = 3, author = "yoonyoung3"
    )
    println(course3)
}