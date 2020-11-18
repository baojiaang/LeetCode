package Easy;
//Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
//
//        Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
//
//        You may return any answer array that satisfies this condition.
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
import java.util.ArrayList;
public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] A) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(A[i]%2 == 0){
                even.add(A[i]);
            }
            else {
                odd.add(A[i]);
            }
        }
        for(int i = 0,j=0;i<even.size();i++){
            A[j] = even.get(i);
            j++;
            A[j] = odd.get(i);
            j++;
        }
        return A;
    }
}
