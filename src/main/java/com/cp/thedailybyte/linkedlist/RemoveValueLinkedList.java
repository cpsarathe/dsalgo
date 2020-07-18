package com.cp.thedailybyte.linkedlist;

import com.cp.DS.CustomLinkedList;
import com.cp.DS.ListNode;

/**
 * Given a linked list and a value, remove all nodes containing the provided value, and return the resulting list.
 * <p>
 * Ex: Given the following linked lists and values...
 * <p>
 * 1->2->3->null, value = 3, return 1->2->null
 * 8->1->1->4->12->null, value = 1, return 8->4->12->null
 * 7->12->2->9->null, value = 7, return 12->2->9->null
 */
public class RemoveValueLinkedList {

    public static void main(String[] ar) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addItem(6);
        customLinkedList.addItem(6);
        customLinkedList.addItem(6);
        customLinkedList.addItem(6);
        customLinkedList.addItem(2);
        customLinkedList.addItem(3);
        customLinkedList.addItem(6);

        RemoveValueLinkedList obj = new RemoveValueLinkedList();
        ListNode result = obj.removeElements(customLinkedList.getHead(), 6);
        CustomLinkedList.print(result);

    }

    public ListNode removeElements(ListNode head, int val) {
        //we can maintain two pointer slow and fast
        //if fast.val is matching with the given val
        //we just delete this node means point slow.next = fast.next
        //we can do this in one pass

        if(head==null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            //when we find head has given value we need to kepe it deleting
            //by moving head
            if (slow.val == val) {
                head = head.next;
                slow = head;
            }
            else if (fast.val == val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        if(slow.val==val) {
            return null;
        }
        return head;
    }
}
