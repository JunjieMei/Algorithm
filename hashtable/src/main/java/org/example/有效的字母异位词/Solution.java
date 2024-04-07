package org.example.有效的字母异位词;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    /**
     * 一次遍历
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram4(String s, String t){




        return false;
    }

    /**
     * 暴力法
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Integer> charNumMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(charNumMap.containsKey(c)){
                charNumMap.put(c,charNumMap.get(c)+1);
            }else{
                charNumMap.put(c,1);
            }
        }

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(charNumMap.containsKey(c)){
                Integer i1 = charNumMap.get(c);
                if((i1-1) == 0){
                    charNumMap.remove(c);
                }else{
                    charNumMap.put(c,i1-1);
                }
            }
        }

        return charNumMap.isEmpty();
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
