package Easy;

public class Q541 {
    public String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer(s);
        for(int i = 0; i < s.length();){
            if(i + 2 * k < s.length()){
                String re = reverse(s.substring(i,i+k));
                System.out.println(re);
                sb.replace(i,i+k,re);
                i += 2 * k;
            }
            else if ( i + 2 * k >= s.length() && i + k < s.length()){
                String re = reverse(s.substring(i, i+k));
                sb.replace(i,i+k,re);
                return sb.toString();
            }
            else if( i + k >= s.length()){
                String re = reverse(s.substring(i,s.length()));
                System.out.println(re);
                sb.replace(i,s.length(),re);
                return sb.toString();
            }
        }
        return sb.toString();
    }
    public String reverse(String s){
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        Q541 q = new Q541();
        System.out.println(q.reverseStr(s,4));
    }
}
