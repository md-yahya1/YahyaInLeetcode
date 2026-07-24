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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode current = head;
        ListNode nxt = head.next;

        while(nxt != null)
            {
                if(current.val == nxt.val)
                {
                    current.next = nxt.next;
                }
                else{
                    current = current.next;
                }
                nxt = nxt.next;
            }

        return head;
    }
}