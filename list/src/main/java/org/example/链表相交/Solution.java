package org.example.链表相交;

import org.example.ListNode;

public class Solution {
    /**
     * V1暴力法
     * 1. 获取两个链路的长度
     * 2. 设置快慢指针 diff差值
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeV1(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        // 获取链表A的长度
        while (pA != null){
            aLength++;
            pA = pA.next;
        }
        while(pB != null){
            bLength++;
            pB = pB.next;
        }

        // 判断快慢指针
        ListNode fast = null;
        ListNode slow = null;
        if(aLength>bLength){
            fast = headA;
            slow = headB;
        }else{
            fast = headB;
            slow = headA;
        }

        int n = Math.abs(aLength - bLength);

        // 让快指针先动
        while(n>0){
            fast = fast.next;
            n--;
        }
        while(fast != null){
            if(fast == slow){
                return fast;
            }else{
                // 快指针移动
                fast = fast.next;
                // 慢指针移动
                slow = slow.next;
            }
        }
        return null;
    }
}
