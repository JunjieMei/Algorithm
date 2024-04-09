package org.example.三数之和;

import java.util.*;

public class Solution {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     *
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * @param nums
     * @return
     */


    /**
     * N2
     * @param nums
     * @return
     */
    public  List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> r = new ArrayList<>();
        Map<Integer,Byte> rDMap = new HashMap<>();
        Map<String,List<Integer>> rDRmap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!rDMap.containsKey(nums[i])){
                subTuple(nums,i,nums[i],rDRmap);
                rDMap.put(nums[i],(byte) 1);
            }
        }
        r.addAll(rDRmap.values());
        return r;
    }



    private  void subTuple(int[] nums, int index, int target,Map<String,List<Integer>> rDRmap){
        Map<Integer,Byte> rDMap = new HashMap<>();
        List<Integer> threeTuple = null;
        for(int j=0;j<nums.length;j++){
            if(j!=index){
                int cV = nums[j];
                int diff = -target - cV;
                if(rDMap.containsKey(diff)){
                    Byte diffCount = rDMap.get(diff);
                    if(diffCount != 0){
                        threeTuple = new ArrayList<>();
                        threeTuple.add(target);threeTuple.add(cV);threeTuple.add(diff);
                        Collections.sort(threeTuple);
                        rDMap.put(diff,(byte)(diffCount - ((byte)1)));
                        rDRmap.put(key(threeTuple),threeTuple);
                        // help gc
                        threeTuple = null;
                    }

                }else{
                    rDMap.put(cV,(byte)1);
                }
            }
        }
    }

    private  String key(List<Integer> tuple){
        StringBuilder sb = new StringBuilder();
        tuple.forEach(sb::append);
        return sb.toString();
    }



    /**
     * 暴力法超时
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumV1(int[] nums) {
        // 暴力法
        int l = nums.length;
        List<List<Integer>> r = new ArrayList<>();
        Map<String,List<Integer>>  m = new HashMap<>();
        for(int i=0;i<l;i++){
            int a = nums[i];
            for(int j=i+1;j<l;j++){
                int b = nums[j];
                for(int k=j+1;k<l;k++){
                    int c = nums[k];
                    if((a+b+c) == 0){
                        List<Integer> t = new ArrayList<>();
                        // 找到了
                        t.add(a);t.add(b);t.add(c);
                        // 唯一key生成
                        String key = generateKey(a,b,c);
                        if(!m.containsKey(key)){
                            m.put(key,t);
                        }
                    }
                }
            }
        }

        for(Map.Entry<String,List<Integer>> entry : m.entrySet()){
            if(entry!=null){r.add(entry.getValue());}
        }
        m=null;
        return r;
    }

    private static String generateKey(int a,int b,int c){
        int[] n = new int[]{a,b,c};
        Arrays.sort(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n.length;i++){
            sb.append(n[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);

    }
}
