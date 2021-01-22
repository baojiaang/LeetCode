package Easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        if(s.length()<3)
            return result;
        char first = s.charAt(0);
        int length = 1;
        int pos = 0;
        boolean needPut = false;
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c==first){
                length++;
                if(length>=3){
                    needPut = true;
                }
            }
            else{
                if(needPut){
                    ArrayList<Integer> a= new ArrayList<>();
                    a.add(pos);
                    a.add(pos+length-1);
                    result.add(a);
                    needPut = false;
                }
                first = c;
                length = 1;
                pos = i;
            }
        }
        if(needPut){
            ArrayList<Integer> a= new ArrayList<>();
            a.add(pos);
            a.add(pos+length-1);
            result.add(a);
        }
        return result;
    }
}
