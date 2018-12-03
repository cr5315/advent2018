import org.junit.Assert.assertEquals
import org.junit.Test
import util.getResourceAsString

class Day03Tests {

    @Test
    fun partOneSample() {
        assertEquals(4, Day03.partOne("#1 @ 1,3: 4x4\n#2 @ 3,1: 4x4\n#3 @ 5,5: 2x2"))
    }

    @Test
    fun partOne() {
        println(Day03.partOne(getResourceAsString("Day03.txt")))
    }

    @Test
    fun partTwoSample() {
        assertEquals(3, Day03.partTwo("#1 @ 1,3: 4x4\n#2 @ 3,1: 4x4\n#3 @ 5,5: 2x2"))
    }

    @Test
    fun partTwo() {
        println(Day03.partTwo(getResourceAsString("Day03.txt")))
    }
}