package Median;
/*
* Solution: use two pointer to optimize time complexity
* Why two pointer can help this? Because in second and third loop, two pointer second and third,
* the second will move from left to right, the third will move to right to left until two pointers meet,so this two loop only consume O(n) time
*
* We will sort the array first, which takes O(nlogn) time,
* then we need to use triple loop and use two pointers to optimize the second and third loop,
* we also need consider that we need use different triplets, which means if two adjacent number is same, in next iteration, we should ignore this same
* number in one loop
*
*
* */

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int first=0;first<n;first++){
            // ensure each triplet is different
            if(first>0&&nums[first]==nums[first-1]) {
                continue;
            }
            int third=n-1;
            int target=-nums[first];
            for(int second=first+1;second<n;second++){
                //ensure  each triplet is different
                if(second>first+1&&nums[second]==nums[second-1]) {
                    continue;
                }
            while(second<third&&nums[second]+nums[third]>target){
                third--;

            }
            if(second==third){
                break;
            }
            if(nums[second]+nums[third]==target){
                List<Integer> list=new ArrayList<>();
                list.add(nums[first]);
                list.add(nums[second]);
                list.add(nums[third]);
                ans.add(list);
            }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum=new ThreeSum();
        int nums[]={0,0,0,0,0,0,0,0};
        threeSum.threeSum(nums);
    }
}
