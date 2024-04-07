package org.example.两个数组的交集;

import java.util.*;

public class Solution {

    /**
     * 两个数组的交集
     * 给定两个数组 nums1 和 nums2 ，返回 它们的
     * 交集
     *  。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * 示例 2：
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 解释：[4,9] 也是可通过的
     *
     *
     * 提示：
     *
     * 1 <= nums1.length, nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 1000
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> a = new HashMap<>();


        for(int i=0;i<nums1.length;i++){
            a.put(nums1[i],1);

        }

        List<Integer> result = new ArrayList<>();
        for(int j=0;j<nums2.length;j++){
            if(a.containsKey(nums2[j])){
                result.add(nums2[j]);
                a.remove(nums2[j]);
            }
        }
        if(result.size() == 0){
            return new int[]{};
        }
        int[] r = new int[result.size()];
        int i=0;
        for(Integer j : result){
            r[i++] = j;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,2,1};
        int[] b = new int[]{3,4};
        System.out.println(Arrays.toString(intersection(a,b)));;
    }
}
