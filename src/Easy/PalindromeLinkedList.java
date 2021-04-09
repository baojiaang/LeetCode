package Easy;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        if(length == 1)
            return true;
        int mid = length / 2;

        cur = head;
        for(int i = 0; i < mid; i++){
            s.add(cur.val);
            cur = cur.next;
        }
        if(length %2 != 0) {
            cur = cur.next;
        }
        while(cur != null){
            int head_val = s.pop();
            int cur_val = cur.val;
            if(head_val != cur_val)
                return false;
            else{
                cur = cur.next;
            }
        }
        return true;
    }
}
