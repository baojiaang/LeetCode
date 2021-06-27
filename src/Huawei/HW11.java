package Huawei;

import java.util.Scanner;
import java.util.Stack;

public class HW11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String [] arr = line.split("\\s+");
            boolean flag = true;
            Stack<String> s = new Stack<>();
            for(int i = 0; i < arr.length && flag; i++){
                if(arr[i].length() == 1){
                    char c = arr[i].charAt(0);
                    if(!Character.isLowerCase(c)){
                        flag = false;
                        break;
                    }
                    if(s.empty() || s.peek().length() > 1) {
                        s.push(arr[i]);
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                // 判断大写
                else{
                    for(int j = 0; j < arr[i].length(); j++){
                        char c = arr[i].charAt(j);
                        if(!Character.isUpperCase(c)){
                            flag = false;
                            break;
                        }
                    }

                    // 判断开头
                    if (i == 0){
                        if(!arr[i].equals("NOT")){
                            flag = false;
                            break;
                        }
                    }
                    if(arr[i].equals("AND") || arr[i].equals("OR")){
                        if(s.peek().length() != 1){
                            flag = false;
                            break;
                        }
                    }
                    if(arr[i].equals("NOT")){
                        if(s.peek().equals("NOT")){
                            flag = false;
                            break;
                        }
                    }
                    s.push(arr[i]);
                }
            }
            if(flag)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
