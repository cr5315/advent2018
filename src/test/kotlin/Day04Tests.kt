import org.junit.Assert.assertEquals
import org.junit.Test
import util.getResourceAsString

class Day04Tests {
    private val input = getResourceAsString("Day04.txt")
    private val sampleInput = getResourceAsString("Day04Sample.txt") // I mixed the input up since it's already in order on AoC

    @Test
    fun partOneSample() {
        assertEquals(240, Day04.partOne(sampleInput))
    }

    @Test
    fun partOne() {
        println(Day04.partOne(input))
    }

    @Test
    fun partTwoSample() {
        assertEquals(4455, Day04.partTwo(sampleInput))
    }

    @Test
    fun partTwo() {
        println(Day04.partTwo(input))
    }
}