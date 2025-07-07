
public class Day_5 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        nextPermutation(arr);  // 🔄 Apply next permutation logic

        System.out.print("\nNext Permutation: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    static void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        //finding the next smallest number:
        while (i >= 0 && arr[i] >= arr[i + 1]) {
              i--;
        }
        //when you find i find the just larger number:
        if(i>=0){
          int j = n-1;
          while(j>=0&&arr[j]<arr[i]){
            j--;
          }
          int t = arr[i];
          arr[i] = arr[j];
          arr[j] = t;
        }
        // reverse the entire array:
        reverse(arr,i+1,n-1);
    }
    static  void reverse(int[] arr,int start,int end){
          while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]  = temp;
            start++;
            end--;
          }
    }
}
