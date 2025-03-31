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
    public boolean hasCycle(ListNode head) {
        ListNode hare= head;
        ListNode tortoise= head;
        do{
            if( hare== null || hare.next==null)
            return false;
             tortoise= tortoise.next;
             hare= hare.next.next;
        } while( hare !=tortoise );
        return true;
    }
}