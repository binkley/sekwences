package demo

import hm.binkley.math.sequences.FlipFlop.Companion.flipFlop
import hm.binkley.math.sequences.findSelfLoop

/** Runs the demo. */
fun main() {
    demo(
        "An example of \"flip-flop\" with a seed of 1 showing a cycle:",
        1, 100
    ) { it * 2 }

    demo(
        "An example of \"flip-flop\" with a seed of 7 showing merging into a seed of 1:",
        7, 100
    ) { it * 2 }

    demo(
        "67 turns out to be an interesting seed making a spiral of values:",
        67, 100
    ) { it * 2 }

    demo(
        "An example of a different function than 2X (2X + 1):",
        1, 100
    ) { it * 2 + 1 }

    demo(
        "The same example with a boundary of 120 (rather than 100):",
        1, 120
    ) { it * 2 + 1 }
}

private fun demo(
    description: String,
    seed: Int,
    cap: Int,
    compute: (Int) -> Int,
) {
    println(description)
    val sequence = findSelfLoop(flipFlop(seed, cap, compute))
    println("$sequence (length: ${sequence.size})")
}
