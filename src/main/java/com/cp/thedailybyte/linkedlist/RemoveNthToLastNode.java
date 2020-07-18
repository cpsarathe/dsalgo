package com.cp.thedailybyte.linkedlist;

import com.cp.DS.CustomLinkedList;
import com.cp.DS.ListNode;

public class RemoveNthToLastNode {
    public static void main(String[] ar) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addItem(1);
        customLinkedList.addItem(2);
        customLinkedList.addItem(3);
        customLinkedList.addItem(4);
        customLinkedList.addItem(5);

        RemoveNthToLastNode obj = new RemoveNthToLastNode();
        ListNode result = obj.removeNthFromEnd(customLinkedList.getHead(),1);
        CustomLinkedList.print(result);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //we need to get the size first for the given list
        //so that we can reach to the node from end

        //we run loop until lisSize - n which will give us toBeDeletedNode
        //we also maintain currentNode which is just before the toBeDeletedNode
        ListNode temp = head;
        int listSize = 0;
        while (temp != null) {
            listSize++;
            temp = temp.next;
        }
        //if n == listSize
        if (listSize == n) {
            return head.next;
        }
        temp = head;
        ListNode delNode = head;
        ListNode currNode = head;
        for (int i = 0; i < listSize - n; i++) {
            currNode = temp;
            temp = temp.next;
            delNode = temp;
        }
        //we are already running loop less than list size so next wont be null
        currNode.next = delNode.next;
        return head;
    }
}
