package Easy;
/*
* Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* HashMap
*
* */
import java.util.HashMap;
import java.util.Map;

public class DegreeofAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer[]> numMap = new HashMap<>();
        int maxTimes = 0;
        int minLength = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(numMap.containsKey(num)){
                Integer[] store = numMap.get(num);
                store[0]++;
                store[2] = i;
                numMap.put(num,store);
            }
            else{
                Integer[] store = new Integer[3];
                store[0] = 1;
                store[1] = i;
                store[2] = i;
                numMap.put(num,store);
            }
        }
        for(Map.Entry<Integer,Integer[]> entry:numMap.entrySet()){
            Integer[] store = entry.getValue();
            int times = store[0];
            int start = store[1];
            int end = store[2];
            int length = end - start + 1;
            if(times > maxTimes){
                maxTimes = times;
                minLength = length;
            }
            else if(times == maxTimes){
                if(length < minLength){
                    minLength = length;
                }
            }
        }
        return minLength;
    }
}
