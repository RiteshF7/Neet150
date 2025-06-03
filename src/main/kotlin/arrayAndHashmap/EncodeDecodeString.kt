package org.trex.kotlin.arrayAndHashmap

/*Encode and Decode Strings
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
Constraints:    */
fun main() {
    val input = arrayOf("neet", "code")
    EncodeDecodeString.execute(input)
}

object EncodeDecodeString {

    fun execute(strs: Array<String>) {
        val encodedString = encode(strs)
        val decodedString = decode(encodedString)
        decodedString.forEach { print("$it,") }
    }

    private fun encode(strs: Array<String>): String {
        val result = StringBuilder()
        for (i in strs.indices) {
            result.append("${strs[i].length}#${strs[i]}")
        }
        return result.toString()
    }

    private fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        var len = ""
        val actualString = StringBuilder()
        while (i < str.length) {
            val char = str[i]
            if (char == '#') {
                i++
                for (j in 1..len.toInt()) {
                    actualString.append(str[i])
                    i++
                }
                len = ""
                result.add(actualString.toString())
                actualString.clear()

            } else {
                len += char
                i++
            }
        }
        return result
    }


}