package demo

import hm.binkley.math.sequences.flipFlop

/** Runs the demo. */
public fun main() {
    println("An example of \"flip-flop\" with a seed of 1 showing the cycle:")
    println(flipFlop(1).take(14).toList())
}
