package org.example.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private volatile int capacity;
   private  Map<Integer,ListNode> map = null;


   private ListNode head;





    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            // 当前节点的前驱
            ListNode curPre = cur.pre;
            // 当前节点的后继
            ListNode curNext = cur.next;

            // 说明是头节点
            if(curPre == null){
                return cur.value;
            }else{
                curPre.next = curNext;
                if(curNext != null){
                    curNext.pre = curPre;
                }
            }
            cur.next = head;
            cur.pre = null;
            head.pre = cur;
            head = cur;
            head.pre = null;
            System.out.println(cur.value);
            return cur.value;

        }else {
            System.out.println(-1);

            return -1;
        }

    }

    public void put(int key, int value) {
        // 首次插入
        if(head == null){
            ListNode e = new ListNode();
            e.key = key;
            e.value = value;
            head =e;
            map.put(key,e);
        }else{
            if(map.containsKey(key)){
                ListNode cur = map.get(key);
                cur.value = value;
                // 当前节点的前驱
                ListNode curPre = cur.pre;
                // 当前节点后继
                ListNode curNext = cur.next;

                // 前驱节点是null 说明是头节点
                if(curPre == null){
                    return;
                }else{
                    curPre.next = curNext;
                    if(curNext != null){
                        curNext.pre = curPre;
                    }

                    cur.next = head;
                    head.pre = cur;
                    head = cur;
                    head.pre = null;
                }

            }else{
                // 容量没满
                ListNode e = new ListNode();
                e.key = key;
                e.value = value;

                // 容量满了
                if(map.size() == capacity){

                    // 找到最后的节点
                    ListNode cur = head;
                    ListNode pre = null;
                    while (cur.next != null){
                        cur = cur.next;
                    }

                    // 当前节点的前驱 == null
                    if(cur.pre == null){
                        head = e;
                        map.remove(cur.key);
                        map.put(key,e);
                        return;
                    }else{
                        // 非头节点
                        // 断链
                        pre = cur.pre;
                        map.remove(cur.key);
                        cur.pre = null;
                        pre.next = null;

                        // 重新断链
                        e.next = head;
                        head.pre = e;
                        head = e;
                        map.put(key,e);
                    }
                }else{

                    e.next = head;
                    head.pre = e;
                    head = e;
                    map.put(key,e);
                }
            }
        }
    }

    class ListNode{
        int key;
        int value;

        ListNode pre;
        ListNode next;


    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);

        Long s = System.currentTimeMillis();

        String a = "10|10,13|3,17|6,11|10,5|9,10|13|2,19|2|3|5,25|8|9,22|5,5|1,30|11|9,12|7|5|8|9|4,30|9,3|9|10|10|6,14|3,1|3|10,11|8|2,14|1|5|4|11,4|12,24|5,18|13|7,23|8|12|3,27|2,12|5|2,9|13,4|8,18|1,7|6|9,29|8,21|5|6,30|1,12|10|4,15|7,22|11,26|8,17|9,29|5|3,4|11,30|12|4,29|3|9|6|3,4|1|10|3,29|10,28|1,20|11,13|3|3,12|3,8|10,9|3,26|8|7|5|13,17|2,27|11,15|12|9,19|2,15|3,16|1|12,17|9,1|6,19|4|5|5|8,1|11,7|5,2|9,28|1|2,2|7,4|4,22|7,24|9,26|13,28|11,26";
        String[] split = a.split("\\|");
        for(int i=0;i<split.length;i++){
            if(split[i].contains(",")){
                String[] split1 = split[i].split(",");
                lruCache.put(Integer.parseInt(split1[0]),Integer.parseInt(split1[1]));
            }else{
                lruCache.get(Integer.parseInt(split[i]));
            }
        }


        System.out.println("耗时 " + (System.currentTimeMillis() - s));


    }
}
