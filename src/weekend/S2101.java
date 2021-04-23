package weekend;

public class S2101 {
    public int storeWater(int[] bucket, int[] vat) {
        int res = 0;
        for(int i = 0; i < bucket.length; i++){

            for(;bucket[i]  < vat[i] / 2;){
                bucket[i]++;
                res++;
            }
        }
        res += 2;
        return res;
    }
}
