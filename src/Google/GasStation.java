package Google;

/**
 * https://www.interviewbit.com/problems/gas-station/
 * <p>
 * Given two integer arrays A and B of size N.
 * <p>
 * There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
 * <p>
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and
 * <p>
 * ending up at i again.
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * Output Format
 * <p>
 * Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * For Example
 * <p>
 * Input 1:
 * A =  [1, 2]
 * B =  [2, 1]
 * Output 1:
 * 1
 * Explanation 1:
 * If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1.
 * If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to station 1, which you do and complete the circuit.
 */


public class GasStation {

    public int canCompleteCircuit(final int[] A, final int[] B) {

        for (int i = 0; i < A.length; i++) {
            if (canTravel(A, B, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean canTravel(final int[] A, final int[] B, int startingIndex) {

        int current = startingIndex;

        int availableGas = 0;

        do {
            //Add gas from current station
            availableGas += A[current];

            //Try to travel from current to nextStation
            if (B[current] > availableGas) {
                //Not enough gas to travel to next station
                return false;
            } else {
                //Has gas to travel to next station
                availableGas -= B[current];

                if (current == A.length - 1) {
                    current = 0;
                } else {
                    current += 1;
                }
            }

        } while (current != startingIndex);

        return true;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();

        int[] A = new int[2];

        A[0] = 1;
        A[1] = 2;

        int[] B = new int[2];

        B[0] = 2;
        B[1] = 1;

        System.out.println(gasStation.canCompleteCircuit(A, B));
    }
}
