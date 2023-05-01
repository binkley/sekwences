package demo

import hm.binkley.math.sequences.FlipFlop.Companion.flipFlop

/** Runs the demo. */
public fun main() {
    println(
        """
An example of "flip-flop" with a seed of 1 showing a cycle:
${flipFlop(1).take(14).toList()}
An example of "flip-flop" with a seed of 7 showing merging into a seed of 1:
${flipFlop(7).take(5).toList()}
        """.trimIndent()
    )
}
