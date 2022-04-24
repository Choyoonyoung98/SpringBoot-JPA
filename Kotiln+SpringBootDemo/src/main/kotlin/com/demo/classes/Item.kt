package com.demo.classes

class Item() {
    var name: String = ""
    var price: Int = 0
    //get () = field
    get() {
        println("Inside getter")
        return field
    }
    set(value) {
        println("Inside the setter")
        if(value >= 0) {
            field = value
        } else {
            throw IllegalArgumentException("Negative Price is not Allowed!")
        }
    }
    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item = Item("iPhone XS")
    println("Item name is ${item.name}")
    item.name = "iPhone13"
    println("Item name is ${item.name}")

    item.price = 10
    println(item.price)
    item.price = -10
    println(item.price)
}