package com.cp.thedailybyte.linkedlist;

import com.cp.DS.CustomLinkedList;
import com.cp.DS.ListNode;

/**
 * Given a linked list, containing unique values, reverse it, and return the result.
 *
 * Ex: Given the following linked lists...
 *
 * 1->2->3->null, return a reference to the node that contains 3 which points to a list that looks like the following:
 * 3->2->1->null
 * 7->15->9->2->null, return a reference to the node that contains 2 which points to a list that looks like the following:
 * 2->9->15->7->null
 * 1->null, return a reference to the node that contains 1 which points to a list that looks like the following:
 * 1->null
 */
public class ReverseLinkedList {
    public static void main(String[] ar) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addItem(20);
        customLinkedList.addItem(21);
        customLinkedList.addItem(22);
        customLinkedList.addItem(23);
        customLinkedList.addItem(24);
        customLinkedList.addItem(25);
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode result = obj.reverseLinkedList(customLinkedList.getHead());
        CustomLinkedList.print(result);
    }

    public ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next ==null){
            return head;
        }
        //we can use three pointer next , previous and current
        //loop through current
        //point firstNode next to Previous which was null initially
        //move current to next
        //set previous to current
        //repeat this at the end previous is the node which points to head of reverse list

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current!=null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
