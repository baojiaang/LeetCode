package Easy;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }
        for(;j<nums.length;j++){
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int a[] = {1,0,1};
        moveZeros.moveZeroes(a);
    }
}
