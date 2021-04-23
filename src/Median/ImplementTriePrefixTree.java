package Median;

public class ImplementTriePrefixTree {

}
class Trie {
    Trie[] tries;
    boolean isEnd;
    /** Initialize your data structure here. */
    public Trie() {
        tries = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(node.tries[index] == null){
                node.tries[index] = new Trie();
            }
            node = node.tries[index];
        }
        node.isEnd = true; // 当前node
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = findTail(word);
        if(node != null && node.isEnd == true)
            return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findTail(prefix) == null ? false : true;
    }
    public Trie findTail(String prefix) {
        Trie node = this;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(node.tries[index] == null){
                return null;
            }
            node = node.tries[index];
        }
        return node;
    }
}
