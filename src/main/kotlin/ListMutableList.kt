package main.kotlin


fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,6,7,8,9)
    val mutableList = list.toMutableList()

    println(list)
    println(mutableList)

    mutableList.removeAt(1)
    mutableList[0] = 100

    println(list)
    println(mutableList)
}