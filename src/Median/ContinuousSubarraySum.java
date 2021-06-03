package Median;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        // for empty case
        map.put(0, -1);
        int reminder = 0;
        for (int i = 0; i < nums.length; i++) {
            reminder = (reminder + nums[i]) % k;
            if (map.containsKey(reminder)) {
                int last = map.get(reminder);
                if (i - last >= 2) {
                    return true;
                }
            } else {
                map.put(reminder, i);
            }
        }
        return false;
    }
}
