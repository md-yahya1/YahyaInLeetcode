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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode oddHead = null;
        ListNode oddTail = null;

        ListNode evenHead = null;
        ListNode evenTail = null;

        int index = 1;
        ListNode temp = head;

        while(temp != null)
        {
            if(index%2 == 0)
            {
                // Even Part
                if(evenHead == null && evenTail == null)
                {
                    evenHead = temp;
                    evenTail = temp;
                }
                else{

                    evenTail.next = temp;
                    evenTail = temp;
                }
            }
            else{

                // Odd Part
                if(oddHead == null && oddTail == null)
                {
                    oddHead = temp;
                    oddTail = temp;
                }
                else{

                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            index++;
            temp = temp.next;
        }

        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;



    }
}