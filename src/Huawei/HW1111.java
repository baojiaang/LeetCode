package Huawei;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW1111 {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
        maxPQ.add(3);
        maxPQ.add(2);
        System.out.println(maxPQ.toArray()[0]);
        System.out.println(maxPQ.toArray()[1]);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res = new int[24];
        int[] can = new int[24];
        Arrays.fill(can,m);
        for(int i = 0; i < n;i++){
            int a = sc.nextInt();
            int l = sc.nextInt();
            int c = sc.nextInt();
            boolean flag = true;
            for(int start = a; start < l; start++){
                if(can[start] - c < 0){
                   flag = false;
                   break;
                }
            }
            for(int start = a; start < l && flag; start++){
                if(can[start] - c >= 0){
                    res[start] += c;
                    can[start] -= c;
                }
                else{
                    break;
                }
            }

        }
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
