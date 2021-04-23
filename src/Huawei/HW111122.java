package Huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.util.*;

public class HW111122{
    static int N = 100010;
    static int n, m = 0;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] r = new int[N];
    static int[] c = new int[N];
    static int[] q = new int[N];
    static int idx = 0;
    static int res = 10;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        for(int i=0; i<N; i++){
            h[i] = -1;
        }

        for(int i=0; i<m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            add(a, b);
            c[a] ++;
            r[b] ++;
        }
        for(int i = 0; i < n; i ++){
            if(r[i] == 0 && c[i] == 0) res --;
        }
        if(!topsort()) res -= 2;
        System.out.println(res);
    }


    public static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static boolean topsort(){

        int hh = 0;
        int tt = -1;


        for(int i=1; i<=n; i++){
            if(r[i] == 0 && c[i] > 0){
                q[++tt] = i;
            }
        }

        while(hh <= tt){
            int t = q[hh++];
            for(int i=h[t]; i!=-1; i=ne[i]){
                int j = e[i];
                r[j]--;
                if(r[j] == 0){
                    q[++tt] = j;
                }
            }
        }

        return tt == n - 1;
    }
}