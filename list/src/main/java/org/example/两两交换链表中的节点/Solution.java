package org.example.两两交换链表中的节点;

import org.example.ListNode;
import org.example.翻转链表.LinkedList;

public class Solution {


    /**
     *
     * @param head
     * @return
     */
    public ListNode swapPairsV1(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != null && fast != null){
            int fV = fast.val;
            int sV = slow.val;
            fast.val = sV;
            slow.val = fV;
            if(fast.next != null){
                slow = fast.next;
                fast = fast.next.next;
            }else{
                break;
            }
        }
        return head;
    }


    /**
     * 两两交换
     * @param head
     * @return
     */
    public ListNode swapPairsV2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }



        ListNode dummy = new ListNode(-1,null);
        dummy.next =head;
        ListNode cur = dummy;

        // 什么时候终止循环
        while(cur.next != null && cur.next.next!=null){

            // cur的next
            ListNode temp = cur.next;
            // cur的next.next.next
            ListNode temp_ = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = temp_;
            cur = cur.next.next;
        }


        return dummy.next;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(6);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(5);

        Solution solution = new Solution();
        System.out.println("swap before: ");
        System.out.println(linkedList.println(linkedList.head));
        ListNode swapAfter = solution.swapPairsV2(linkedList.head);
        System.out.println("swap after: ");
        System.out.println(linkedList.println(swapAfter));;
    }
}
