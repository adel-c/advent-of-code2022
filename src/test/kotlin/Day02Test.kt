import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Day02Test {

    @Test
    fun test_compute_should_be_X() {
        val day = Day02("day02/inputTest")
        assertEquals(15, day.compute())
    }

    @Test
    fun compute_should_be_X() {
        val day = Day02("day02/input")
        assertEquals(13682, day.compute())
    }
    @Test
    fun test2_compute_should_be_X() {
        val day = Day02("day02/inputTest")
        assertEquals(12, day.compute2())
    }

    @Test
    fun compute2_should_be_X() {
        val day = Day02("day02/input")
        assertEquals(12881, day.compute2())
    }
}
