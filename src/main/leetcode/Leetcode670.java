package main.leetcode;

import java.util.Arrays;

import static main.Util.showAr;

/**
 *
 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

 示例 1 :

 输入: 2736
 输出: 7236
 解释: 交换数字2和数字7。
 示例 2 :

 输入: 9973
 输出: 9973
 解释: 不需要交换。
 注意:

 给定数字的范围是 [0, 108]
 */

public class Leetcode670 {

    public static void main(String[] args) {
        System.out.println(new Leetcode670().maximumSwap(1234));
    }


    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] tempAr = numStr.toCharArray();
        int len = tempAr.length;
        int[] nums = new int[len];
        int[] sortNums = new int[len];
        for(int x=0;x<len;x++){
            nums[x] = tempAr[x]-48;
            sortNums[x] = tempAr[x]-48;
        }
        Arrays.sort(sortNums);
        for(int x=0;x<len/2;x++){
            int temp = sortNums[x];
            sortNums[x] = sortNums[len-x-1];
            sortNums[len-x-1] = temp;
        }
        showAr(nums);
        showAr(sortNums);

        int start = 0;
        for(int x=0;x<len;x++){
            if(nums[x]!=sortNums[x]){
                break;
            }
            start++;
        }


        if(start == len){
            return num;
        }

        int lastMaxPos = start;
        int max = nums[start];
        for(int x=start;x<len;x++){
            if(nums[x]>=max){
                lastMaxPos = x;
                max = nums[x];
            }
        }
        int swepPos = start;
        for(int x=start;x<len;x++){
            if(nums[x]<max){
                swepPos = x;
                break;
            }
        }

        int temp = nums[lastMaxPos];
        nums[lastMaxPos] = nums[swepPos];
        nums[swepPos] = temp;

        int sum = 0;
        int chen = 1;
        for(int x=len-1;x>=0;x--){
            sum+=nums[x]*chen;
            chen *=10;
        }

        return sum;
    }
}
