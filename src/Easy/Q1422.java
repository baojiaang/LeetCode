package Easy;

public class Q1422 {
    public int maxScore(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        for(char c: s.toCharArray()){
            int num = c - '0';
            if(num == 0){
                zeroCount++;
            }
            else{
                oneCount++;
            }
        }
        int ret = 0;
        int left = 0;
        int right = oneCount;
        for(int i = 0; i < s.length() - 1; i++){
            char c = s.charAt(i);
            int num = c - '0';
            if(num == 0){
                left++;
            }
            else{
                right--;
            }
            int temp = left + right;
            ret = Math.max(ret, temp);
        }
        return ret;
    }
}
