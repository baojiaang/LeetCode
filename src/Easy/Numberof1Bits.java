package Easy;

public class Numberof1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if( (n & 1 << i) != 0 )  // 对每位与运算，不等于0该位为位1
                count++;
        }
        return count;
    }
}
