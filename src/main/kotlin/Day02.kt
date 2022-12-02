class Day02(path: String = "day02/input") {
    private val inputData: List<String> = path.fromResource().readLines()
    fun compute(): Long {
        return inputData.filter { it.isNotEmpty() }.map { Choice.parse(it[0]) to Choice.parse(it[2]) }
            .map { (opponent,me) -> me.matchResult(opponent).value + me.value }.sum()
    }

    fun compute2(): Long {
        return 0
    }

    fun isWin(opponentPlay: Choice, play: Choice): Boolean {
        return false
    }
}

enum class Result(val value: Long) {
    WIN(6),
    LOOSE(0),
    DRAW(3)
}

enum class Choice(val value: Long) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);


    fun matchResult(against: Choice): Result {
        if (this == against) return Result.DRAW
        val winningPairs = setOf(
            ROCK to SCISSORS, PAPER to ROCK, SCISSORS to PAPER
        )
        return if (winningPairs.contains(this to against)) {
            Result.WIN
        } else {
            Result.LOOSE
        }

    }

    companion object {
        fun parse(s: Char): Choice {
            return when (s.lowercaseChar()) {
                'a' -> ROCK
                'x' -> ROCK
                'b' -> PAPER
                'y' -> PAPER
                else -> SCISSORS
            }
        }
    }
}
