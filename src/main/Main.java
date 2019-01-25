package main;

import main.bean.ListNode;

import java.util.*;

/**
 * @author Administrator
 */

public class Main {

    public static void main(String[] args){
        ListNode head = ListNode.create(1,2,3,4,5,6,7);
        ListNode.showList(head);
        //ListNode.reverceList1(head);
        ListNode.showList(ListNode.reverceList1(head));
    }

    static boolean tempo(int[] ar,int temp){
        int start = 0;
        int end = ar.length-1;
        int mid;
        while (start<=end){
            mid = (start + end) /2;
            if(ar[mid] == temp){
                return true;
            }
            if(ar[mid] > temp){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }

        return false;
    }

    public static int duplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
