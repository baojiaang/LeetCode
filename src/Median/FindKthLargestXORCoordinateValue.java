package Median;

public class FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        //int[][] prefix = new int[matrix.length+1][matrix[0].length+1];
        int[] prefix = new int[(matrix.length) * (matrix[0].length)];
        int[][] pre = new int[matrix.length + 1][matrix[0].length + 1];
        int count = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                prefix[count] = pre[i][j];
                count++;
            }
        }
        return findKth(prefix,k);
    }

    public int findKth(int[] nums, int k) {
        return findKth(nums,0,nums.length-1,k);
    }

    public int findKth(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);

        if(pivot + 1 > k)
            return findKth(nums,low,pivot-1,k);
        if(pivot + 1 < k){
            return findKth(nums,pivot+1,high,k);
        }
        else{
            return nums[pivot];
        }


    }
    public int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        while(low < high){
            while(low < high && nums[high] <= pivot){
                high--;
            }
            nums[low] = nums[high];

            while(low < high && nums[low] >= pivot){
                low++;
            }
            nums[high] = nums[low];

        }
        nums[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[][] a= {{5,2},{1,6}};
        FindKthLargestXORCoordinateValue f = new FindKthLargestXORCoordinateValue();
        System.out.println(f.kthLargestValue(a,2));
//        System.out.println(f.findKth(nums,5));
    }
}
