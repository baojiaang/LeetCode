package Easy;

import java.util.LinkedList;
import java.util.List;

public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        int num = K;
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = length-1 ; i >=0 || num>0; num/= 10,i--){
            if( i>= 0){
                num+=A[i];
            }
            res.addFirst(num%10);
        }
        return res;
    }
}
