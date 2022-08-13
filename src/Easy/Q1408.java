package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1408 {
    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<String>();
        Arrays.sort(words,(String a, String b) -> a.length() - b.length() );
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(words[j].contains(words[i])){
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;
    }
}
