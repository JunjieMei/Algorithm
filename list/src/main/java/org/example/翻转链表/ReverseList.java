package org.example.翻转链表;

import org.example.ListNode;

public class ReverseList {


    /**
     * 基于双指针
     * 翻转链表 （双指针法）
     * 1 --> 2 --> 3 --> 4 --> 5 --> null
     * 5 --> 4 --> 3 --> 2 --> 1 --> null
     *
     * @param head  链表头节点
     * @return      链表
     */
    public ListNode reverseListDoublePoint(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            // 保存cur.next;
            ListNode temp = cur.next;
            // 当前节点指向pre;
            cur.next = pre;
            // pre指针指向cur
            pre = cur;
            // cur指向next节点
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseListByRecurse(ListNode head){
        return reverse(head,null);
    }

    private ListNode reverse(ListNode cur, ListNode pre){
        if(cur == null){
            // 递归终止条件
            return pre;
        }
        ListNode curNext = cur.next;
        cur.next = pre;
        // 移动pre指针
        pre = cur;
        return reverse(curNext,pre);
    }


    /**
     * 采用头插法
     * dummy节点
     * dummy --> 1 --> 2 --> 3 --> 4 --> 5 --> null
     * dummy --> 5 --> 4 --> 3 --> 2 --> 1 --> null;
     * @param head  链表头节点
     * @return      链表
     */
    public ListNode reverseListDummyNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1,null);
        ListNode cur = head;
        while (cur != null){
            // 保存当前节点的next节点
            ListNode curNext = cur.next;
            // 判断dummy.next是否为null
            if(dummy.next == null){
                dummy.next = cur;
                // 断开连接
                cur.next = null;
            }else{
                ListNode temp_ = dummy.next;
                // 当前节点指向哑结点的后继
                cur.next = temp_;
                dummy.next = cur;
            }
            // 移动cur
            cur = curNext;
        }
        return dummy.next;
    }
}
