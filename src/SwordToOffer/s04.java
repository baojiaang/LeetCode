package SwordToOffer;
/*
* 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 思路：二分查找
* */
public class s04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(matrix[i].length==0)
                return false;
            if(matrix[i][0]<=target&&matrix[i][matrix[i].length-1]>=target){
                if(find(matrix[i],target,0,matrix[i].length-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(int[] nums,int target,int low,int high){
        int mid = low+(high-low)/2;
        if(low<=high){
            if (nums[mid] == target)
                return true;
            else if(nums[mid]>target)
                return find(nums,target,low,mid-1);
            else if(nums[mid]<target)
                return find(nums,target,mid+1,high);
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums={-1,3};
        s04 s =new s04();
        System.out.println(s.find(nums,3,0,nums.length-1));
    }
}
