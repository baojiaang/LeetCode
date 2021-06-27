package Huawei;

import java.util.Scanner;

public class HW12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int round = 0; round < m; round++){
            int len = sc.nextInt();
            int[] nums = new int[len];
//            String line = sc.nextLine();
//            StringBuilder sb = new StringBuilder(line);
//            System.out.println(line);
//            for(int i = 0; i < line.length(); i++){
//                if(i+1 < line.length()){
//                    if(line.charAt(i) == '0' && line.charAt(i+1) == '0'){
//                        sb.replace(i,i+1,"1");
//                    }
//                }
//                if(i+2 < line.length()){
//                    if(line.charAt(i) == '0' && line.charAt(i+1) == '1' && line.charAt(i+2) == '2'){
//                        sb.replace(i,i+1,"1");
//                        sb.replace(i+1,i+2,"0");
//                        sb.replace(i+2,i+3,"1");
//                    }
//                }
//            }
//            System.out.println(sb.toString());
            for(int i = 0; i < len; i++){
                nums[i] = sc.nextInt();
            }
            for(int i = 0; i < len; i++){
                if(i+1 < len){
                    if(nums[i] == 0 && nums[i+1] == 0){
                        nums[i] = 1;
                    }
                }
                if(i+2 < len){
                    if(nums[i] == 0 && nums[i+1] ==  1 && nums[i+2] == 2){
                        nums[i] = 1;
                        nums[i+1] = 0;
                        nums[i+2] = 1;
                    }
                }
            }
            for(int i = 0; i < len; i++){
                System.out.print(nums[i]);
            }
            System.out.println();
        }
    }
}
