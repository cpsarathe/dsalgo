package com.cp.thedailybyte.linkedlist;

import com.cp.DS.CustomLinkedList;
import com.cp.DS.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, containing unique numbers, return whether or not it has a cycle.
 * Note: a cycle is a circular arrangement (i.e. one node points back to a previous node)
 *
 * Ex: Given the following linked lists...
 *
 * 1->2->3->1 -> true (3 points back to 1)
 * 1->2->3 -> false
 * 1->1 true (1 points to itself)
 */
public class ContainsCycle {
    public static void main(String[] ar) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addItem(11);
        customLinkedList.addItem(12);
        ContainsCycle obj = new ContainsCycle();
        boolean isCycle = obj.isContainCycleBetter(customLinkedList.getHead());
        System.out.println(isCycle);

    }

    public boolean isContainCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        while(temp!=null){
            if(!set.contains(temp.val)){
                set.add(temp.val);
            } else {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean isContainCycleBetter(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            if(slow.val==fast.val) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return (slow.val == fast.val);
    }
}
