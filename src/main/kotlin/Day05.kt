object Day05 {

    fun partOne(input: String): Int {
        var units = input.trim()

        do {
            val pos = findReaction(units)
            if (pos != -1) {
                units = units.removeRange(pos, pos + 2) // pos + 2 is the first character we want to keep
            }
        } while (pos != -1)

        return units.length
    }

    private fun findReaction(units: String): Int {
        for (i in 0 until units.length - 1) {
            if (units[i].equalsOppositeCase(units[i + 1])) return i
        }

        return -1
    }

    // I'm sorry
    fun partTwo(input: String): Int {
        val chars = "abcdefghijklmnopqrstuvwxyz"
        val lengths = mutableMapOf<Char, Int>()

        for (c in chars) {
            println("Processing $c")
            var units = input.trim()
            units = units.replace(c.toString(), "", true)
            lengths[c] = partOne(units)
        }

        return lengths.minBy { it.value }!!.value
    }

    private fun Char.equalsOppositeCase(other: Char): Boolean {
        return if (this.equalsIgnoreCase(other)) {
            when {
                this.isUpperCase() -> other.isLowerCase()
                this.isLowerCase() -> other.isUpperCase()
                else -> false
            }
        } else {
            false
        }
    }

    private fun Char.equalsIgnoreCase(other: Char): Boolean {
        return this.toLowerCase() == other.toLowerCase()
    }
}