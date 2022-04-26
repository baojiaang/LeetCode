package Median;

import java.util.Random;

public class Q382 {
    ListNode head;
    Random random;
    public Q382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int ret = 0;
        int index = 1;
        ListNode cur = head;
        while(cur != null){
            if(random.nextInt(index) == 0){
                ret =  cur.val;
            }
            cur = cur.next;
            index++;
        }
        return ret;
    }
}
