package main.book;

import main.bean.ListNode;

public class Reverselinked {


    public static void main(String[] args){

        ListNode head = ListNode.create(1,2,3,4,5,6,7,8,9,0);

        ListNode nowHead = iteration(head);

        ListNode.showList(nowHead);
    }

    private static ListNode iteration(ListNode head){

        ListNode last = null;
        ListNode now = head;
        ListNode next = now.next;

        while(now != null){
            now.next = last;
            last = now;
            now = next;
            if(now != null){
                next = now.next;
            }
        }


        return last;
    }


    private static ListNode recursive(ListNode head){
        return dfs(head,null);
    }

    private static ListNode dfs(ListNode head,ListNode temp){
        if(head == null){
            return temp;
        }

        ListNode first = dfs(head.next,head);
        head.next = temp;

        return first;
    }

}
