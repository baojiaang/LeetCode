package weekend;

public class MS1 {
    public String solution(String S, int K) {
        // write your code in Java SE 8
        int res = K % 7;
        int start = 0;
        if(S.equals("Mon")){
            start = 1;
        }
        if(S.equals("Tue")){
            start = 2;
        }
        if(S.equals("Wed")){
            start = 3;
        }
        if(S.equals("Thu")){
            start= 4;
        }
        if(S.equals("Fri")){
            start = 5;
        }
        if(S.equals("Sat")){
            start = 6;
        }
        if(S.equals("Sun")){
            start = 7;
        }
        res = (start + res) % 7;
        if(res == 0)
            return "Sun";
        if(res == 1)
            return "Mon";
        if(res == 2)
            return "Tue";
        if(res == 3)
            return "Wed";
        if(res == 4)
            return "Thu";
        if(res == 5)
            return "Fri";
        if(res == 6)
            return "Sat";
        return null;
    }

    public static void main(String[] args) {
        String s = "Sun";
        MS1 m = new MS1();
        System.out.println(m.solution(s,0));

    }
}
