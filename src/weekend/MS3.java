package weekend;
import java.util.*;
public class MS3 {

    public boolean solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            int num = A[i];
            if(map.containsKey(num)){
                int val = map.get(num);
                val++;
                map.put(num,val);
            }
            else{
                map.put(num,1);
            }
        }
        for (Map.Entry<Integer,Integer> e: map.entrySet()
             ) {
            int key = e.getKey();
            int val = e.getValue();
            if((val%2) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MS3 m = new MS3();
        int A[]  = {7,7,7};
        System.out.println(m.solution(A));
    }
}
