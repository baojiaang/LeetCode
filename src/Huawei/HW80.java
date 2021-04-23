package Huawei;
import java.util.*;
public class HW80 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int num = sc.nextInt();
                if(!set.contains(num)){

                    l1.add(num);
                    set.add(num);
                }
            }
            n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int num = sc.nextInt();
                if(!set.contains(num)){
                    l2.add(num);
                    set.add(num);
                }
            }
            Collections.sort(l1);
            Collections.sort(l2);
            int i1 = 0, i2 = 0;
            StringBuffer sb = new StringBuffer();
            for(; i1 < l1.size() && i2 <l2.size();){
                int num = l1.get(i1) < l2.get(i2) ? l1.get(i1++) : l2.get(i2++);
                sb.append(num);
            }
            for(;i1 < l1.size();){
                sb.append(l1.get(i1++));
            }
            for(;i2 < l2.size();){
                sb.append(l2.get(i2++));
            }
            System.out.println(sb.toString());
        }

    }
}