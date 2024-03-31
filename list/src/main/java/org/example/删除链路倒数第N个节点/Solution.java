package org.example.删除链路倒数第N个节点;

import org.example.ListNode;
import org.example.翻转链表.LinkedList;

public class Solution {

    /**
     * todo O(n) 一次遍历处理
     * 快慢指针
     * 要删除节点N 必须找到节点N的钱一个节点
     * N_pre.next = N_pre.next.next; 做删除动作
     * 链表长度为l
     * fast 先走n+1步
     * n + 1 + x = fast
     * x + n + 1 = slow
     * 所以此时慢指针指向的是要删除节点的前一个节点，符合我们的要求
     *
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndV2(ListNode head, int n){
        ListNode dummy = new ListNode(-1,null);
        dummy.next = head;
        // 快指针
        ListNode fast = dummy;
        // 慢指针
        ListNode slow = dummy;

        // 快指针先动n+1步
        while(fast != null){
            fast=fast.next;
            // 慢指针移动的条件是快指已经移动了n+1节点
            if(n+1<=0){
                slow = slow.next;
            }
            n--;

        }
        slow.next = slow.next.next;

        return dummy.next;
    }

    /**
     * V1 版本暴力解法
     * 先求链表长度
     * 将倒数转换为正数
     * 然后做删除动作
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndV1(ListNode head, int n) {
        // 1. 计算链表的长度
        int length = getLength(head);

        // 2. 将倒数转换为正数
        int nPlus = length - n;

        // 3. 做节点删除断开当前节点需要找到当前节点的前驱
        ListNode dummy = new ListNode(-1,null);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        // 用做计数
        int i = 0;
        while(cur != null){
            if(nPlus == i){
                // 删除cur
                pre.next = cur.next;
                break;
            }else{
                i++;
                ListNode temp = cur.next;
                pre = cur;
                cur = temp;
            }
        }
        return dummy.next;
    }

    private int getLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
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
        System.out.println("delete before: ");
        System.out.println(linkedList.println(linkedList.head));
        ListNode headAfterDelete = solution.removeNthFromEndV2(linkedList.head, 1);
        System.out.println("delete after: ");
        System.out.println(linkedList.println(headAfterDelete));




    }
}
