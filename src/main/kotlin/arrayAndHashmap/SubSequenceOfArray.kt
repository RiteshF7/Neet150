package org.trex.kotlin.arrayAndHashmap

import org.trex.kotlin.BaseExecutor


fun main() {
    SubSequenceOfArray().printOutput()
}

class SubSequenceOfArray : BaseExecutor<Pair<String, String>, Boolean>() {

    override val input: Pair<String, String>
        get() = Pair("ab", "baab")


    override fun execute(): Boolean {
        val s = input.first
        val t = input.second
        val charMap = HashMap<Char, ArrayDeque<Int>>()

        for (i in t.indices) {
            charMap.getOrPut(t[i]) { ArrayDeque() }.addLast(i)
            println(charMap.get(t[i]))
        }

        var prevIndex = -1
        for (char in s) {
            val queue = charMap[char] ?: return false

            // Discard all indices before or equal to prevIndex
            while (queue.isNotEmpty() && queue.first() <= prevIndex) {
                queue.removeFirst()
            }

            val currentIndex = queue.removeFirstOrNull() ?: return false
            prevIndex = currentIndex
        }

        return true
    }

//    override fun execute(): Boolean {
//
//        val s = input.first
//        val t = input.second
//        val charMap = HashMap<Char, ArrayDeque<Int>>()
//        for (i in t.indices) {
//            charMap.getOrPut(t[i]) { ArrayDeque() }.addLast(i)
//        }
//        println(charMap)
//        var prevIndex = -1
//        for (char in s) {
//            val queue = charMap[char] ?: return false
//            val currentIndex = queue.removeFirstOrNull() ?: return false
//            if (currentIndex < prevIndex) return false
//            prevIndex = currentIndex
//        }
//        return true
//    }

    fun isSubsequence(s: String, t: String): Boolean {
        val charMap = HashMap<Char, ArrayDeque<Int>>()
        for (i in t.indices) {
            charMap.getOrPut(t[i]) { ArrayDeque() }.addLast(i)
        }

        var prevIndex = -1
        for (char in s) {
            val queue = charMap[char] ?: return false
            val currentIndex = queue.removeFirstOrNull() ?: return false
            if (currentIndex < prevIndex) return false
            prevIndex = currentIndex
        }

        return true
    }

    fun testCases(): List<Pair<Pair<String, String>, Boolean>> = listOf(
        Pair(Pair("abc", "ahbgdc"), true),     // Typical true case
        Pair(Pair("axc", "ahbgdc"), false),    // False case
        Pair(Pair("", "ahbgdc"), true),        // Empty s is always a subsequence
        Pair(Pair("abc", ""), false),          // t is empty, s is not
        Pair(Pair("abc", "abc"), true),        // Exact match
        Pair(Pair("aec", "abcde"), false),     // Skips are not in order
        Pair(Pair("ace", "abcde"), true),      // Valid skipping subsequence
        Pair(Pair("b", "c"), false),           // One-char mismatch
        Pair(Pair("aaaaaa", "bbaaaa"), false)  // Not enough characters in order
    )
}