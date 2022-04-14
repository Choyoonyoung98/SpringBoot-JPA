package com.demo.basics

fun main() {
    var name = "yoonyoung"
    if(name.length == 4) println("4")
    else println("$name length is not 4")

    var position = 1
    val medal = if(position == 1) {
        "GOLD"
    } else if(position == 2) {
        "SILVER"
    } else if(position == 3) {
        "BRONZE"
    } else {
        "NO MEDAL"
    }

    println(medal)

    val medal2 = when (position) {
        1 -> "GOLD"
        2 -> "SILVER"
        3 -> "BRONZE"
        else -> "NO MEDAL"
    }

    println(medal2)
}