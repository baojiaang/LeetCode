package hard;
/*
* With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
word contains the first letter of puzzle.
For each letter in word, that letter is in puzzle.
For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage"; while invalid words are "beefed" (doesn't include "a") and "based" (includes "s" which isn't in the puzzle).
Return an array answer, where answer[i] is the number of words in the given word list words that are valid with respect to the puzzle puzzles[i].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* 二进制状态压缩 （不太懂）
* */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberofValidWordsforEachPuzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;

            // 枚举子集方法一
            // for (int choose = 0; choose < (1 << 6); ++choose) {
            //     int mask = 0;
            //     for (int i = 0; i < 6; ++i) {
            //         if ((choose & (1 << i)) != 0) {
            //             mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
            //         }
            //     }
            //     mask |= (1 << (puzzle.charAt(0) - 'a'));
            //     if (frequency.containsKey(mask)) {
            //         total += frequency.get(mask);
            //     }
            // }

            // 枚举子集方法二
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            ans.add(total);
        }
        return ans;
    }
}
