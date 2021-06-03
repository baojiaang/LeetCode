package Huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Honar2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weight = new int[]{1,3,7,11,13};
        int[] has = new int[5];
        for(int i = 0; i < 5; i++){
            has[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] dp = new int[target+1];
        Arrays.fill(dp,target+1);
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0; i <= target; i++){
            HashMap<Integer,Integer> temp =  new HashMap<>();
            for(int j = 0; j < 5; j++){
                temp.put(weight[j],has[j]);
            }
            map.put(i,temp);
        }
        dp[0] = 0;
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < weight.length; j++){
                if(weight[j] <= i){
                    HashMap<Integer,Integer> temp = map.get(i);
                    int remain = temp.get(weight[j]);
                    if(remain > 0){
                        dp[i] = Math.min(dp[i],dp[i-weight[j]]+1);
                        remain--;
                        temp.put(weight[j],remain);
                        map.put(i,temp);
                    }
                }
            }
        }
        System.out.println(dp[target]);
    }

}
