//O(N) time, O(1) space

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast,slow = fast = head;
        if(head==null || head.next==null)
            return true;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = fast==null?slow:slow.next;
        ListNode backup = mid;
        ListNode temp;

        ListNode current = mid.next;

        while(current!=null){
            temp = current.next;
            current.next = mid;
            mid = current;
            current = temp;
        }
        while(mid!=backup){
            if(mid.val != head.val)
                return false;
            mid = mid.next;
            head = head.next;
        }
        return mid.val==head.val;
    }
}