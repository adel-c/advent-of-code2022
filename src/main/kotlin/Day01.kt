class Day01(path: String = "day01/input") {
    private val inputData: List<String> = path.fromResource().readLines()
    fun compute(): Long {
        val values = sumPerPerson()

        return values.maxOf { it }
    }

    private fun sumPerPerson(): MutableList<Long> {
        var index = 0
        var sum = 0L
        var values = mutableListOf<Long>()
        inputData.forEach { v ->
            if (v.isEmpty()) {
                values.add(sum)
                index++
                sum = 0
            } else {
                sum += v.toLong()
            }

        }
        values.add(sum)
        return values
    }

    fun compute2(): Long {
        val values = sumPerPerson()

        return values.sortedDescending().take(3).sum()
    }
}
