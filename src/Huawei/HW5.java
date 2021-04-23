package Huawei;

import java.util.Scanner;

public class HW5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            int num = Integer.parseInt(s.substring(2,s.length()),16);
            System.out.println(num);
        }
    }
}
    