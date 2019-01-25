package main.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode918 {

    public static void main(String[] args) {
        System.out.println(new LeetCode918().maxSubarraySumCircular(new int[]{1,-2,3,1}));
    }

    public int maxSubarraySumCircular(int[] A) {
        int[] ar = new int[A.length*2];
        for(int x=0;x<ar.length;x++){
            ar[x] = A[x%A.length];
        }

        List<Integer> list = new LinkedList<>();

        int max = ar[0];
        int sum = 0;
        for(int x=0;x<ar.length;x++){

            if(max<ar[x]){
                max = ar[x];
            }

            //---------------------------------------
            if(ar[x]>=0){
                sum+=ar[x];
            }else{
                if(sum!=0){
                    list.add(sum);
                    sum=0;
                }
            }

        }
        list.add(sum);

        for(int val :list){
            if(max<val){
                max = val;
            }
        }

        return max;
    }

}
