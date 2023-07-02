package hm.binkley.math.sequences

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FlipFlopTest {
    @Test
    fun `should find the trivial self loop with the default 2X function`() {
        findSelfLoop(0) shouldBe listOf(0)
    }

    @Test
    fun `should find loops with defaults`() {
        findSelfLoop(1) shouldBe
            listOf(1, 2, 4, 8, 16, 32, 64, 72, 56, 88, 24, 48, 96)
    }

    @Test
    fun `should find loops with defaults and a non-special seed`() {
        findSelfLoop(17) shouldBe
            listOf(17, 34, 68, 64, 72, 56, 88, 24, 48, 96, 8, 16, 32)
    }

    @Test
    fun `should find loops with an alternate cap`() {
        findSelfLoop(1, 4) shouldBe listOf(1, 2, 4, 0)
    }

    @Test
    fun `should find loops with an alternative compute function`() {
        findSelfLoop(1) { 0 } shouldBe listOf(1, 0)
    }
}
