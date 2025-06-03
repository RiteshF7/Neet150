package org.trex.kotlin


abstract class BaseExecutor<I, O>() {
    abstract val input: I
    protected abstract fun execute(): O


     fun printOutput(value: O = execute()): O {
        when (value) {
            null -> println("null")
            is Int, is Double, is Float, is Boolean, is Char, is String -> println(value)
            is Array<*> -> println(value.joinToString(", "))
            is IntArray -> println(value.joinToString(", "))
            is DoubleArray -> println(value.joinToString(", "))
            is FloatArray -> println(value.joinToString(", "))
            is BooleanArray -> println(value.joinToString(", "))
            is CharArray -> println(value.joinToString(", "))
            is List<*> -> println(value.joinToString(", "))
            is Set<*> -> println(value.joinToString(", "))
            is Map<*, *> -> println(value.entries.joinToString(", ") { "${it.key} -> ${it.value}" })
            else -> println("Unsupported type: Add type in print Output function!")
        }
        return value
    }


}



