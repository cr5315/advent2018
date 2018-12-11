import org.junit.Assert.assertEquals
import org.junit.Test

class Day11Tests {
    private val input = 3214

    @Test
    fun testPowerLevel() {
        assertEquals(4, Day11.calculatePowerLevel(3, 5, 8))
        assertEquals(-5, Day11.calculatePowerLevel(122, 79, 57))
        assertEquals(0, Day11.calculatePowerLevel(217, 196, 39))
        assertEquals(4, Day11.calculatePowerLevel(101, 153, 71))
    }

    @Test
    fun partOneSample() {
        assertEquals("33,45", Day11.partOne(18))
        assertEquals("21,61", Day11.partOne(42))
    }

    @Test
    fun partOne() {
        println(Day11.partOne(input))
    }

    @Test
    fun partTwoSample() {
        assertEquals("90,269,16", Day11.partTwo(18))
        assertEquals("232,251,12", Day11.partTwo(42))
    }

    @Test
    fun partTwo() {
        println(Day11.partTwo(input))
    }
}