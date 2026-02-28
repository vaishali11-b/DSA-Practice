package linkedlist;
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
public class DetectCycle {
    public boolean detectLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        if(head == null || head.next == null){
            return false;
        }
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
