package Median;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

}
class TimeMap {
    HashMap<String,TreeMap<Integer,String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            TreeMap<Integer,String> tree_map = map.get(key);
            tree_map.put(timestamp,value);
            map.put(key,tree_map);
        }
        else{
            TreeMap<Integer,String> tree_map = new TreeMap();
            tree_map.put(timestamp,value);
            map.put(key,tree_map);
        }
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tree_map = map.get(key);
        if(tree_map == null)
            return "";
        else{
            Map.Entry<Integer,String> e = tree_map.floorEntry(timestamp);
            if(e == null)
                return "";
            else
                return e.getValue();
        }
    }
}
