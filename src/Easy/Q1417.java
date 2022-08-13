package Easy;

import java.util.ArrayList;
import java.util.List;

public class Q1417 {
    public String reformat(String s) {
        List<Character> cList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                numList.add(c-'0');
            }
            else{
                cList.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(Math.abs(cList.size() - numList.size()) > 1){
            return sb.toString();
        }
        if(cList.size() > numList.size()) {
            for (int i = 0; i < cList.size(); i++) {
                sb.append(cList.get(i));
                if (i < numList.size()) {
                    sb.append(numList.get(i));
                }
            }
        }
        else{
            for (int i = 0; i < numList.size(); i++) {
                sb.append(numList.get(i));
                if (i < cList.size()) {
                    sb.append(cList.get(i));
                }
            }
        }
        String ret = sb.toString();
        return ret;
    }
}
