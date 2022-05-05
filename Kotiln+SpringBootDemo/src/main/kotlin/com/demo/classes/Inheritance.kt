package com.demo.classes

open class User(val name: String) {
    open var isLoggedIn: Boolean = false
    open fun login() {
        println("Inside user login")
    }
}

class Student(name: String): User(name) {
    override var isLoggedIn: Boolean = false

    companion object {

        const val noOfEnrolledCourses = 10
        fun country() = "USA"
    }

    override fun login() {
        println("Inside Student Login")
        super.login()
    }
}

class Instructor(name: String): User(name)

fun main() {
    val student = Student("Alex")
    println("name is ${student.name}")
    student.login()

    //static function
    val country = Student.country()
    println("Country is: $country")

    println("EnrolledCourses is ${Student.noOfEnrolledCourses}")

    val instructor = Instructor("Yoonyoung")
    println("name is ${instructor.name}")
    instructor.login()
}