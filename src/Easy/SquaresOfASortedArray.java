package Easy;
/*
* 双指针 头尾指针 比较大小即可
* */
import java.util.HashMap;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int temp[] = new int[length];
        int res[] =new int[length];
        int forwardIndex = 0;
        int tailIndex = length-1;
        for(int i=0;forwardIndex<=tailIndex;i++){
            int num1 = Math.abs(A[forwardIndex]);
            int num2 = Math.abs(A[tailIndex]);

            if(num1>=num2){
                temp[i]= num1*num1;
                forwardIndex++;
            }
            else if(num2>num1){
                temp[i]=num2*num2;
                tailIndex--;
            }
        }
        for(int i=0,j=length-1;i<temp.length;i++,j--){
            res[i]=temp[j];
        }
        return res;
    }
}
