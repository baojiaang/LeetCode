package Median;

public class HIndex {
    public int hIndex(int[] citations) {
        int max = 0;
        for(int cit : citations){
            max = Math.max(max,cit);
        }
        int[] count = new int[max+1];
        for(int cit : citations){
            count[cit]++;
        }
        int res = 0;
        if(citations.length == 1)
            return Math.min(citations[0],1);
        for(int i = count.length-1; i >=0; i--){
            if(i < count.length - 1)
                count[i] += count[i+1];
            res = Math.max(res,Math.min(count[i],i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        HIndex h = new HIndex();
        System.out.println(h.hIndex(nums));
    }
}
