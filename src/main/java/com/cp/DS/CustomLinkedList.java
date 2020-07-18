package com.cp.DS;

public class CustomLinkedList {
    private ListNode head;

    public void addItem(int val){
        ListNode node = new ListNode(val);
        if(head==null) {
            head = node;
            return;
        }
        ListNode temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public ListNode  getHead(){
        return this.head;
    }

    public static void print(ListNode node){
        ListNode temp = node;
        while(temp!=null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

