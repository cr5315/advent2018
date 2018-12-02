import org.junit.Assert.assertEquals
import org.junit.Test
import util.getResourceAsString

class Day02Tests {

    @Test
    fun partOneSample() {
        assertEquals(12, Day02.partOne("abcdef\nbababc\nabbcde\nabcccd\naabcdd\nabcdee\nababab"))
    }

    @Test
    fun partOne() {
        println(Day02.partOne(getResourceAsString("Day02.txt")))
    }

    @Test
    fun partTwoSample() {
        assertEquals("fgij", Day02.partTwo("abcde\nfghij\nklmno\npqrst\nfguij\naxcye\nwvxyz"))
    }

    @Test
    fun partTwo() {
        println(Day02.partTwo(getResourceAsString("Day02.txt")))
    }
}