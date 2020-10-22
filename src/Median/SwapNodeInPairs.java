//Given a linked list, swap every two adjacent nodes and return its head.
//
//        You may not modify the values in the list's nodes. Only nodes itself may be changed.
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package Median;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        else if(head!=null && head.next == null){
            return head;
        }
        else if(head!= null && head.next!=null){
            ListNode first = head; ListNode second = head.next; ListNode pre = null;
            ListNode head1 = second;
            while(first != null && second != null){
                pre = swapTwo(first,second,pre);
                if(pre.next!=null)
                    first = pre.next;
                second = first.next;
            }
            return head1;
        }
        return null;
    }
    public ListNode swapTwo(ListNode first,ListNode second,ListNode pre){
        if(pre!=null) {
            ListNode temp = second.next;
            pre.next = second;
            second.next = first;
            first.next = temp;
            return first;
        }
        else{
            ListNode temp = second.next;
            second.next = first;
            first.next = temp;
            return first;
        }
    }
}
