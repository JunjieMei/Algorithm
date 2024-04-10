package org.example.删除排序链表中的重复元素2;

import org.example.ListNode;

public class Solution {

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     *
     *
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode duplicateNode = null;
        ListNode cur = dummy.next;
        while(cur != null && cur.next != null){
           if(cur.val == cur.next.val){
               if(duplicateNode == null){
                   duplicateNode =cur;
               }
               cur = cur.next;
           }else{
               // 前驱指向当前节点
               if(duplicateNode != null){
                   pre.next = cur.next;
                   duplicateNode = null;
               }else{
                   pre = cur;
               }
               cur =cur.next;
           }
        }
        // 说明一直有重复节点
        // 直接置为null
        if(duplicateNode != null ){
            pre.next = null;
        }
        return dummy.next;

    }
}
