import java.lang.StringBuilder

object Day02 {

    fun partOne(input: String): Int {
        var twoMatches = 0
        var threeMatches = 0

        for (line in input.split("\n")) {
            val characters: Map<Char, Int> = line.groupingBy { it }.eachCount()
            if (2 in characters.values) twoMatches++
            if (3 in characters.values) threeMatches++
        }

        return twoMatches * threeMatches
    }

    fun partTwo(rawInput: String): String {
        val input = rawInput.lines()
        val commonLetters = StringBuilder()

        for (i in 0 until input.size) {
            val current = input[i]

            for (j in i until input.size) {
                val next = input[j]
                var diff = 0

                commonLetters.clear()

                for (count in 0 until current.length) {
                    if (current[count] != next[count]) diff++
                    else commonLetters.append(current[count])
                }

                if (diff == 1) return commonLetters.toString()
            }
        }

        return commonLetters.toString()
    }
}