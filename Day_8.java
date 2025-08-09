
import java.util.Arrays;


public class Day_8 {


                                              // I use greedy Approach in this :

  // given an arr[] -> representing the height of n towers:
  //integer k
  // We must perform one action in  each tower :
      // 1.Increase its height by k
      // 2.Decrease its height by k
  //Goal:
   //Find the minimum possible difference between the tallest and shortest tower after all modifications.

   //Note:
   // You must change each tower exactly once.
   // The resulting heights must be non-negative.

     /////

//    Example 1
// k = 2
// arr = [1, 5, 8, 10]


// One way:
// 1 + 2 = 3
// 5 - 2 = 3
// 8 - 2 = 6
// 10 - 2 = 8
// New array = [3, 3, 6, 8]
// Max = 8, Min = 3 → Difference = 5
// Answer = 5.

     //////
     
  // Approach :
   // (i) = Sort the Array;
   // (ii) = int ans = arr[n]-arr[0];
   // (iii) = smallest = arr[0] + k and largest = arr[n-1] - k
  //   (iv) = Loop i from 0 to n-2:
  //          minVal = min(smallest, arr[i+1] - k)
  //          maxVal = max(largest, arr[i] + k)
  //          Update ans = min(ans, maxVal - minVal)
  //          (Ensure minVal is not negative — skip if negative)
  //          Return ans.

  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    int n  = arr.length;
    int k = 2;
    int ans = getMinDiff(arr, n,k);
    System.out.println(ans);
  }
  public static int getMinDiff(int arr[] ,int n,int k){
       Arrays.sort(arr);
       int ans  = arr[n-1] - arr[0];
       int smallest = arr[0]+k;
       int largest = arr[n-1]-k;
       for(int i = 0;i<n-1;i++){
         int  minValue = Math.min(smallest,arr[i+1] - k);
          int maxValue = Math.max(largest,arr[i] + k);
              if (minValue < 0) continue;
            ans = Math.min(ans, maxValue - minValue);
       }
       return ans;
  }
}
