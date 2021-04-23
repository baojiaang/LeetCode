package weekend;

import java.util.LinkedList;

public class MS4 {
    public String solution(String S) {
        // write your code in Java SE 8
        int len = S.length();
        int mid1 = 0, mid2 = 0;
        if(len % 2 == 0){
            mid1 = len / 2 - 1;
            mid2 = len / 2;
        }
        else{
            mid1 = len / 2;
            mid2 = len / 2;
        }
        StringBuffer sb = new StringBuffer();
        LinkedList<Character> l = new LinkedList<>();
        for(;mid1 >= 0 && mid2 < len; mid1--, mid2++){
            if(mid1 == mid2){
                if(S.charAt(mid1) == '?')
                    l.addLast('a');
                else{
                    l.addLast(S.charAt(mid1));
                }
                continue;
            }
            if(S.charAt(mid1) == '?' && S.charAt(mid2) == '?'){
                l.addLast('a');
                l.addFirst('a');
            }
            if(S.charAt(mid1) == '?' && S.charAt(mid2) != '?'){
                l.addFirst(S.charAt(mid2));
                l.addLast(S.charAt(mid2));
            }
            if(S.charAt(mid1) != '?' && S.charAt(mid2) == '?'){
                l.addFirst(S.charAt(mid1));
                l.addLast(S.charAt(mid1));
            }
            if(S.charAt(mid1) != '?' && S.charAt(mid2) != '?'){
                if(S.charAt(mid1) != S.charAt(mid2))
                    return "NO";
                l.addFirst(S.charAt(mid1));
                l.addLast(S.charAt(mid1));
            }
        }
        for(int i = 0; i < l.size();i++){
            sb.append(l.get(i));
        }
        return sb.toString();
    }
}
