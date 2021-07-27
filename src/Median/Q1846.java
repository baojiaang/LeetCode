package Median;

import java.util.Arrays;

public class Q1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++){
            if(Math.abs(arr[i] - arr[i-1]) >= 1){
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        Q1846 q = new Q1846();
        int[] nums = {1,2,3,4,5};
        System.out.println(q.maximumElementAfterDecrementingAndRearranging(nums));
    }
}
