package demo

import hm.binkley.math.sequences.FlipFlop.Companion.flipFlop
import hm.binkley.math.sequences.findSelfLoop
import kotlin.math.exp
import kotlin.math.floor

/** Runs the demo. */
fun main() {
    println(
        """
    RULES:
    1) Start with a seed (integer) and a cap (boundary, default 100).
    2) Apply a rule to find the next value from the present value (default is to double).
    3) When the next value is over the cap, subtract the overage from the cap as the next value.                 
        """.trimIndent()
    )

    demo(
        "An example with a seed of 1 showing a cycle:",
        1,
        100
    ) { it * 2 }

    demo(
        "An example with a seed of 7 showing merging into a seed of 1:",
        7,
        100
    ) { it * 2 }

    demo(
        "67 turns out to be an interesting seed making a spiral of values:",
        67,
        100
    ) { it * 2 }

    demo(
        "Show the boring case of a seed of 0:",
        0,
        100
    ) { it * 2 }

    demo(
        "Another short cycle seed is 50:",
        50,
        100
    ) { it * 2 }

    demo(
        "The seed with the longest run length:",
        findLongestSequence(100) { it * 2 },
        100
    ) { it * 2 }

    demo(
        "The same when boundary is 120 (rather than 100):",
        findLongestSequence(120) { it * 2 },
        120
    ) { it * 2 }

    demo(
        "An example of a different function than 2X (2X + 1):",
        1,
        100
    ) { it * 2 + 1 }

    demo(
        "The same example with a boundary of 120 (rather than 100):",
        1,
        120
    ) { it * 2 + 1 }

    demo(
        "A pathological function for the next sequence value (exponential):",
        1,
        100
    ) { exp(it.toDouble()).toInt() } // "toInt" here is round to zero
}

private fun demo(
    description: String,
    seed: Int,
    cap: Int,
    compute: (Int) -> Int,
) {
    println()
    println(description)
    val sequence = findSelfLoop(flipFlop(seed, cap, compute))
    println(sequence.joinToString())
    println("(length before repeating is ${sequence.size})")
}

private fun findLongestSequence(
    cap: Int,
    compute: (Int) -> Int,
): Int {
    var maxSeed = 0
    var maxLength = 0
    for (seed in 0..cap) {
        val sequence = findSelfLoop(flipFlop(seed, cap, compute))
        if (maxLength < sequence.size) {
            maxSeed = seed
            maxLength = sequence.size
        }
    }
    return maxSeed
}
