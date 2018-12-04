object Day04 {

    fun partOne(input: String): Int {
        val guards = buildData(input)

        var longestSleep = -1
        var longestSleeper: Int = -1
        for (id in guards.keys) {
            val totalSlept = guards[id]!!.sumBy { it.last - it.first }
            if (totalSlept > longestSleep) {
                longestSleep = totalSlept
                longestSleeper = id
            }
        }

        val guard = guards[longestSleeper]!!
        val timeSlept = mutableMapOf<Int, Int>()
        for (range in guard) {
            for (i in range) {
                if (!timeSlept.containsKey(i)) timeSlept[i] = 0
                timeSlept[i] = timeSlept[i]!!.plus(1)
            }
        }

        return timeSlept.maxBy { it.value }!!.key * longestSleeper
    }

    fun partTwo(input: String): Int {
        val guards = buildData(input)

        val guardSleep = mutableMapOf<Int, MutableMap<Int, Int>>()

        for (i in 0..59) {
            for (id in guards.keys) {
                for (r in guards[id]!!) {
                    if (r.contains(i)) {
                        if (!guardSleep.containsKey(id)) {
                            guardSleep[id] = mutableMapOf()
                            for (j in 0..59) guardSleep[id]!![j] = 0
                        }

                        guardSleep[id]!![i] = guardSleep[id]!![i]!! + 1
                    }
                }
            }
        }

        var sleeper = -1
        var minute = -1
        var count = -1
        for (i in 0..59) {
            for (id in guardSleep.keys) {
                if (guardSleep[id]!![i]!! > count) {
                    sleeper = id
                    minute = i
                    count = guardSleep[id]!![i]!!
                }
            }
        }

        return sleeper * minute
    }

    private fun buildData(input: String): MutableMap<Int, ArrayList<IntRange>> {
        val guards = mutableMapOf<Int, ArrayList<IntRange>>()

        val data = input.lines().sortedBy { it.split("]")[0] }

        var activeGuard: Int = -1
        var startSleep: Int = -1

        for (line in data) {
            val parts = line.split(" ").toMutableList()
            parts.forEachIndexed { index, s ->
                parts[index] = s.replace("[", "").replace("]", "")
            }

            when (parts[2]) {
                "Guard" -> {
                    activeGuard = parts[3].substring(1).toInt()
                }
                "falls" -> {
                    startSleep = parts[1].split(":")[1].toInt()
                }
                "wakes" -> {
                    if (!guards.containsKey(activeGuard)) guards[activeGuard] = ArrayList()
                    guards[activeGuard]?.add(IntRange(startSleep, parts[1].split(":")[1].toInt() - 1))
                }
            }

        }

        return guards
    }
}