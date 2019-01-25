package main.leetcode;

public class Leetcode665 {

    public static void main(String[] args){
        System.out.println(new Leetcode665().checkPossibility(new int[]{4,2,1}));
    }


    public boolean checkPossibility(int[] nums) {
        if(nums.length<3){
            return true;
        }
        boolean isChange = false;

        for(int x=0;x<nums.length-1;x++){
            if(nums[x]>nums[x+1]){
                if(isChange){
                    return false;
                }
                isChange = true;

                if(x==0){
                    continue;
                }

                if(nums[x+1]>nums[x-1]){
                    nums[x] =nums[x-1];
                    x--;
                }else{
                    nums[x+1] = nums[x];
                }

            }
        }

        return true;
    }

}
