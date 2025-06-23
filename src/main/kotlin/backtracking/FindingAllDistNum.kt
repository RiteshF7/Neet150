package org.trex.kotlin.backtracking




fun main() {

    val finder = CombinationOfSum()
    finder.findUniqueCombinations()
    finder.printResult()


}

class CombinationOfSum() {

    private val result: MutableList<List<Int>> = mutableListOf()
    private val candidate = mutableListOf(2, 5, 6, 9)
    private val target = 9

    fun findUniqueCombinations() {
        dfs(0, mutableListOf(), 0)
    }

    private fun dfs(i: Int, current: MutableList<Int>, total: Int) {

        //base cases
        if (total == target) {
            result.add(current.toList())
            return
        }

        if (i > candidate.size - 1 || total > target) return

        current.add(candidate[i])
        dfs(i, current, total + candidate[i])
        current.removeLast()
        dfs(i + 1, current, total)
        return

    }

    fun printResult() {
        println()
        result.forEach { print("$it,") }
    }


}