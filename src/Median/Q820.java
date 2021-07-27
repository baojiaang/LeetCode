package Median;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q820 {
//    public int minimumLengthEncoding(String[] words) {
//        int res = 0;
//        int count = 0;
//        for(int i = 0; i < words.length; i++){
//            res += words[i].length();
//            count++;
//        }
//        boolean[] can_del = new boolean[words.length];
//        Arrays.sort(words,(String a, String b) -> b.length() - a.length());
//        for(int i = 0; i < words.length; i++){
//            if(can_del[i] == false) {
//                for (int j = i + 1; j < words.length; j++) {
//                    if (can_del[j] == false) {
//                        System.out.println(check(words[i],words[j]));
//                        if (check(words[i],words[j])) {
//                            can_del[j] = true;
//                        }
//                    }
//                }
//            }
//        }
//        for(int i = 0; i < can_del.length; i++){
//            if(can_del[i] == true){
//                res -= words[i].length();
//                count--;
//            }
//        }
//        return res + count;
//    }
//    public boolean check(String a, String b){
//    int i = a.length() - 1, j = b.length() - 1;
//        for(; i >= 0 && j >= 0; i--, j--){
//            System.out.println(a.charAt(i) + " "+ b.charAt(j));
//            if(a.charAt(i) == b.charAt(j)){
//
//            }
//            else{
//                return false;
//            }
//        }
//        return true;
//    }

    int res = 0;

    public int minimumLengthEncoding (String[]words){
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<TrieNode, Integer>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node : nodes.keySet()) {
            // 如果是尾节点
            if (node.count == 0) {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;

    }

}


class TrieNode {
    TrieNode[] children;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}