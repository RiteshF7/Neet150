package org.trex.kotlin


abstract class BaseExecutor<I, O>() {
    protected abstract val input: I
    protected abstract fun execute(): O


    fun printOutput(output: O = execute()): O {
        when (output) {
            null -> println("null")
            is Int, is Double, is Float, is Boolean, is Char, is String -> println(output)
            is Array<*> -> println(output.joinToString(", "))
            is IntArray -> println(output.joinToString(", "))
            is DoubleArray -> println(output.joinToString(", "))
            is FloatArray -> println(output.joinToString(", "))
            is BooleanArray -> println(output.joinToString(", "))
            is CharArray -> println(output.joinToString(", "))
            is List<*> -> println(output.joinToString(", "))
            is Set<*> -> println(output.joinToString(", "))
            is Map<*, *> -> println(output.entries.joinToString(", ") { "${it.key} -> ${it.value}" })
            else -> println("Unsupported type: Add type in print Output function!")
        }
        return output
    }


}



