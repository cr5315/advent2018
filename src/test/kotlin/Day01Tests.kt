import org.junit.Assert.assertEquals
import org.junit.Test
import util.getResourceAsString

class Day01Tests {

    @Test
    fun partOneSamples() {
        assertEquals(Day01.partOne("+1\n+1\n+1"), 3)
        assertEquals(Day01.partOne("+1\n+1\n-2"), 0)
        assertEquals(Day01.partOne("-1\n-2\n-3"), -6)
    }

    @Test
    fun partOne() {
        println(Day01.partOne(getResourceAsString("Day01.txt")))
    }

    @Test
    fun partTwoSamples() {
        assertEquals(Day01.partTwo("+1\n-1"), 0)
        assertEquals(Day01.partTwo("+3\n+3\n+4\n-2\n-4"), 10)
        assertEquals(Day01.partTwo("-6\n+3\n+8\n+5\n-6"), 5)
        assertEquals(Day01.partTwo("+7\n+7\n-2\n-7\n-4"), 14)
    }

    @Test
    fun partTwo() {
        println(Day01.partTwo(getResourceAsString("Day01.txt")))
    }
}