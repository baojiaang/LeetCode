package Median;
/*
* Given an integer array bloomDay, an integer m and an integer k.

We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 二分法
*
* */
public class MinimumNumberofDaystoMakemBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if( m * k > bloomDay.length){
            return -1;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int day : bloomDay){
            max = Math.max(day,max);
            min = Math.min(day,min);
        }
        int low = min, high = max;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(check(bloomDay,m,k,mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean check(int[] bloomDay, int m, int k,int day){
        int flowers = 0;
        int bouquets = 0;
        for(int i = 0; i < bloomDay.length && bouquets < m; i++){
            if(bloomDay[i] <= day){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            }
            else{
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {
        int[] nums = {1,10,3,10,2};
        MinimumNumberofDaystoMakemBouquets m = new MinimumNumberofDaystoMakemBouquets();
        System.out.println(m.minDays(nums,3,1));
    }
}
