package Huawei;

import java.util.Scanner;

public class HW4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.length() == 8){
                System.out.println(s);
                continue;
            }
            int need = 8 - s.length() % 8;
            for(int i = 1; i < s.length()+1; i++){
                System.out.print(s.charAt(i-1));
                if(i % 8 == 0)
                    System.out.println();
            }
            if(need < 8){
                for(int i = 0; i < need; i++){
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
