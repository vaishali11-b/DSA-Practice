/*
 * 141.Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle
 */

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
public class 141 {
    public boolean hasCycle(ListNode head) {
        HashSet <ListNode> map=new HashSet<ListNode>();

        while(head!=null){
            if(map.contains(head))
            {
                return true;
            }
            
            map.add(head);
            head=head.next;
        }
        return false;
    }
}
