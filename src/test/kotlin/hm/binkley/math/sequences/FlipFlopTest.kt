package hm.binkley.math.sequences

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FlipFlopTest {
    @Test
    fun `should cycle immediately for of seed of 0`() {
        flipFlop(0).take(2).toList() shouldBe listOf(0, 0)
    }

    @Test
    fun `should cycle for of seed of 1`() {
        flipFlop(1).take(14).toList() shouldBe
            listOf(1, 2, 4, 8, 16, 32, 64, 72, 56, 88, 24, 48, 96, 8)
    }
}
