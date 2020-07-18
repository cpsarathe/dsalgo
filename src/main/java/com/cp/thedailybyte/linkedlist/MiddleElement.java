package com.cp.thedailybyte.linkedlist;

import com.cp.DS.CustomLinkedList;
import com.cp.DS.ListNode;

/**
 * Given a non-empty linked list, return the middle node of the list.
 * If the linked list contains an even number of elements, return the node closer to the end.
 *
 *
 * 1->2->3->null, return 2
 * 1->2->3->4->null, return 3
 * 1->null, return 1
 */
public class MiddleElement {

    public static void main(String[] ar) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addItem(11);
        customLinkedList.addItem(21);

        MiddleElement obj = new MiddleElement();
        ListNode result = obj.findMiddleElement(customLinkedList.getHead());
        System.out.println(result.val);

    }

    public ListNode findMiddleElement(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        ListNode p1 = temp;
        ListNode p2 = temp.next;
        int size = 1;
        while(p2!=null && p2.next!=null){
            p2 = p2.next.next;
            size = size + 2;
            p1 = p1.next;
        }
        if(p2!=null && p2.next==null){
            size = size + 1;
        }
        return size%2==0 ? p1.next : p1;
    }
}
