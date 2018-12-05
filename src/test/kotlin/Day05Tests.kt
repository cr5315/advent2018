import org.junit.Assert.assertEquals
import org.junit.Test
import util.getResourceAsString

class Day05Tests {
    private val input = getResourceAsString("Day05.txt")
    private val sample = "dabAcCaCBAcCcaDA"

    @Test
    fun partOneSample() {
        assertEquals(10, Day05.partOne(sample))
    }

    @Test
    fun partOne() {
        println(Day05.partOne(input))
    }

    @Test
    fun partTwoSample() {
        assertEquals(4, Day05.partTwo(sample))
    }

    @Test
    fun partTwo() {
        println(Day05.partTwo(input))
    }
}