package com.demo.classes

class Person(val name: String = "", val age: Int = 0) {

    var email: String = ""
    var nameLength: Int = 0
    init {
        println("Inside Init block")
        nameLength = name.length
    }

    constructor(_email: String, _name: String = "", _age: Int = 0) : this(_name, _age) {
        email = _email
    }

    fun action() {
        println("Person Walks")
    }
}

fun main() {
    val person = Person("yoonyoung", 26)
    val person2 = Person()
    person.action()
    println("Name: ${person.name} and the age is ${person.age}")
    println("Name: ${person2.name} and the age is ${person2.age}")

    val person3 = Person(_email = "yoon980208@gmail.com", _name = "yoonyoung")
    println("Name: ${person3.name} and the age is ${person3.age} and the email is ${person3.email} and the nameLength is ${person3.nameLength}")
}