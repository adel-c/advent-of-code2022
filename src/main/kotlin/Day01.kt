class Day01(path: String = "day01/input") {
    private val inputData: List<String> = path.fromResource().readLines()
    fun compute(): Long {
        var index =0
        var sum=0L
        var values = mutableListOf<Long>()
        inputData.forEach{v->
            if(v.isEmpty()){
                values.add(sum)
                index++
                sum=0
            }else{
                sum +=v.toLong()
            }

        }
        return values.maxOf { it }
    }
    fun compute2(): Long {
        return 0
    }
}
