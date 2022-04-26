package Easy;

import java.util.ArrayList;

public class Q997 {
    public int findJudge(int n, int[][] trust) {
        boolean[] person = new boolean[n + 1];
        for(int i = 0; i < trust.length; i++){
            person[trust[i][0]] = true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < person.length; i++){
            if(person[i] == false){
                list.add(i);
            }
        }
        if(list.size() != 1){
            return -1;
        }
        int pIndex = list.get(0);
        person = new boolean[n + 1];
        for(int i = 0; i < trust.length; i++){
            if(trust[i][1] == pIndex) {
                person[trust[i][0]] = true;
            }
        }
        for(int i = 1; i < person.length; i++){
            if( i!= pIndex && person[i] == false){
                return -1;
            }
        }
        return pIndex;
    }
}
