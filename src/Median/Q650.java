package Median;

import java.util.Arrays;

public class Q650 {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q650 q = new Q650();
        System.out.println(q.minSteps(1));
    }
}
