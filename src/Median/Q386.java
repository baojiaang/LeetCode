package Median;

import java.util.ArrayList;
import java.util.List;

public class Q386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Q386 q = new Q386();
        System.out.println(q.lexicalOrder(300));
    }
}
