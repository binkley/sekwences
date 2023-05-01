package hm.binkley.math.sequences

class FlipFlop(val cap: Int, val seed: Int) : Sequence<Int> {
    override fun iterator() = generateSequence(seed) {
        val maybe = 2 * it
        if (maybe < cap) maybe else cap - (maybe - cap)
    }.iterator()

    companion object {
        fun flipFlop(seed: Int) = FlipFlop(100, seed)
    }
}
