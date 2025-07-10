import java.util.*;

/**
 * This class provides a method to find all elements in an array
 * that appear more than n/3 times.
 * 
 * Algorithm used: Extended Boyer-Moore Voting Algorithm
 */
public class Day_6 {

    /**
     * Finds elements that appear more than n/3 times in the array.
     * 
     * @param arr The input array of integers.
     * @return A sorted list of majority elements (each appearing > n/3 times).
     */
    public static ArrayList<Integer> findMajority(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        int count1 = 0, count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;

        // Step 1: Find possible candidates
        for (int num : arr) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the actual counts of candidates
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Step 3: Add valid candidates to the result list
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        Collections.sort(result); // GFG typically wants sorted results
        return result;
    }

    // Sample usage
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 1, 1, 2, 2};
        ArrayList<Integer> majorityElements = findMajority(arr);

        System.out.println("Majority elements (> n/3): " + majorityElements);
    }
}
