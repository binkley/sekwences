package hm.binkley.math.sequences

import hm.binkley.math.sequences.FlipFlop.Companion.flipFlop

fun findSelfLoop(
    seed: Int,
    cap: Int = 100,
    compute: (Int) -> Int = { 2 * it }
): List<Int> {
    val itr = flipFlop(seed, cap, compute).iterator()

    val findSelfLoop = mutableListOf<Int>()
    do {
        // TODO: Technically, the contract for iterator wants a call to
        //  "hasNext" even for the first element guaranteed to be present,
        //  however this confuses JaCoCo branch coverage
        val next = itr.next() // Always has at least 1 value
        if (next in findSelfLoop) break else findSelfLoop += next
    } while (itr.hasNext())

    return findSelfLoop
}

class FlipFlop private constructor(
    val seed: Int,
    val cap: Int,
    private val compute: (Int) -> Int,
) : Sequence<Int> {
    override fun iterator() = generateSequence(seed) {
        val maybe = compute(it)
        if (maybe < cap) {
            maybe
        } else {
            val overage = maybe - cap
            cap - overage
        }
    }.iterator()

    companion object {
        fun flipFlop(
            seed: Int,
            cap: Int = 100,
            compute: (Int) -> Int = { 2 * it },
        ) =
            FlipFlop(seed, cap, compute)
    }
}
