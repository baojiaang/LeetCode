package Easy;

public class DesignHashSet {

}
class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[] set;
    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}
