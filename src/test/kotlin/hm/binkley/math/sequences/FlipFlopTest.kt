package hm.binkley.math.sequences

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MathFunctionsTest {
    @Test
    fun `should cycle immediately for of seed of 0`() {
        flipFlop.take(2).toList() shouldBe listOf(0, 0)
    }
}
