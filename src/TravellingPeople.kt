
/**
 *
 * Problem Statement:
 *
 * Given a ArrayList of tuples
 * Pair(A, B)
 *
 * This value indicates cost of transportation for a person to travel to
 * A -> City A
 * B -> City B
 *
 * Find out the equal distribution of people so that the overall transportation cost can be minimised
 * Priority is to get people with lesser cost to City A because of budget issues.
 */

class TravellingPeople {

    fun getPeopleGoingToCityA(data: ArrayList<Pair<Int, Int>>): List<Int> {
        return peopleGoingToCityOptimised('A', data)
    }

    fun getPeopleGoingToCityB(data: ArrayList<Pair<Int, Int>>): List<Int> {
        return peopleGoingToCityOptimised('B', data)
    }

    private fun peopleGoingToCity(city: Char, data: ArrayList<Pair<Int, Int>>): List<Int> {

        val peopleTable = ArrayList<Pair<Int, Pair<Int, Int>>>(data.size)

        // Add people to List with identifier
        for (person in data.withIndex()) {
            peopleTable.add(Pair(person.index, person.value))
        }

        // Sort people List to get least value for city A
        val sortedPeopleTable = peopleTable.sortedBy {
            it.second.first
        }


        //Difference between cost for a person.
        // -ve -> City A cheaper
        // +ve -> City B cheaper
        val differenceTable = ArrayList<Pair<Int, Int>>(sortedPeopleTable.size)

        for (person in sortedPeopleTable) {
            differenceTable.add(Pair(person.first, (person.second.first - person.second.second)))
        }

        // Sort difference to keep City A visitors at top
        val sortedList = differenceTable.sortedBy {
            it.second
        }

        if (city == 'A')
            return sortedList.map { it.first }.subList(0, data.size / 2).sorted()

        if (city == 'B')
            return sortedList.map { it.first }.subList(data.size / 2, data.size).sorted()

        return emptyList()
    }

    private fun peopleGoingToCityOptimised(city: Char, data: ArrayList<Pair<Int, Int>>): List<Int> {

        //User Id
        //Pair (Cost, Cost)
        //Cost Difference
        val table = ArrayList<Triple<Int, Pair<Int, Int>, Int>>(data.size)

        //Difference between cost for a person.
        // -ve -> City A cheaper
        // +ve -> City B cheaper

        // Add people to List with identifier
        for (person in data.withIndex()) {
            table.add(Triple(person.index, person.value, (person.value.first - person.value.second)))
        }


        val sortedTable = table.sortedBy {
            it.second.first
        }.sortedBy {
            it.third
        }


        if (city == 'A')
            return sortedTable.map { it.first }.subList(0, data.size / 2).sorted()

        if (city == 'B')
            return sortedTable.map { it.first }.subList(data.size / 2, data.size).sorted()

        return emptyList()
    }


    //Most optimised solution
    fun travellingPeople(data: ArrayList<Pair<Int, Int>>): Pair<List<Int>, List<Int>> {

        val table = ArrayList<Triple<Int, Pair<Int, Int>, Int>>(data.size)

        for (person in data.withIndex()) {
            table.add(Triple(person.index, person.value, (person.value.first - person.value.second)))
        }

        val sortedTable = table.sortedBy {
            it.second.first
        }.sortedBy {
            it.third
        }

        return Pair(
                sortedTable.map { it.first }.subList(0, data.size / 2).sorted(),
                sortedTable.map { it.first }.subList(data.size / 2, data.size).sorted())
    }
}