package com.demo.basics

/*
* shift + shift = 전체 파일명 검색
* cmd + shift + f = 전체 코드 검색
* cmd + b = 선언부로 이동
* ctrl + g = 같은단어 선택
* */
fun main() {
    for (i in 1..5) {
        println("i in $i")
        if (i == 3) break
    }

    label()
    println("End of the program!")
}

fun label() {

    loop@ for (i in 1..5) {
        println("i in label $i")
        innerloop@ for (j in 1..5) {
            println("j in label $j")
            if (j == 2) break@innerloop// inneloop에 대해서만 break문을 걸 수 있다
        }
    }
}
