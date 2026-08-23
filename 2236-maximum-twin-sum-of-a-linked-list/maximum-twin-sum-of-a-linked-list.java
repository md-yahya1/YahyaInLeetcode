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
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is at mid
        // cut the link at mid
        prev.next = null;
        // reverse the second half

        prev = null;
        ListNode curr = slow;
        ListNode nxt = curr.next;

        while(curr != null)
        {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        // First head at head.
        // Second head at prev.

        int maxSum = 0;
        while(prev != null)
        {

            if(prev.val + head.val > maxSum)
            {
                maxSum = prev.val + head.val;
            }
            prev  = prev.next;
            head = head.next;
        }

        return maxSum;
    }
}