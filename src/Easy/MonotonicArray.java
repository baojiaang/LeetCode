package Easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int flag = 0 ;
        if(A.length == 1)
            return true;
        for(int i = 1; i < A.length; i++){
            if(flag == 0){
                if(A[i] > A[i-1])
                    flag = 1;
                else if(A[i] < A[i-1])
                    flag = -1;
            }
            if(flag == 1){
                if(A[i] < A[i-1])
                    return false;
            }
            if(flag == -1){
                if(A[i] > A[i-1])
                    return false;
            }
        }
        return true;
    }
}
