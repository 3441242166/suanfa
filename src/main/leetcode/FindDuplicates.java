package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

 找到所有出现两次的元素。

 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

 示例：

 输入:
 [4,3,2,7,8,2,3,1]

 输出:
 [2,3]
 */


public class FindDuplicates {


    public static void main(String[] strs){
        List list = findDuplicates(new int[]{4,3,2,7,8,2,3,1});

        for(int x=0;x<list.size();x++){
            System.out.println(list.get(x)+"  .");
        }
    }


    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();



        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            System.out.println(index+" ");
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            //标志位负数 表示该位置已经出现过了
            nums[index] = -nums[index];

        }

        return res;
    }

}
