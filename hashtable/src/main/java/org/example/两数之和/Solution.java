package org.example.两数之和;

import java.util.*;

public class Solution {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * @param nums
     * @param target
     * @return
     */

    /**
     * V1 版本暴力法
     * 遍历
     * N2
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int t = target - nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(t == nums[j]){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[]{};
    }


    /**
     * V2 版本
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumV2(int[] nums, int target){
        int[] r = new int[2];
        Map<Integer,Integer> a = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            a.put(i,nums[i]);
        }
        Iterator iterator = a.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> next = (Map.Entry<Integer, Integer>) iterator.next();
            int nextValue = (target - next.getValue());
            int index = next.getKey();
            iterator.remove();
            if(a.containsValue(nextValue)){
                r[0] = index;
                break;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] == (target-nums[r[0]]) && i != r[0]){
                r[1] = i;
                break;
            }
        }

        return r;

    }

    public static int[] twoSumV3(int[] nums, int target){
        int[] r = new int[2];
        Map<Integer,Integer> a = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diffValue = (target - nums[i]);
           if(a.containsKey(diffValue)){
               r[0] = a.get(diffValue);
               r[1] = i;
               break;
           }else{
               a.put(nums[i],i);
           }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumV3(new int[]{3,2,4},6)));;
    }
}
