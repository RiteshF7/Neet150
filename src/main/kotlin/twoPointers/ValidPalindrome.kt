package org.trex.kotlin.twoPointers

import org.trex.kotlin.BaseExecutor

fun main() {
    ValidPalindrome().printOutput()
}

class ValidPalindrome() : BaseExecutor<String, Boolean>() {
    override val input: String
        get() = "Was it a car or a cat I saw?"


    override fun execute(): Boolean {
        var strs = input
        val regex = Regex("[^A-Za-z0-9]")
        strs = strs.replace(regex, "")
        var left = 0
        var right = strs.length - 1
        while (left <= right) {
            if (strs[left].lowercaseChar() != strs[right].lowercaseChar()) {
                return false
            } else {
                left++
                right--
            }

        }
        return true
    }
}