package org.trex.kotlin.stack

import org.trex.kotlin.BaseExecutor

fun main() {
    ValidParenthesis().printOutput()
}

class ValidParenthesis : BaseExecutor<String, Boolean>() {
    override val input: String
        get() = "{[()]}"

    override fun execute(): Boolean {
        val stack = ArrayDeque<Char>()
        val pMap = HashMap<Char, Char>()
        pMap['('] = ')'
        pMap['{'] = '}'
        pMap['['] = ']'

        for (char in input) {
            if (pMap.contains(char)) {
                stack.addFirst(char)
            } else if (stack.isEmpty() || pMap[stack.removeFirst()] != char) {
                return false
            }
        }
        return true
    }
}