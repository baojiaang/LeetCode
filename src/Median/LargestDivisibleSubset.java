package Median;
import java.util.*;
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        ArrayList<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        map.put(nums[0],first);
        for(int i = 1; i < nums.length; i++){
            List<Integer> pre = null;
            for(int j = i-1; j >= 0 ; j-- ){
                if(nums[i] % nums[j] == 0){
                    if(map.containsKey(nums[j])){
                        if(pre == null){
                            pre = map.get(nums[j]);
                        }
                        else{
                            if(map.get(nums[j]).size() > pre.size()){
                                pre = map.get(nums[j]);
                            }
                        }
                    }
                    else{
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[j]);
                        temp.add(nums[i]);
                        map.put(nums[i], temp);
                    }
                }
                if(pre != null){
                    ArrayList<Integer> temp = new ArrayList<>(pre);
                    temp.add(nums[i]);
                    map.put(nums[i],temp);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() > res.size()){
                res = entry.getValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset l = new LargestDivisibleSubset();
        int[] nums= {1,2,3};
        System.out.println(l.largestDivisibleSubset(nums));
    }
}
