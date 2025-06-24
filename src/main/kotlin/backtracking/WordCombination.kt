package org.trex.kotlin.backtracking

fun main() {
    val wordCombination = WordCombination()
    wordCombination.finder()
}

class WordCombination {
    private val input = mutableListOf<List<Char>>(
        mutableListOf('A', 'B', 'C', 'E'),
        mutableListOf('S', 'F', 'C', 'S'),
        mutableListOf('A', 'D', 'E', 'E')
    )

    private val word = "ABCCED"

    private val pathSet = mutableSetOf<Pair<Int, Int>>()

    fun finder() {
        var result = false

        outer@ for (i in input.indices) {
            for (j in input[i].indices) {
                if (rec(i, j, 0)) {
                    result = true
                    break@outer
                }

            }
        }

        println("result :: $result")

    }

    private fun rec(i: Int, j: Int, x: Int): Boolean {

        if (x == word.length) return true

        if (i >= input.size || j >= input[0].size || i < 0 || j < 0
            || input[i][j] != word[x] || pathSet.contains(Pair(i, j))
        ) {
            return false
        }

        pathSet.add(Pair(i, j))

        val result = rec(i, j - 1, x + 1) ||

                rec(i, j + 1, x + 1) ||

                rec(i + 1, j, x + 1) ||

                rec(i - 1, j, x + 1)

        pathSet.remove(Pair(i, j))

        return result

    }


}