package Easy;

import java.util.HashSet;

public class Q804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] moore = {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(String str : words){
            StringBuilder sb = new StringBuilder();
            for(char c: str.toCharArray()){
                sb.append(moore[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
