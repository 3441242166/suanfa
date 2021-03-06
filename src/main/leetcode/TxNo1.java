package main.leetcode;

import java.util.Arrays;

/**
 * 给你 10 分钟时间，根据上排给出十个数，在其下排填出对应的十个数 要求下排每个数都是先前上排那十个数在下排出现的次数。 
 * 上排的十个数如下： 【0，1，2，3，4，5，6，7，8，9】 
 * 举一个例子， 数值: 0,1,2,3,4,5,6,7,8,9 
 *            分配: 6,2,1,0,0,0,1,0,0,0 
 * 0 在下排出现了 6 次，1 在下排出现了 2 次， 2 在下排出现了 1 次，3 在下排出现了 0 次.... 
 * 以此类推..
 */

public class TxNo1 {
    
    
    public static void main(String[] args){
        solve(new int[]{0,1,2,3,4,5,6,7,8});
    }
    
    
    static void solve(int[] ar){
        int[] statistic = new int[ar.length];
        Arrays.fill(statistic,0);
        dfs(ar,0,statistic,0);
    }
    
    
    static void dfs(int[] ar,int times,int[] statistic,int sum){
        
        if(times == ar.length){
            if(sum == ar.length){
                for(int num:statistic) {
                    System.out.print(num + "  ");
                }
                System.out.println();
            }

            return;
        }
        
        for(int x=0;x<ar.length;x++){
            
            statistic[ar[x]]++;
            dfs(ar,times+1,statistic,sum+ar[x]);
            statistic[ar[x]]++;
            
        }
        
    }
    
}
