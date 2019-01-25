package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumArrange {

    public static void main(String[] ars){
        subsets(new int[]{1,2,3});
    }

    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    static List<List<Integer>> subsets(int[] nums) {

        for(int x=0;x<nums.length;x++){
            search(x+1,0,0,nums);
        }

        return lists;
    }

    static void search(int target, int pos ,int next ,int[] nums){
        if(target == pos){
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+"  ");
            }
            System.out.println();
            lists.add(list);
            return;
        }

        for(int x=next;x<nums.length;x++){
            list.add(nums[x]);
            search(target,pos+1,x+1,nums);
            list.remove(list.size()-1);
        }

    }

}