package org.example.赎金信;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     *
     * 如果可以，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 基于hashMap实现
        if(ransomNote == null || magazine == null){
            return false;
        }

        Map<Character,Integer> sourceCharacterMap = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            if(sourceCharacterMap.containsKey(c)){
                sourceCharacterMap.put(c,sourceCharacterMap.get(c) + 1);
            }else{
                sourceCharacterMap.put(c,1);
            }
        }

        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(!sourceCharacterMap.containsKey(c)){
                return false;
            }else{
                if(sourceCharacterMap.get(c) - 1 < 0){
                    return false;
                }else{
                    sourceCharacterMap.put(c,sourceCharacterMap.get(c) - 1);
                }
            }
        }


        return true;
    }
}
