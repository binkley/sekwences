package hm.binkley.math.sequences

class FlipFlop(
    val cap: Int,
    val seed: Int,
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
            FlipFlop(cap, seed, compute)
    }
}
