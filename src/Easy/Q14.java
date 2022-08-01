package Easy;

public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        int ret = 0;
        StringBuilder sb = new StringBuilder();
        if(strs[0].length() == 0){
            return sb.toString();
        }
        for(int i = 0; i < strs[0].length() ; i++) {
            char pre = strs[0].charAt(i);
            for (String str : strs) {
                if(i >= str.length()){
                    return sb.toString();
                }
                if(str.charAt(i) == pre){

                }
                else{
                    return sb.toString();
                }
            }
            sb.append(pre);
        }
        return sb.toString();
    }
}
