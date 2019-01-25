package main.leetcode;

public class addTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void main(String[] ar){
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        oddEvenList(list);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head ,last = new ListNode(0);
        ListNode listNode;
        head = last.next;

        boolean first = true;
        int sum;
        boolean next = false;

        while (l1!=null || l2!=null){
            listNode = new ListNode(0);
            if(next){
                if(l1 == null){
                    sum = l2.val + 1;
                }else if(l2 == null){
                    sum = l1.val + 1;
                }else {
                    sum = l1.val + l2.val + 1;
                }
            }else {
                if(l1 == null){
                    sum = l2.val;
                }else if(l2 == null){
                    sum = l1.val;
                }else {
                    sum = l1.val + l2.val;
                }
            }

            if(sum>9){
                listNode.val = sum%10;
                next = true;
            }else{
                listNode.val = sum;
                next = false;
            }

            if(first){
                head = listNode;
                first = false;
            }
            last.next = listNode;
            last = last.next;

            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }

        if(next){
            last.next = new ListNode(1);
        }

        return head;

    }

    public static ListNode oddEvenList(ListNode head) {
        if(head ==null && head.next == null){
            return head;
        }

        ListNode tempA = head;
        ListNode tempB = head.next;
        ListNode headB = tempB;

        int x = 0;
        for(ListNode temp = head.next.next;temp!=null;temp = temp.next){
            if(x%2==0){
                tempA.next = temp;
                tempA = tempA.next;
            }else{
                tempB.next = temp;
                tempB = tempB.next;
            }
            x++;
        }

        tempA.next = headB;

        return head;
    }
}
