import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class TravellingPeopleTest {

    private lateinit var travellingPeople: TravellingPeople

    @Before
    fun setUp() {
        travellingPeople = TravellingPeople()
    }

    @Test
    fun `Travelling People - People to A`() {
        //GIVEN
        val data = arrayListOf(Pair(10, 20), Pair(30, 20), Pair(40, 70), Pair(20, 20))

        //WHEN
        val peopleGoingToA = travellingPeople.getPeopleGoingToCityA(data)

        //THEN
        assertEquals(listOf(0, 2), peopleGoingToA)
    }

    @Test
    fun `Travelling People - People to B`() {
        //GIVEN
        val data = arrayListOf(Pair(10, 20), Pair(30, 20), Pair(40, 70), Pair(20, 20))

        //WHEN
        val peopleGoingToB = travellingPeople.getPeopleGoingToCityB(data)

        //THEN
        assertEquals(listOf(1, 3), peopleGoingToB)
    }

    @Test
    fun `Travelling People - People all same - City A`() {
        //GIVEN
        val data = arrayListOf(Pair(10, 20), Pair(10, 20), Pair(10, 20), Pair(10, 20), Pair(10, 20))

        //WHEN
        val peopleGoingToA = travellingPeople.getPeopleGoingToCityA(data)

        //THEN
        assertEquals(listOf(0, 1), peopleGoingToA)
    }

    @Test
    fun `Travelling People - People all same - city B`() {
        //GIVEN
        val data = arrayListOf(Pair(10, 20), Pair(10, 20), Pair(10, 20), Pair(10, 20), Pair(10, 20))

        //WHEN
        val peopleGoingToB = travellingPeople.getPeopleGoingToCityB(data)

        //THEN
        assertEquals(listOf(2, 3, 4), peopleGoingToB)
    }

    @Test
    fun `Travelling People - People all same difference - City A`() {
        //GIVEN
        val data = arrayListOf(Pair(40, 70), Pair(60, 90), Pair(10, 40), Pair(30, 60), Pair(20, 50), Pair(50, 80))

        //WHEN
        val peopleGoingToA = travellingPeople.getPeopleGoingToCityA(data)

        //THEN
        assertEquals(listOf(2, 3, 4), peopleGoingToA)
    }

    @Test
    fun `Travelling People - People all same difference - City B`() {
        //GIVEN
        val data = arrayListOf(Pair(40, 70), Pair(60, 90), Pair(10, 40), Pair(30, 60), Pair(20, 50), Pair(50, 80))

        //WHEN
        val peopleGoingToB = travellingPeople.getPeopleGoingToCityB(data)

        //THEN
        assertEquals(listOf(0, 1, 5), peopleGoingToB)
    }

    @Test
    fun `Travelling People - Random order - City A`() {
        //GIVEN
        val data = arrayListOf(Pair(100, 60), Pair(70, 50), Pair(90, 40), Pair(50, 120), Pair(90, 50), Pair(80, 80))

        //WHEN
        val peopleGoingToA = travellingPeople.getPeopleGoingToCityA(data)

        //THEN
        assertEquals(listOf(1, 3, 5), peopleGoingToA)
    }

    @Test
    fun `Travelling People - Random order - City B`() {
        //GIVEN
        val data = arrayListOf(Pair(100, 60), Pair(70, 50), Pair(90, 40), Pair(50, 120), Pair(90, 50), Pair(80, 80))

        //WHEN
        val peopleGoingToB = travellingPeople.getPeopleGoingToCityB(data)

        //THEN
        assertEquals(listOf(0, 2, 4), peopleGoingToB)
    }

    @Test
    fun `Travelling People - Only 2 people - City A`() {
        //GIVEN
        val data = arrayListOf(Pair(100, 110), Pair(35, 25))

        //WHEN
        val peopleGoingToA = travellingPeople.getPeopleGoingToCityA(data)

        //THEN
        assertEquals(listOf(0), peopleGoingToA)
    }

    @Test
    fun `Travelling People - Only 2 people - City B`() {
        //GIVEN
        val data = arrayListOf(Pair(100, 110), Pair(35, 25))

        //WHEN
        val peopleGoingToB = travellingPeople.getPeopleGoingToCityB(data)

        //THEN
        assertEquals(listOf(1), peopleGoingToB)
    }

    @Test
    fun `Travelling People - Only 2 people - Similar Total cost - City A`() {
        //GIVEN
        val data = arrayListOf(Pair(100, 110), Pair(35, 45))

        //WHEN
        val peopleGoingToA = travellingPeople.getPeopleGoingToCityA(data)

        //THEN
        assertEquals(listOf(1), peopleGoingToA)
    }

    @Test
    fun `Travelling People - Only 2 people - Similar Total cost - City B`() {
        //GIVEN
        val data = arrayListOf(Pair(100, 110), Pair(35, 45))

        //WHEN
        val peopleGoingToB = travellingPeople.getPeopleGoingToCityB(data)

        //THEN
        assertEquals(listOf(0), peopleGoingToB)
    }

    @Test
    fun `Travelling People - Optimised - A less than B with Same difference`() {
        //GIVEN
        val data = arrayListOf(Pair(40, 70), Pair(60, 90), Pair(10, 40), Pair(30, 60), Pair(20, 50), Pair(50, 80))

        //WHEN
        val travellingPeople = travellingPeople.travellingPeople(data)

        //THEN
        val expectedA = listOf(2, 3, 4)
        val expectedB = listOf(0, 1, 5)
        assertEquals(expectedA, travellingPeople.first)
        assertEquals(expectedB, travellingPeople.second)


        //Verification
        println(data)
        println("Cost for A: ${costForA(expectedA, data)}")
        println("Cost for B: ${costForB(expectedB, data)}")
        println("Total Cost: ${costForA(expectedA, data) + costForB(expectedB, data)}")
    }

    @Test
    fun `Travelling People - Optimised - A greater than B with Same difference`() {
        //GIVEN
        val data = arrayListOf(Pair(70, 40), Pair(90, 60), Pair(40, 10), Pair(60, 30), Pair(50, 20), Pair(80, 50))

        //WHEN
        val travellingPeople = travellingPeople.travellingPeople(data)

        //THEN
        val expectedA = listOf(2, 3, 4)
        val expectedB = listOf(0, 1, 5)
        assertEquals(expectedA, travellingPeople.first)
        assertEquals(expectedB, travellingPeople.second)


        //Verification
        println(data)
        println("Cost for A: ${costForA(expectedA, data)}")
        println("Cost for B: ${costForB(expectedB, data)}")
        println("Total Cost: ${costForA(expectedA, data) + costForB(expectedB, data)}")
    }

    @Test
    fun `Travelling People - Optimised - A and B mixed values`() {
        //GIVEN
        val data = arrayListOf(Pair(100, 60), Pair(70, 50), Pair(90, 40), Pair(50, 120), Pair(90, 50), Pair(80, 80))

        //WHEN
        val travellingPeople = travellingPeople.travellingPeople(data)

        //THEN
        val expectedA = listOf(1, 3, 5)
        val expectedB = listOf(0, 2, 4)
        assertEquals(expectedA, travellingPeople.first)
        assertEquals(expectedB, travellingPeople.second)

        //Verification
        println(data)
        println("Cost for A: ${costForA(expectedA, data)}")
        println("Cost for B: ${costForB(expectedB, data)}")
        println("Total Cost: ${costForA(expectedA, data) + costForB(expectedB, data)}")
    }

    @Test
    fun `Travelling People - Optimised - Very high B value`() {
        //GIVEN
        val data = arrayListOf(Pair(40, 70), Pair(60, 90), Pair(10, 40), Pair(30, 60), Pair(20, 50), Pair(50, 8000))

        //WHEN
        val travellingPeople = travellingPeople.travellingPeople(data)

        //THEN
        val expectedA = listOf(2, 4, 5)
        val expectedB = listOf(0, 1, 3)
        assertEquals(expectedA, travellingPeople.first)
        assertEquals(expectedB, travellingPeople.second)

        //Verification
        println(data)
        println("Cost for A: ${costForA(expectedA, data)}")
        println("Cost for B: ${costForB(expectedB, data)}")
        println("Total Cost: ${costForA(expectedA, data) + costForB(expectedB, data)}")
    }

    //Extra

    private fun costForA(people: List<Int>, data: ArrayList<Pair<Int, Int>>): Int {
        var cost = 0

        for (i in people) {
            cost += data[i].first
        }

        return cost
    }

    private fun costForB(people: List<Int>, data: ArrayList<Pair<Int, Int>>): Int {
        var cost = 0

        for (i in people) {
            cost += data[i].second
        }

        return cost
    }
}