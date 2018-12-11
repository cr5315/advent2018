object Day11 {

    fun partOne(serialNumber: Int): String {
        val grid = Array(300) { IntArray(300) { 0 } }

        for (x in 0 until grid.size) {
            for (y in 0 until grid[x].size) {
                grid[x][y] = calculatePowerLevel(x, y, serialNumber)
            }
        }

        var highestPower = 0
        var location = ""

        for (x in 0 until grid.size - 2) {
            for (y in 0 until grid[x].size - 2) {
                var total = 0

                for (i in 0 until 3) {
                    for (j in 0 until 3) {
                        total += grid[x + i][y + j]
                    }
                }

                if (total > highestPower) {
                    highestPower = total
                    location = "$x,$y"
                }
            }
        }

        return location
    }

    /**
     * This is really really bad because it takes long enough to actually return that I haven't waited it out as
     * the answer is found pretty quickly and printed to stdout
     */
    fun partTwo(serialNumber: Int): String {
        val grid = Array(300) { IntArray(300) { 0 } }

        for (x in 0 until grid.size) {
            for (y in 0 until grid[x].size) {
                grid[x][y] = calculatePowerLevel(x, y, serialNumber)
            }
        }

        var highestPower = 0
        var locationAndSize = ""

        for (size in 1 until 300) {
            for (x in 0 until grid.size - size + 1) {
                for (y in 0 until grid[x].size - size + 1) {
                    var total = 0

                    for (i in 0 until size) {
                        for (j in 0 until size) {
                            total+= grid[x + i][y + j]
                        }
                    }

                    if (total > highestPower) {
                        println("New highest power of $total found with a ${size}x$size grid at $x,$y")
                        highestPower = total
                        locationAndSize = "$x,$y,$size"
                    }
                }
            }
        }

        return locationAndSize
    }

    fun calculatePowerLevel(x: Int, y: Int, serial: Int): Int {
        val rackID = x + 10
        var powerLevel = rackID * y
        powerLevel += serial
        powerLevel *= rackID
        powerLevel /= 100
        powerLevel %= 10
        powerLevel -= 5

        return powerLevel
    }
}