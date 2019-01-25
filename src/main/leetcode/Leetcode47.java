package main.leetcode;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

public class Leetcode47 {

    public static void main(String[] args) {
        new Leetcode47().permuteUnique(new int[]{1, 1, 1});
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //Arrays.sort(nums);

        dfs(nums, 0);

        return lists;

    }

    void dfs(int[] nums, int len) {
        if (len == nums.length - 1) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int num : nums) {
                System.out.print("  " + num);
            }
            System.out.println();
            for (int x = 0; x < nums.length; x++) {
                temp.add(nums[x]);
            }
            lists.add(temp);
            return;
        }

        for (int x = len; x < nums.length; x++) {
            if (check(nums, len, x - 1, x)) {
                swep(nums, len, x);
                dfs(nums, len + 1);
                swep(nums, len, x);
            }
        }


    }

    void swep(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    boolean check(int[] nums, int strat, int end, int target) {


        return false;
    }

}
