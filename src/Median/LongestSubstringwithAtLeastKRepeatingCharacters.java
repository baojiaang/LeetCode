package Median;
/*
* Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 滑动窗口
*
* 维护最长字串内的字符种类个数，最小为1，最大26
* 给定字符种类t，维护左右窗口l，r   total>t 时 l++
* */
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];  // 枚举字符的所有种类，限定在t个字符内，进行滑动窗口
            int tot = 0;
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
