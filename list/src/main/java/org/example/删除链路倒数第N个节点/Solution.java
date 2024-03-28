package org.example.删除链路倒数第N个节点;

import org.example.ListNode;
import org.example.翻转链表.LinkedList;

public class Solution {

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
        ListNode headAfterDelete = solution.removeNthFromEndV1(linkedList.head, 3);
        System.out.println("delete after: ");
        System.out.println(linkedList.println(headAfterDelete));

    }
}
