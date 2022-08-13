package hard;

import java.util.Arrays;

public class Q899 {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            String ret = s;
            StringBuilder sb = new StringBuilder();
            sb.append(ret);
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                sb.deleteCharAt(0);
                sb.append(c);
                if(ret.compareTo(sb.toString()) > 0){
                    ret = sb.toString();
                }
            }
            return ret;
        }
        else{
            char[] array = s.toCharArray();
            Arrays.sort(array);
            return new String(array);
        }
    }
}
