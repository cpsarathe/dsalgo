package com.cp.thedailybyte.linkedlist;

import com.cp.DS.CustomLinkedList;
import com.cp.DS.ListNode;

/**
 * Given a potentially cyclical linked list where each value is unique,
 * return the node at which the cycle starts. If the list does not contain a cycle, return null.
 *
 * Ex: Given the following linked lists...
 *
 * 1->2->3, return null
 * 1->2->3->4->5->2 (5 points back to 2), return a reference to the node containing 2
 * 1->9->3->7->7 (7 points to itself), return a reference to the node containing 7
 */
public class StartOfCycle {

    public static void main(String[] ar) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addItem(20);
        customLinkedList.addItem(21);
        customLinkedList.addItem(22);
        customLinkedList.addItem(23);
        customLinkedList.addItem(24);
        customLinkedList.addItem(25);

        StartOfCycle obj = new StartOfCycle();
        ListNode result = obj.detectCycle(customLinkedList.getHead());
        System.out.println(result.val);

    }

    public ListNode detectCycle(ListNode head) {
        //we can use slow and fast pointer
        //the moment we find it exists we return the previous of fast pointer
        if(head==null || head.next==null) return null;

        ListNode slow = head;
        ListNode fast = head;

        //first detect cycle
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                break;
            }
        }
        //if fast reached the end of list there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        //check if slow and fast both were able to match
        //the place they match is a cycle
        slow = head;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
