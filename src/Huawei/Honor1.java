package Huawei;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Honor1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        String[] tail = new String[]{"B","KB","MB","GB"};
        int i = 0;
        for(;i < tail.length && n >= 1024; i++){
            n /= 1024;
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(n)+tail[i]);
    }
}
