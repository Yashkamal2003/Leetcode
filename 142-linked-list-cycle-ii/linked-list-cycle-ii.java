/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare= head;
        ListNode tortoise=head;
        do{
            if( hare==null|| hare.next==null)
            return null;
            tortoise=tortoise.next;
            hare= hare.next.next;
        }
        while( hare !=tortoise);
            hare= head; 
            while(hare != tortoise){
                hare= hare.next;
                tortoise= tortoise.next;
            }
         return hare;

    }
}