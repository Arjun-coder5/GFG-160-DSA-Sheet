import java.util.*;

public class Day_11 {
    
    static int maxProduct(int[] arr) {
        int n = arr.length;
        int maxPro = arr[0];
        int minPro = arr[0];
        int result = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                // Swap max and min when current element is negative
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }
            
            int tempMax = Math.max(arr[i], Math.max(arr[i] * maxPro, arr[i] * minPro));
            minPro = Math.min(arr[i], Math.min(arr[i] * maxPro, arr[i] * minPro));
            maxPro = tempMax; 
            
            result = Math.max(result, maxPro);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = maxProduct(arr);
        System.out.println("Maximum Product Subarray: " + ans);
        
        sc.close();
    }
}
