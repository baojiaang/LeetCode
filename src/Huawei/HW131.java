package Huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW131 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] nums = new int[m];
        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
        int res = 0;
        PriorityQueue MaxPQ = new PriorityQueue<>();
        if(m == 1){
            System.out.println(0);
            return;
        }
        if(m >= 2){
            res += Math.min(nums[0],nums[1]);
            list.add(nums[0]);
            list.add(nums[1]);
        }
        int count = 0;
        for(int i = 3; i <= m ; i++){
            list.add(nums[i-1]);
            boolean flag = true;
            for (int j=2;j<=(int)Math.sqrt(i);j++){
                if (i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count++;
                Collections.sort(list);
                res += list.get(count);
            }
        }
        System.out.println(res);
    }
}
