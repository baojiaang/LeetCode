package Median;

public class Q678 {
    public boolean checkValidString(String s) {
        int left = 0, right = 0, star = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }
            else if(c == ')'){
                if(left > 0){
                    left--;
                }
                else if(star > 0){
                    star--;
                }
                else{
                    return false;
                }
            }
            else{
                star++;
            }
        }
        left = 0;
        right = 0;
        star = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ')'){
                right++;
            }
            else if(c == '('){
                if(right > 0){
                    right--;
                }
                else if(star > 0){
                    star--;
                }
                else{
                    return false;
                }
            }
            else{
                star++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q678 q = new Q678();
        System.out.println(q.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }
}
