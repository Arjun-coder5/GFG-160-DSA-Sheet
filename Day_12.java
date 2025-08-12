public class Day_12 {

    // Kadane's Algorithm - Finds Maximum Subarray Sum in O(n)
    public static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    // Function to find Maximum Circular Subarray Sum
    public static int maxCircularSubarraySum(int[] arr) {
        int maxKadane = kadane(arr); // Case 1: Non-wrapping max

        // If all numbers are negative, return normal Kadane
        if (maxKadane < 0) {
            return maxKadane;
        }

        // Case 2: Wrapping sum = Total sum - min subarray sum
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i]; // Invert the array for finding min subarray
        }

        // Min subarray sum = -Kadane(inverted array)
        int maxWrap = totalSum + kadane(arr);

        return Math.max(maxKadane, maxWrap);
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {5, -2, 3, 4};
        int[] arr2 = {-3, -2, -5};

        System.out.println("Max Circular Subarray Sum (arr1): " + maxCircularSubarraySum(arr1));
        System.out.println("Max Circular Subarray Sum (arr2): " + maxCircularSubarraySum(arr2));
    }
}
