package Easy;

import java.util.Arrays;

public class DesignHashMap {

}
class MyHashMap {

    /** Initialize your data structure here. */
    int[] hashset;
    public MyHashMap() {
        hashset = new int[1000001];
        Arrays.fill(hashset,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashset[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashset[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashset[key] = -1;
    }
}