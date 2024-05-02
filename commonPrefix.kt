

import kotlin.collections.arrayListOf
import getCommonPrefix

fun main() {
    val strListFirst = listOf("flower", "flow", "flight")
    val strListSecond = listOf("dog", "racecar", "car")

    println("strListFirst common prefix: " + findCommonPrefix(strListFirst))
    println("strListSecond common prefix: " + findCommonPrefix(strListSecond))
}

fun findCommonPrefix(strList: List<String>): String {
    val result = arrayListOf<String>()
    var startIndex = 0

    do {
        val prefix = strList.getCommonPrefix(startIndex)

        if (!prefix.isNullOrBlank()) {
            result.add(prefix)
            startIndex++
        }
    } while (prefix != null)

    return result.joinToString(separator = "")
}

fun List<String>.getCommonPrefix(index: Int): String? {
    val prefix = first().getOrNull(index)
    val arePrefixCommon = all { it.getOrNull(index) == prefix }

    return prefix.toString().takeIf { arePrefixCommon }
}