import kotlin.concurrent.fixedRateTimer

class Day02(path: String = "day02/input") {
    private val inputData: List<String> = path.fromResource().readLines()
    fun compute(): Long {
        return inputData.filter { it.isNotEmpty() }.map { Choice.parse(it[0]) to Choice.parse(it[2]) }
            .sumOf { (opponent, me) -> me.matchResult(opponent).value + me.value }
    }

    fun compute2(): Long {
        return   return inputData.filter { it.isNotEmpty() }
            .map { Choice.parse(it[0]) to Result.parse(it[2]) }.sumOf { (opponent, result) ->
                computeRequiredPlay(opponent, result).value + result.value
            }
    }

    private fun computeRequiredPlay(opponentPlay: Choice, result: Result): Choice {

        return when(result){
            Result.DRAW->opponentPlay
            Result.LOOSE->  Choice.winningMap[opponentPlay]!!
            Result.WIN->Choice.loosingMap[opponentPlay]!!
        }
    }
}

enum class Result(val value: Long) {
    WIN(6),
    LOOSE(0),
    DRAW(3);
    companion object {
        fun parse(s: Char): Result {
            return when (s.lowercaseChar()) {
                'x' -> LOOSE
                'y' -> DRAW
                'z' -> WIN
                else -> TODO()
            }
        }
    }
}

enum class Choice(val value: Long) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);


    fun matchResult(against: Choice): Result {
        if (this == against) return Result.DRAW

        return if (winningPairs.contains(this to against)) {
            Result.WIN
        } else {
            Result.LOOSE
        }

    }

    companion object {
        val winningPairs = setOf(
            ROCK to SCISSORS, PAPER to ROCK, SCISSORS to PAPER
        )
        val winningMap= winningPairs.toMap()
        val loosingMap= mapOf<Choice,Choice>(
            ROCK to PAPER, PAPER to SCISSORS, SCISSORS to ROCK
        )
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
