package org.trex.kotlin

/*Valid Anagram
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true
Example 2:

Input: s = "jar", t = "jam"

Output: false*/
fun main() {
    val result = AnagramFinder.findAnagram("jar", "jam")
    println(result)
}

object AnagramFinder {
    fun findAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val charMapS = hashMapOf<Char, Int>()
        val charMapT = hashMapOf<Char, Int>()

        for (i in s.indices) {
            var char = s[i]
            charMapS[char] = charMapS.getOrDefault(char, 0) + 1
            char = t[i]
            charMapT[char] = charMapT.getOrDefault(char, 0) + 1
        }

        for (char in s) {
            if (charMapS[char] != charMapT[char]) {
                return false
            }
        }


        return true
    }
}

