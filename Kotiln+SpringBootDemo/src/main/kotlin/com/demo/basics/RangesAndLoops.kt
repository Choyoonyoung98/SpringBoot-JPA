package com.demo.basics

fun main() {
    val range = 1..10
    for(i in range) { // .. : create a range of 10 values
        println("i: $i")
    }

    val reverseRange = 10 downTo 1
    for(i in reverseRange) { // downTo: progression of value in decreasing order
        println("reverseRange i: $i")
    }

    for(i in reverseRange step 2) { // skip: skip values in the iteration
        println("reverseRange with Skip: $i")
    }

    exploreWhile()
    exploreDoWhile()
}

fun exploreDoWhile() {
    var i = 0
    do {
        println("Value of i is $i")
        i++
    } while(i < 5)
}

fun exploreWhile() {
    var x = 1
    while(x < 5) {
        println("Value of x is $x")
        x++
    }
}

