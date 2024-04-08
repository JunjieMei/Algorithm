package org.example.奇偶链表;

import org.example.ListNode;

public class Solution {

    /**
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     *
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     *
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     *
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * 示例 1:
     * 输入: head = [1,2,3,4,5]
     * 输出: [1,3,5,2,4]
     * 示例 2:
     * 输入: head = [2,1,3,5,6,4,7]
     * 输出: [2,3,6,7,1,5,4]
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if(dummy.next == null || dummy.next.next == null){
            return dummy.next;
        }

        ListNode f = dummy.next;
        ListNode s = f.next;
        ListNode dummy2 = new ListNode(-1);
        dummy2.next = s;
        ListNode lastF = null;

        // 确定循环退出条件
        while(s != null && s.next != null){
            // 断链
            f.next = s.next;
            // 奇数节点移动两位
            f = s.next;
            // 偶数节点指向奇数节点的下一位
            s.next = f.next;
            // 偶数节点
            s = f.next;
            // 保留奇数索引的最后一个节点
            lastF = f;
        }
        if(lastF != null){
            lastF.next = dummy2.next;
        }

        return dummy.next;
    }
}
