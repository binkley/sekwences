package hm.binkley.math.sequences

/** @todo How to specify by type that the map is in insertion order? */
fun findSelfLoop(sequence: Sequence<Int>): List<Int> {
    val findSelfLoop = mutableListOf<Int>()
    for (next in sequence)
        if (next in findSelfLoop) break else findSelfLoop += next
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
            val excess = maybe - cap
            cap - excess
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
