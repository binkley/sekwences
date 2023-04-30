package hm.binkley.math.sequences

fun flipFlop(seed: Int) = generateSequence(seed) {
    val more = 2 * it
    if (more <= 100) more else 100 - (more - 100)
}
