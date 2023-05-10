package hm.binkley.math.sequences

import hm.binkley.math.sequences.FlipFlop.Companion.flipFlop
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FlipFlopTest {
    @Test
    fun `should show the seed`() {
        flipFlop(99).seed shouldBe 99
    }

    @Test
    fun `should show the cap`() {
        flipFlop(0, 99).cap shouldBe 99
    }

    @Test
    fun `should use the compute function`() {
        flipFlop(33) { it }.take(2).toList() shouldBe listOf(33, 33)
    }

    @Test
    fun `should cycle immediately for a seed of 0`() {
        flipFlop(0).take(2).toList() shouldBe listOf(0, 0)
    }

    @Test
    fun `should cycle for a seed of 1`() {
        flipFlop(1).take(14).toList() shouldBe
            listOf(1, 2, 4, 8, 16, 32, 64, 72, 56, 88, 24, 48, 96, 8)
    }

    @Test
    fun `should cycle for a seed of 3`() {
        flipFlop(3).take(14).toList() shouldBe
            listOf(3, 6, 12, 24, 48, 96, 8, 16, 32, 64, 72, 56, 88, 24)
    }

    @Test
    fun `should cycle for a seed of 5`() {
        flipFlop(5).take(6).toList() shouldBe
            listOf(5, 10, 20, 40, 80, 40)
    }

    @Test
    fun `should cycle for a seed of 7`() {
        flipFlop(7).take(5).toList() shouldBe
            listOf(7, 14, 28, 56, 88)
    }

    @Test
    fun `should cycle for a seed of 50`() {
        flipFlop(50).take(3).toList() shouldBe listOf(50, 100, 0)
    }

    @Test
    fun `should cycle for a seed of 100`() {
        flipFlop(100).take(2).toList() shouldBe listOf(100, 0)
    }

    @Test
    fun `should find loops`() {
        findLoop(sequenceOf()) shouldBe listOf()
        findLoop(sequenceOf(1, 2, 3, 2)) shouldBe listOf(1, 2, 3)
    }
}
