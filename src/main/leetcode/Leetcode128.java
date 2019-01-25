package main.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class Leetcode128 {

    public static void main(String[] args){
        int[] ar = new int[]{0,3,7,2,5,8,4,6,0,1};
        new Leetcode128().longestConsecutive(ar);
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>(nums.length);

        boolean up;
        boolean down;
        int temp = 1;
        int max = 1;

        for(int num:nums){

            if(map.containsKey(num)){
                continue;
            }else {
                up = map.containsKey(num+1);
                down = map.containsKey(num-1);

                if(up&&down){
                    temp = map.get(num+1)+map.get(num-1)+1;
                    map.put(num,temp);
                    map.put(num+1,temp);
                    map.put(num-1,temp);
                }else if(!up&&!down){
                    map.put(num,1);
                }else if(up){
                    temp = map.get(num+1)+1;
                    map.put(num+1,temp);
                    map.put(num,temp);
                }else {
                    temp = map.get(num-1)+1;
                    map.put(num-1,temp);
                    map.put(num,temp);
                }

            }

            max = Math.max(temp,max);
        }


        return max;

//        if(nums.length ==0){
//            return 0;
//        }
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int max = 1;
//        for(int x=0;x<nums.length;x++){
//            if(map.containsKey(nums[x])){
//                continue;
//            }else{
//                if(map.containsKey(nums[x]-1)){
//                    map.put(nums[x],map.get(nums[x]-1)+1);
//                }else{
//                    map.put(nums[x],1);
//                }
//                int left = map.containsKey(nums[x]-1)?map.get(nums[x]-1):0;
//                int right = map.containsKey(nums[x]+1)?map.get(nums[x]+1):0;
//                int sum = left+right+1;
//                max = sum>max?sum:max;
//                map.put(nums[x],sum);
//                map.put(nums[x]+right,sum);
//                map.put(nums[x]-left,sum);
//            }
//        }
//
//
//        return max;
    }

    public int maximalSquare(char[][] matrix) {
        int h = matrix.length;
        if(h == 0){
            return 0;
        }
        int w = matrix[0].length;

        int[][] dp = new int[h+1][w+1];

        for(int x=1;x<h+1;x++){
            for(int y=1;y<w+1;y++){

                if(matrix[x-1][y-1]=='0'){
                    dp[x][y] = 0;
                }else {
                    dp[x][y] = Math.min(Math.min(dp[x-1][y],dp[x-1][y-1]),dp[x][y-1])+1;
                }

            }
        }

        return dp[h][w];
    }
}
