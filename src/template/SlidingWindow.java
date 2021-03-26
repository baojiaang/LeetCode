package template;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
    boolean valid = true;
    public void slide(int[] s){
        int left = 0, right = 0;
        List<Integer> window = new ArrayList<>();
        while(right < s.length){
            window.add(s[right]);
            right++;
            while(valid){
                window.remove(s[left]);
                left++;
            }
        }
    }
}
