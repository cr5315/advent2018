object Day03 {

    data class Claim(val id: Int, val fromLeft: Int, val fromTop: Int, val width: Int, val height: Int)

    fun partOne(input: String): Int {
        val claims = parseClaims(input)
        val grid = buildGrid(claims)

        var overlapping = 0
        grid.forEach { x -> x.forEach { y -> if (y > 1) overlapping++} }

        return overlapping
    }

    fun partTwo(input: String): Int {
        val claims = parseClaims(input)
        val grid = buildGrid(claims)

        for (c in claims) {
            val overlaps = mutableSetOf<Int>()

            for (x in c.fromLeft until (c.fromLeft + c.width)) {
                for (y in c.fromTop until (c.fromTop + c.height)) {
                    overlaps.add(grid[x][y])
                }
            }

            if (overlaps.size == 1 && overlaps.contains(1)) return c.id
        }

        return 0
    }

    private fun buildGrid(claims: List<Claim>): Array<IntArray> {
        val maxWidth = claims.maxBy { it.fromLeft + it.width }.let { it!!.fromLeft + it.width }
        val maxHeight = claims.maxBy { it.fromTop + it.height }.let { it!!.fromTop + it.height }

        val grid = Array(maxWidth) { IntArray(maxHeight) }

        for (c in claims) {
            for (x in c.fromLeft until (c.fromLeft + c.width)) {
                for (y in c.fromTop until (c.fromTop + c.height)) {
                    grid[x][y]++
                }
            }
        }

        return grid
    }

    private fun parseClaims(input: String): List<Claim> {
        val claims = ArrayList<Claim>()

        for (line in input.lines()) {
            val parts = line.split(" ")
            val id = parts[0].replace("#", "").toInt()
            val fromLeft = parts[2].split(",")[0].toInt()
            val fromTop = parts[2].split(",")[1].dropLast(1).toInt()
            val width = parts[3].split("x")[0].toInt()
            val height = parts[3].split("x")[1].toInt()

            claims.add(Claim(id, fromLeft, fromTop, width, height))
        }

        return claims
    }
}