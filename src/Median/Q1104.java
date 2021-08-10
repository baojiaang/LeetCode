package Median;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int cur = label;
        res.add(cur);
        cur /= 2;
        while(cur >= 1){
            int[] interval_cur = find_interval(cur);
            boolean flag = true;
            cur = get_num(cur,interval_cur[0],interval_cur[1],flag);
            res.add(cur);
            cur /= 2;
        }
        Collections.reverse(res);
        return res;
    }

    public int[] find_interval(int n){
        int a = 0,b = 0;
        while(n / 2 > 0){
            n /= 2;
            a++;
        }
        b = a+1;
        return new int[]{a,b};
    }

    public int get_num(int n, int a, int b,boolean flag){
        int index = (int) (n - Math.pow(2,a));
        if(flag == true){
            index =  (int) (Math.pow(2,b) - Math.pow(2,a) - index - 1);
        }
        return (int)(Math.pow(2,a) + index);
    }

    public static void main(String[] args) {
        Q1104 q = new Q1104();
        System.out.println(q.pathInZigZagTree(14));
    }

}
