package org.example.翻转链表;

import org.example.ListNode;

public class LinkedList {
    public ListNode head;

    /**
     * 向链表中插入元素
     * @param val
     * @return
     */
    public boolean add(int val){
        if(head == null){
            head = new ListNode(val,null);
        }else{
            ListNode cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new ListNode(val,null);
        }
        return true;
    }

    /**
     * 指定索引查询 todo
     * @param index
     * @return
     */
    public int findAt(int index){
        return -1;
    }

    public String println(ListNode node){
        if(node == null){
            return "null";
        }
        ListNode cur = node;
        StringBuilder sb = new StringBuilder();
        while(cur != null){
            sb.append(cur.val).append("-->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(6);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(5);


        System.out.println(linkedList.toString());

        System.out.println(linkedList.println(linkedList.head));

    }
}
