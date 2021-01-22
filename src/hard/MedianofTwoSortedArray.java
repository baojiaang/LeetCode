package hard;
/*
* 思路：划分数组法，用二分查找寻找划分线
* */
public class MedianofTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        //  nums1分割线左侧小于nums2分割线右侧，nums1分割线右侧大于nums2分割线左侧
        // 在nums1区间  【0，m】内找到正确的分割线
        // 使得 nums1[i-1]<=nums2[j] && nums2[j-1] <= nums1[i]
        int totalLeft = (m+n+1)/2;
        while (left < right) {
            int i = (left + right) / 2; //nums1分割线
            int j = totalLeft - i;   //nums2分割线
            if(nums1[i-1]>nums2[j]){
                right = i - 1;
            }else{
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMax = i == m ? Integer.MAX_VALUE:nums1[i];  // 应对m+n长度为偶数情况
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE:nums2[i-1];
        int nums2RightMax = j == m ? Integer.MAX_VALUE:nums2[j-1];

        if(((m+n)%2)==1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        }else{
            return (double) (Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums1RightMax,nums2RightMax))/2;
        }

    }
}
