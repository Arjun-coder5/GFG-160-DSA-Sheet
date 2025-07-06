public class Day_1 {
    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 1, 3, 8};
        int result = findSecondLargest(arr);
        System.out.println("Second Largest: " + result);
    }
}
