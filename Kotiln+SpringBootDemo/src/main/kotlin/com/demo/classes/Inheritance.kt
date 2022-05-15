package com.demo.classes

open class User(val name: String) {
    open var isLoggedIn: Boolean = false
    open fun login() {
        println("Inside user login")
    }

    private fun secret() {
        println("Inside user Login")
    }

    protected open fun logout() {
        //접근연산자 open 함수명 순으로 입력 권장
        //public override fun과 대응되는 구조라서?
        println("Inside user Login")
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

    override fun logout() {
        super.logout()
        println("Inside Student Logout")
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

    val user = User("yoonyoung")
    //user.secret() private, protected 으로는 접근 x

}