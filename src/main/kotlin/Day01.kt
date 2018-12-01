object Day01 {

    fun partOne(input: String): Int = inputAsIntList(input).sum()

    fun partTwo(input: String): Int {
        val frequencies = inputAsIntList(input)
        var currentFrequency = 0
        val pastFrequencies = HashSet<Int>()
        pastFrequencies.add(currentFrequency) // The first frequency counts I guess

        while (true) {
            for (frequency in frequencies) {
                currentFrequency += frequency

                if (pastFrequencies.contains(currentFrequency)) return currentFrequency
                else pastFrequencies.add(currentFrequency)
            }
        }
    }

    private fun inputAsIntList(input: String): List<Int> {
        return input.replace("+", "").split("\n").map { it.trim().toInt() }
    }
}