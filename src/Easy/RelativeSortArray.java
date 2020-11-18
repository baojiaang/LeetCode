package Easy;
/*
* Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* 可用计数排序做
* */
import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int length1 = arr1.length;
        int length2 = arr2.length;
        int result[] = new int[length1];

        for(int i=0;i<length1;i++){
            int num = arr1[i];
            if(map1.containsKey(num)){
                int times = map1.get(num);
                map1.put(num,times+1);
            }
            else {
                map1.put(num,1);
            }
        }
        int index = 0;
        for(int i=0;i<length2;i++){
            int num = arr2[i];
            int times = 0;
            if(map1.containsKey(num)) {
                times = map1.get(num);
                for (int j = 0; j < times; j++) {
                    result[index] = num;
                    index++;
                }
                map1.remove(num);
            }
        }


        ArrayList<Integer> temp = new ArrayList<>();

        for(Integer num:map1.keySet()){
            int times = map1.get(num);
            for(int i=0;i<times;i++){
                temp.add(num);
            }
        }
        temp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(temp);
        for(int i=index,j=0;i<temp.size();i++,j++){
            result[i] = temp.get(j);
            System.out.println(result[i]);
        }
        return result;
    }
}
