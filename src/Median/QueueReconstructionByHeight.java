package Median;
import java.util.*;
/*Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* 根据height作为主排序列，同height比较k，k小的越大
* 然后从高到低插入
* */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o2[0] - o1[0];
                else
                    return -(o2[1]-o1[1]);
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int []person:people){
            System.out.println(person[1]);
            ans.add(person[1],person);   // person[1] 是索引
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
