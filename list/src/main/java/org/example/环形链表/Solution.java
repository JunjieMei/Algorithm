package org.example.环形链表;

import org.example.ListNode;

/**
 * 判断链表是否有环并找到入环点
 * 1.
 */
public class Solution {

    /**
     * 判断一个链表是否有环
     * fast快指针
     * slow慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            // 循环终止
            // 如果无环，那最后fast == null || fast.next == null
            if(fast == null || fast.next == null){
                return false;
            }else{
                // 快指针先走，每次走两步
                fast = fast.next.next;
                // 慢指针每次走一步，如果有环则快指针最终会追上慢指针
                slow = slow.next;
                if(fast == slow){
                    return true;
                }
            }

        }
    }


    /**
     * 如果链表有环，则返回快慢指针相遇的节点MeetNode
     * 如果链表无环，则返回null
     * @param head
     * @return
     */
    public static ListNode hasCycleReturnMeetNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null){
                // 说明链表没有环
                return null;
            }else{
                // 快指针先走，每次走两步
                fast = fast.next.next;
                slow = slow.next;
                // 判断快慢指针是否相遇，如果相遇则返回MeetNode
                if(fast == slow){
                    return fast;
                }
            }
        }
    }


    public static ListNode detectCycle(ListNode head){
        // 1. 先判断链表是否有环，如果有环则返回环中快慢指针相遇的节点MeetNode
        // 2. 如果链表没有环，则返回null;
        ListNode meetNode = hasCycleReturnMeetNode(head);
        if(meetNode == null){
            return null;
        }

        ListNode startIndex = head;
        ListNode meetNodeIndex = meetNode;

        // 3. 如果有环则必然会找到相遇的节点
        while(true){
            if(startIndex == meetNodeIndex){
                return startIndex;
            }else{
                // 外部头指针向前移动
                startIndex = startIndex.next;
                // 环内从meetNode开始向前移动
                meetNodeIndex = meetNodeIndex.next;
            }
        }

    }
}
