package Easy;

public class Q942 {
    public int[] diStringMatch(String s) {
        int iIdx = 0, dIdx = s.length();
        int[] ret = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                ret[i] = iIdx++;
            }
            else{
                ret[i] = dIdx--;
            }
        }
        ret[s.length()] = iIdx;
        return ret;
    }
}
