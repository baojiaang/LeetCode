package Median;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                if (t2.getValue() != t1.getValue()) {
                    return t2.getValue().compareTo(t1.getValue());
                } else {
                    char[] achar = t1.getKey().toCharArray();
                    char[] bchar = t2.getKey().toCharArray();
                    int len = Math.min(achar.length, bchar.length);
                    for (int i = 0; i < len; i++) {
                        if (achar[i] - bchar[i] != 0)
                            return achar[i] - bchar[i];
                    }
                    return bchar.length - achar.length;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "i";
        String s2 = "love";
        
        System.out.println(s1.compareTo(s2));
    }
}
//class ValueComparator implements Comparator<String> {
//    private Map<String,Integer> base;
//
//    public ValueComparator(Map base) {
//        this.base = base;
//
//    }
//
//    @Override
//
//    public int compare(String a, String b) {
//        if (base.get(a) > base.get(b)) {
//            return 1;
//        }
//        if(base.get(a) == base.get(b)){
//            char[] achar = a.toCharArray();
//            char[] bchar = b.toCharArray();
//            int len = Math.min(achar.length,bchar.length);
//            for(int i = 0; i < len; i ++){
//                if(achar[i] - bchar[i] != 0)
//                    return achar[i] - bchar[i];
//            }
//        }
//            return -1;
//    }
//}
