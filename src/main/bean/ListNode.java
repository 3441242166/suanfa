package main.bean;

import main.book.Reverselinked;

public class ListNode {

    public int val;
    public ListNode next;


    public ListNode(int val){
        this.val = val;
    }

    public static ListNode create(Integer...data){
        if(data == null){
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        for(Integer val : data){
            ListNode next = new ListNode(val);
            temp.next = next;
            temp = temp.next;
        }

        showList(head.next);
        return head.next;
    }

    public static void showList(ListNode head){
        for(ListNode temp = head;temp!=null;temp = temp.next){
            System.out.print(temp.val+"  ");
        }
        System.out.println();
    }

    public static ListNode reverceList1(ListNode listNode){
        ListNode last = null;
        ListNode now = listNode;
        ListNode next = listNode.next;

        while (next != null){
            now.next = last;
            last = now;
            now = next;
            next = now.next;
        }

        return now;
    }

//    public static ListNode reverceList2(ListNode listNode){
//        if(listNode == null){
//            return null;
//        }
//
//        listNode.next = listNode;
//
//        return reverceList2(listNode.next);
//    }
}
