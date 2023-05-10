package demo

import hm.binkley.math.sequences.FlipFlop.Companion.flipFlop
import hm.binkley.math.sequences.findLoop

/** Runs the demo. */
public fun main() {
    println(
        """
An example of "flip-flop" with a seed of 1 showing a cycle:
${findLoop(flipFlop(1))}
An example of "flip-flop" with a seed of 7 showing merging into a seed of 1:
${findLoop(flipFlop(7))}
        """.trimIndent()
    )
}
