package org.example.四数相加2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     *
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
     * 输出：2
     * 解释：
     * 两个元组如下：
     * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
     * 示例 2：
     *
     * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
     * 输出：1
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCountV1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 暴力法
        int l = nums1.length;
        int count = 0;
        for(int i=0;i<l;i++){
            int a = nums1[i];
            for(int j=0;j<l;j++){
                int b = nums2[j];
                for(int k=0;k<l;k++){
                    int c = nums3[k];
                    for(int m=0;m<l;m++){
                        int d = nums4[m];
                        if((a + b + c + d) == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int fourSumCountV2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer,Integer> aM = new HashMap<>();
        Map<Integer,Integer> bM = new HashMap<>();
        int l = nums1.length;
        for(int i=0;i<l;i++){
            int a = nums1[i];
            for(int j=0;j<l;j++){
                int b = nums2[j];
                int sum = a + b;
                if(aM.containsKey(sum)){
                    aM.put(sum,aM.get(sum) + 1);
                }else{
                    aM.put(sum,1);
                }
            }
        }

        for(int m=0;m<l;m++){
            int a = nums3[m];
            for(int n=0;n<l;n++){
                int b = nums4[n];
                int sum = a + b;
                if(bM.containsKey(sum)){
                    bM.put(sum,bM.get(sum) + 1);
                }else {
                    bM.put(sum,1);
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry : aM.entrySet()){
            int target = (-entry.getKey());
            if(bM.containsKey(target)){
                count += bM.get(target);
            }
        }

        return count;
    }


}
