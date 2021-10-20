package Median;

import java.util.Arrays;

public class Q881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int left = 0, right = people.length - 1;
        while(left <= right){
            if(left == right){
                res++;
                return res;
            }
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            res++;
        }
        return res;
    }
}
