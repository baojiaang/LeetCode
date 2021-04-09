package Easy;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            int mask = 1 << i;
            if( (n & mask) != 0) {
                result += 1 << (32 - i - 1);
            }
        }
        return result;
    }
}
