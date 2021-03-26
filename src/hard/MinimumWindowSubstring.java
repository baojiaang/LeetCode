package hard;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
      int start = 0,min_len = Integer.MAX_VALUE;  // 记录子串起始点和长度
      int left = 0, right = 0;
      int num_match = 0;
      HashMap<Character,Integer> window = new HashMap<>();
      HashMap<Character,Integer> need = new HashMap<>();
      String res = "";
      for(Character c:t.toCharArray()){
          need.put(c,need.getOrDefault(c,0)+1);
          System.out.println(c);
      }

      while(right < s.length()){
          char r  = s.charAt(right);
          if(need.containsKey(r)){
              window.put(r,window.getOrDefault(r,0)+1);
              if(window.get(r).intValue() == need.get(r).intValue()){  // 返回的是对象，为Integer时范围【-128，127】  要用invalue 或者 equals
                  num_match++;
              }
          }
          right++;
          while( num_match == need.size()){
              int len = right - left;
              if(len < min_len){
                  min_len = len;
                  start = left;
                  res = s.substring(left,right);
              }
              char l = s.charAt(left);
              if(window.containsKey(l)) {
                  window.put(l, window.get(l) - 1);
                  if(window.get(l).intValue() < need.get(l).intValue()){
                      num_match--;
                  }
              }
              left++;
          }
      }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring m = new MinimumWindowSubstring();
        m.minWindow(s,t);
    }
}
