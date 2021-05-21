package Median;
/*
* 前缀异或和
*
* 从 0 到 n+1 开数组
*
* prefix【i+1】 = prefix【i】 ^ arr【i】
* 
* */
public class CountTripletsThatCanFormTwoArraysofEqualXOR {
    public int countTriplets(int[] arr) {
        int[] prefix = new int[arr.length+1];
        for(int i = 0; i < arr.length; i++){
            prefix[i+1] = prefix[i] ^ arr[i];
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
                for(int k = i+1; k < arr.length; k++){
                    if(prefix[i] == prefix[k+1])
                        ans += k - i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,6,7};
        CountTripletsThatCanFormTwoArraysofEqualXOR c= new CountTripletsThatCanFormTwoArraysofEqualXOR();
        System.out.println(c.countTriplets(arr));
    }
}
