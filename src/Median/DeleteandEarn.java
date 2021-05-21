package Median;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteandEarn {
//    int max = 0;
//    HashMap<Integer,Integer> map = new HashMap<>();
//    public int deleteAndEarn(int[] nums) {
//
//        int len = 0;
//        for(int num : nums){
//            if(map.containsKey(num)){
//                int v = map.get(num);
//                map.put(num,v+1);
//            }
//            else{
//                map.put(num,1);
//                len++;
//            }
//        }
//        int[] nums1 = new int[len];
//        int i = 0;
//        for (Map.Entry<Integer,Integer> e:map.entrySet()
//             ) {
//            nums1[i++] = e.getKey();
//        }
//        Arrays.sort(nums1);
//        back_track(nums1,0,0);
//        return max;
//    }
//    public void back_track(int[] nums1, int start,int temp){
//        while(start < nums1.length){
//            //要
//            temp += nums1[start] * map.get(nums1[start]);
//            max = Math.max(max,temp);
//            if(start + 1 < nums1.length){
//                if(nums1[start+1] != nums1[start]+1){
//                    back_track(nums1,start+1,temp);
//                }
//                else{
//                    back_track(nums1,start+2,temp);
//                }
//            }
//            temp -= nums1[start] * map.get(nums1[start]);
//            //不要
//            back_track(nums1,start+1,temp);
//            start++;
//        }
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }
    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    public static void main(String[] args) {
        DeleteandEarn d = new DeleteandEarn();
        int[] nums = { 2,3,4};
        System.out.println(d.deleteAndEarn(nums));
    }
}
