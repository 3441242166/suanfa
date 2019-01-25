package main.leetcode


fun lengthOfLongestSubstring(s: String): Int {
    var sum = 0
    var temp = 0
    val map = HashMap<Char,Int>()

    val str = s.toCharArray()

    for((index,nowChar) in str.withIndex()){
        if (map.containsKey(nowChar)){
            if(index - map[nowChar]!! > temp){
                println("index = $index char = $nowChar")
                temp++
            }else{
                sum = Math.max(sum,temp)
                temp = index - map[nowChar]!!
            }
            map[nowChar] = index
        }else{
            map[nowChar] = index
            temp++
        }
    }
    sum = Math.max(sum,temp)
    return sum
}


fun main(args:Array<String>) {
    print(lengthOfLongestSubstring("abcabcbb"))
}