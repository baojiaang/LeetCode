package Huawei;
import java.util.*;
public class HW3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while(sc.hasNextInt()){
            int line = sc.nextInt();
            for(int i = 0; i < line; i++){
                int num = sc.nextInt();
                set.add(num);
            }
            for(int n : set){
                System.out.println(n);
            }
            set.clear();
        }
    }
}
