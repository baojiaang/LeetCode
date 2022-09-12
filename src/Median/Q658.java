package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp,(a,b)->(Math.abs(a-x)-Math.abs(b-x)));
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ret.add(temp[i]);
        }
        Collections.sort(ret);
        return ret;
    }
//    public int binary(int[] arr, int target){
//        int left = 0, right = arr.length;
//        while(left < right){
//            int mid = left + (right - left) / 2;
//            if(arr[mid] == target){
//                right = mid;
//            }
//            else if(arr[mid] > target){
//                right = mid - 1;
//            }
//            else{
//                left = mid + 1;
//            }
//
//        }
//    }
}
