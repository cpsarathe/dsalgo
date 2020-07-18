package com.cp.thedailybyte.linkedlist;

import com.cp.DS.CustomLinkedList;
import com.cp.DS.ListNode;

public class MergeTwoLinkedLists {
    public static void main(String[] ar) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addItem(1);
        customLinkedList.addItem(1);
        customLinkedList.addItem(2);

        CustomLinkedList customLinkedList2 = new CustomLinkedList();
        customLinkedList2.addItem(1);
        customLinkedList2.addItem(2);
        customLinkedList2.addItem(6);

        MergeTwoLinkedLists mergeTwoLinkedLists = new MergeTwoLinkedLists();
        ListNode result = mergeTwoLinkedLists.mergeTwoLists(customLinkedList.getHead(),customLinkedList2.getHead());

        CustomLinkedList.print(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //we know both lists are sorted so what we can do is
        //loop both list in same loop and if we found p1<p2 take p1 as output
        //increase p1 to its next
        //same for p2 if p2<p1 take p2 as output and increase p2 to its next

        //In order to achieve this using splicing we can use two varaible
        //top , root
        //top will hold result in one particular loop iteration
        //root is to point to top element for a chain

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode top = new ListNode(-1);
        ListNode root = top;
        while(p1!=null && p2!=null) {
            if(p1.val <= p2.val){
                top.next = p1;
                p1 = p1.next;
            }
            else if(p2.val < p1.val){
                top.next = p2;
                p2 = p2.next;
            }
            top = top.next;
        }
        //since while was && AND condition one of list might not be visited
        if(p2!=null) {
            top.next = p2;
        }
        if(p1!=null) {
            top.next = p1;
        }
        return root.next;
    }
}


