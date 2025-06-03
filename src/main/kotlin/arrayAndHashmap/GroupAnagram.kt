package org.trex.kotlin.arrayAndHashmap

/*
Group Anagrams
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
Example 2:

Input: strs = ["x"]

Output: [["x"]]
*/

fun main() {
    val result =
        GroupAnagram.findGroupAnagramWithoutSorting(
            arrayOf(
                "act",
                "cat",
                "pots",
                "tops",
                "stop",
                "hat"
            )
        )

    result.forEach { list ->
        list.forEach {
            print("$it,")
        }
        println()
    }
}

object GroupAnagram {
    fun findGroupAnagramUsingMap(strs: Array<String>): MutableList<List<String>> {
        val strMap = hashMapOf<String, MutableList<String>>()
        val result = mutableListOf(listOf<String>())
        for (s in strs) {
            val sortedKey = s.toCharArray().sorted().joinToString("")
            strMap.apply {
                val current = getOrDefault(sortedKey, mutableListOf<String>())
                current.add(s)
                put(sortedKey, current)
            }
        }

        strMap.forEach { (t, u) ->
            result.add(u)
        }

        return result
    }

    fun findGroupAnagramWithoutSorting(strs: Array<String>): MutableList<List<String>> {
        val strmap = HashMap<String, MutableList<String>>()
        val result = mutableListOf(listOf<String>())

        for (str in strs) {
            val uniqKey = anagramHash(str)
            strmap.apply {
                val current = getOrDefault(uniqKey, mutableListOf())
                current.add(str)
                put(uniqKey, current)
            }
        }
        strmap.forEach { (t, u) ->
            result.add(u)
        }

        return result
    }

    private fun anagramHash(s: String): String {
        val freq = IntArray(26)

        for (char in s) {
            if (char in 'a'..'z') freq[char - 'a']++
        }

        return freq.joinToString("#")
    }


}