package hm.binkley.math.sequences

class FlipFlop(val seed: Int) : Sequence<Int> {
    override fun iterator() = generateSequence(seed) {
        val next = 2 * it
        if (next < 100) next else 100 - (next - 100)
    }.iterator()

    companion object {
        fun flipFlop(seed: Int) = FlipFlop(seed)
    }
}
