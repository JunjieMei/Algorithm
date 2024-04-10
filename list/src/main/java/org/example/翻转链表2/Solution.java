package org.example.翻转链表2;

import org.example.ListNode;
import org.example.翻转链表.LinkedList;

public class Solution {

    /**
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || head.next == null || (left == right)){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode lastNode = null;
        ListNode finalLastNode = null;
        int i=1;
        while(cur != null){
            // 正常遍历
            if(left > i){
                pre = cur;
                cur = cur.next;
            }else{
                // 记录最开始的区间
                if(i>right){
                    break;
                }

                if(finalLastNode == null){
                    finalLastNode = cur;
                }


                // 进入遍历区间
                ListNode cNext = cur.next;
                pre.next = cur;
                cur.next = lastNode;
                lastNode = cur;
                cur = cNext;
                if(right == i && cur != null){
                    finalLastNode.next = cur;
                }
            }
            i++;
        }

        return dummy.next;

    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);linkedList.add(2);linkedList.add(3);linkedList.add(4);linkedList.add(5);
        System.out.println(linkedList.println(linkedList.head));;

        ListNode listNode = reverseBetween(linkedList.head, 2, 4);

        System.out.println(linkedList.println(listNode));;


    }

}
