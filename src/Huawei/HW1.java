package Huawei;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String last = null;
        while (in.hasNext()) { // 注意 while 处理多个 case
            last = in.next();
        }
        System.out.println(last.length());
    }
}
