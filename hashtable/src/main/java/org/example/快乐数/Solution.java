package org.example.快乐数;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final String trueFlag = "1";

    public boolean isHappy(int n) {
        String nStr = String.valueOf(n);
        Map<String,Integer> map = new HashMap<>();
        while (true){
            String s = transformSquare(nStr);
            // 判断是否无限循环，如果无限循环
            if(trueFlag.equals(s)){
                return true;
            }else{
                // 发生了循环则不是快乐数了
                if(map.containsKey(nStr)){
                    return false;
                }else {
                    map.put(nStr,1);
                }
                nStr = s;
            }
        }
    }

    private String transformSquare(String n){
        Long sum = 0L;
        for(int i=0;i<n.length();i++){
            char c = n.charAt(i);
            Long number = Long.valueOf(String.valueOf(c));
            sum += (number*number);
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));;

        System.out.println(solution.isHappy(2));;


    }
}
