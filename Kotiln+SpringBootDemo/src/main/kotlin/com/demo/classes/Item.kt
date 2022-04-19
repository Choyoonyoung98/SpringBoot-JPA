package com.demo.classes

class Item() {
    var name: String = ""

    constructor(_name: String) : this() {
        name = _name
    }
}

fun main() {
    val item = Item("iPhone XS")
    print("Item name is ${item.name}")
    item.name = "iPhone13"
    print("Item name is ${item.name}")
}