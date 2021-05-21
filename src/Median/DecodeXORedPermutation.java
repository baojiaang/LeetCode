package Median;

public class DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int odd = 0;
        for(int i = 1; i < encoded.length; i += 2){
            odd ^= encoded[i];
        }
        int total = 0;
        for(int i = 1; i <= encoded.length+1; i++){
            total ^= i;
        }
        int[] res = new int[encoded.length+1];
        res[0] = total ^ odd;
        for(int i = 0; i < encoded.length; i++){
            res[i+1] = encoded[i] ^ res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] encoded = {3,1};
        DecodeXORedPermutation d = new DecodeXORedPermutation();
        d.decode(encoded);

    }
}
