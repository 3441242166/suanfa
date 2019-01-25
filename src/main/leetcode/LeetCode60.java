package main.leetcode;

public class LeetCode60 {

    public static void main(String[] args) {
        System.out.println(new LeetCode60().getPermutation(3,3));
    }


    StringBuffer sb = new StringBuffer();
    int[] data;

    public String getPermutation(int n, int k) {
        int sum = getSum(n);
        System.out.println("sum = "+sum);
        boolean[] is = new boolean[n];

        dfs(k,sum,is);

        return sb.toString();
    }



    void dfs(int k,int sum,boolean[] is){
        int temp = 0;



    }

    int getSum(int n){
        int sum = 1;
        for(int x=1;x<=n;x++){
            sum*=x;
        }
        return sum;
    }

}
