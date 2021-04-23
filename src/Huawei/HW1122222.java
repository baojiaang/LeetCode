package Huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class HW1122222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] cost = new int[K];
        for(int i = 0; i < K; i++){
            cost[i] = sc.nextInt();
        }
        int N = sc.nextInt();
        int E = sc.nextInt();

        for(int i = 0; i < N; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            Node n = new Node(parent);
            n.add(child);
        }
        System.out.println(111);
    }
    static class Node{
        ArrayList<Integer> child = new ArrayList<>();
        int id;
        public Node(int id){
            this.id = id;
        }
        public void add(int n){
            child.add(n);
        }

    }
}
