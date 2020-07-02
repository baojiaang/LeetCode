package Easy;
/**
 * Solution: Compare each string's character,
 * for example: strs[0].charAt(0) strs[1].charAt(0)
 * strs[1].charAt(1) strs[1].charAt(1)
 *
 * Time complexity: O(m*n)
 *
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length=strs.length;
        StringBuilder stringBuilder=new StringBuilder();
        if(length==0)
            return "";
        else if(length==1)
            return strs[0];
        else{
            String firstWord=strs[0];
            for(int i=0;i<firstWord.length();i++){
                char c=firstWord.charAt(i);
                boolean flag=true;
                for(int j=0;j<length;j++){
                    int curLength=strs[j].length();
                    if(curLength-1<i){
                        flag=false;
                        break;
                    }
                    char cur=strs[j].charAt(i);
                    if(c!=cur) {
                        flag=false;
                        break;
                    }
                }
                if(i==0){
                    if(flag)
                        stringBuilder.append(c);
                }
                else{
                    if(stringBuilder.toString().length()!=0)
                        if(flag)
                        stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String strs[]={"aca","cba"};
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();
        String s=longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(s.length());
    }
}
