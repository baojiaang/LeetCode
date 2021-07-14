package Median;

import java.util.Arrays;
import java.util.TreeSet;

public class MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] abs_diff = new int[n];
        TreeSet<Integer> t = new TreeSet<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            abs_diff[i] = Math.abs(nums1[i] - nums2[i]);
            res = (res + abs_diff[i]) % 1000000007;
            t.add(nums1[i]);
        }

        int reduce = 0;

        for (int i = 0; i < abs_diff.length; i++) {
            if (abs_diff[i] == 0)
                continue;
            int need = nums2[i];
            int c = Integer.MAX_VALUE;
            int f = Integer.MAX_VALUE;
            Integer ceiling = t.ceiling(need);
            Integer floor = t.floor(need);
            if(ceiling != null)
                c = Math.abs(ceiling - nums2[i]);
            if(floor != null)
                f = Math.abs(floor - nums2[i]);
            reduce = Math.max(reduce, Math.max(abs_diff[i] - c, abs_diff[i] - f));
        }
        return (res - reduce + 1000000007) % 1000000007;
    }

    public static void main(String[] args) {
        int[] nums1 = {38, 48, 73, 55, 25, 47, 45, 62, 15, 34, 51, 20, 76, 78, 38, 91, 69, 69, 73, 38, 74, 75, 86, 63, 73, 12, 100, 59, 29, 28, 94, 43, 100, 2, 53, 31, 73, 82, 70, 94, 2, 38, 50, 67, 8, 40, 88, 87, 62, 90, 86, 33, 86, 26, 84, 52, 63, 80, 56, 56, 56, 47, 12, 50, 12, 59, 52, 7, 40, 16, 53, 61, 76, 22, 87, 75, 14, 63, 96, 56, 65, 16, 70, 83, 51, 44, 13, 14, 80, 28, 82, 2, 5, 57, 77, 64, 58, 85, 33, 24};
        int[] nums2 = {90, 62, 8, 56, 33, 22, 9, 58, 29, 88, 10, 66, 48, 79, 44, 50, 71, 2, 3, 100, 88, 16, 24, 28, 50, 41, 65, 59, 83, 79, 80, 91, 1, 62, 13, 37, 86, 53, 43, 49, 17, 82, 27, 17, 10, 89, 40, 82, 41, 2, 48, 98, 16, 43, 62, 33, 72, 35, 10, 24, 80, 29, 49, 5, 14, 38, 30, 48, 93, 86, 62, 23, 17, 39, 40, 96, 10, 75, 6, 38, 1, 5, 54, 91, 29, 36, 62, 73, 51, 92, 89, 88, 74, 91, 87, 34, 49, 56, 33, 67};
        MinimumAbsoluteSumDifference m = new MinimumAbsoluteSumDifference();
        System.out.println(m.minAbsoluteSumDiff(nums1, nums2));
    }
}
