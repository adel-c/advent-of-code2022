import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Day01Test {

    @Test
    fun test_compute_should_be_X() {
        val day = Day01("day01/inputTest")
        assertEquals(24000, day.compute())
    }

    @Test
    fun compute_should_be_X() {
        val day = Day01("day01/input")
        assertEquals(69693, day.compute())
    }
    @Test
    fun test2_compute_should_be_X() {
        val day = Day01("day01/inputTest")
        assertEquals(0, day.compute2())
    }

    @Test
    fun compute2_should_be_X() {
        val day = Day01("day01/input")
        assertEquals(0, day.compute2())
    }
}
