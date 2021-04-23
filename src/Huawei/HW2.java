package Huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
*  字符串函数  
*
* */
public class HW2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = sc.next().charAt(0);
        int res = 0;
        char cc = 0;
        if(Character.isLowerCase(c)){
            cc = Character.toUpperCase(c);
        }
        else{
            cc = Character.toLowerCase(c);
        }
        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == c || s.charAt(i) == cc){
                res++;
            }
        }
        System.out.println(res);
    }
}
