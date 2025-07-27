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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new   PriorityQueue<>(
            (a,b) -> a.val -b.val
        );
        for( int i=0;i<lists.length;i++)
         if (lists[i] != null)
        pq.add(lists[i]);
        ListNode head= null;
        ListNode curr= head;
        while(!pq.isEmpty()){
            ListNode currMinNode=pq.poll();
            if(head== null)
            {
                head= new ListNode(currMinNode.val);
                curr= head;
            }
            else
            {
                curr.next= new ListNode(currMinNode.val);
                curr=curr.next;
            }
            if(currMinNode.next!=null)
            pq.add(currMinNode.next);

        }
        return head;
    }
}