package com.example.mystudioapplication.domain.util

//Para comprobar la lista
fun <T> isListEqual(first: List<T>, second: List<T>): Boolean{
    //Si la cantidad es igual quye la otra lista
    if (first.size != second.size){
        return false
    }
    return first.zip(second).all { (x,y) -> x == y }
}