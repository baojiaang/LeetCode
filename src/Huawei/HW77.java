package Huawei;
/*
* 回溯
*
* */
import java.util.*;
public class HW77 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        back_trace(nums,0,"",res,new Stack<Integer>(),0);
        Collections.sort(res);
        for(String s:res){
            System.out.println(s);
        }

    }
    public static void back_trace(int[] nums, int start, String str,List<String> res,Stack<Integer> s, int out){
        if(out == nums.length){
            res.add(str);
        }
        if(start < nums.length){
            s.push(nums[start]);
            back_trace(nums,start+1,str,res,s,out);
            s.pop();
        }
        if(!s.empty()){
            int n = s.pop();
            back_trace(nums,start,str+n+" ",res,s,out+1);
            s.push(n);
        }

    }
}