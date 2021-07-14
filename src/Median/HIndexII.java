package Median;

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 1)
            return Math.min(1,citations[0]);
        int left = 0, right = citations.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(citations[mid] > (n - mid)){
                right = mid;
            }
            else if (citations[mid] < (n-mid)){
                left = mid + 1;
            }
            else{
                return citations[mid];
            }
        }
        return Math.min(citations[left],n-left);
    }

    public static void main(String[] args) {
        HIndexII h = new HIndexII();
        int[] nums = {1,4,7,9};
        System.out.println(h.hIndex(nums));
    }
}
