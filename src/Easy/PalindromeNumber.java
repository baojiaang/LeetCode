package Easy;

public class PalindromeNumber {
    /*
    * Solution: compute the mod value and add result times 10, then compare whether the result is same to x
    *
    * */
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int temp=x;
        int result=0;
        for(;temp!=0;result=result*10+temp%10,temp/=10);
        if(result==x)
            return true;
        else
            return false;
    }
}
