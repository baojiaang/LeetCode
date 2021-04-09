package SwordToOffer;

import java.util.Arrays;
import java.util.Comparator;
/*
*
* sort 重写comparator 可改为   （x，y） -> x.compareTo(y)
* */
public class LCOF45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];

        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));  // 按位的值一个个比较
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "10";
        String s2 = "5";
        String s = s1+s2;
        String ss = s2+s1;
        System.out.println(s);
        System.out.println(s2+s1);
        System.out.println(s.compareTo(ss));
    }
}
