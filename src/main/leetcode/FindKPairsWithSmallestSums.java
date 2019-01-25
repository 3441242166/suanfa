package main.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 给出： nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 *
 * 返回： [1,2],[1,4],[1,6]
 *
 * 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 给出：nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 *
 * 返回： [1,1],[1,1]
 *
 * 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 给出：nums1 = [1,2], nums2 = [3],  k = 3
 *
 * 返回： [1,3],[2,3]
 *
 * 也可能序列中所有的数对都被返回:
 * [1,3],[2,3]
 */

public class FindKPairsWithSmallestSums {

    public static void main(String[] args){
        int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};

        kSmallestPairs(nums1,nums2,3);
    }


    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new LinkedList<>();

        list.add(new int[]{nums1[0],nums2[0]});

        int s1,s2;


        for(int x=0;x<k;x++){


        }

        return list;
    }


}
