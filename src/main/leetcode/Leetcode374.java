package main.leetcode;

import main.bean.TreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */

public class Leetcode374 {


    public List<Integer> topKFrequent(int[] nums, int k) {
        if(k>nums.length){
            return null;
        }


        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        List<Integer>[] bucket = new List[nums.length+1];

        for(int x=0;x<nums.length;x++){
            if(map.containsKey(nums[x])){
                map.put(nums[x],map.get(nums[x])+1);
            }else{
                map.put(nums[x],1);
            }
        }

        for(int key:map.keySet()){
            int sum  = map.get(key);
            if(bucket[sum] == null){
                bucket[sum] = new ArrayList<>();
            }
            bucket[sum].add(key);
        }

        List<Integer> list = new ArrayList<>(k);

        for(int x=bucket.length-1;x>=0 && k>0;x--){
            if(bucket[x]!=null) {
                list.addAll(bucket[x]);
                k-=bucket[x].size();
            }
        }

        return list;
    }

}
