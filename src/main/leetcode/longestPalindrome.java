package main.leetcode;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */

/*
    dp[i][j] 表示第i到j是否为回文
 */
public class longestPalindrome {

    public static String longString(String str){
        char[] ar = str.toCharArray();

        boolean dp[][] = new boolean[ar.length][ar.length];

        for(int x=0;x<ar.length;x++){
            // 斜着遍历数组
            int xx = x;
            for(int y=0;xx<ar.length;y++,xx++){
                if(xx==y){
                    //位置相同为true
                    dp[xx][y] = true;
                }else{
                    if(ar[xx] == ar[y]){
                        //位置相邻为true
                        if(ab(y-xx) == 1){
                            dp[xx][y] = true;
                        }else {
                            //不相邻判断左上角第一个
                            dp[xx][y] = dp[xx-1][y+1]?true:false;
                        }
                    }else{
                        //位置和值不相同
                        dp[xx][y] = false;
                    }
                }
            }
        }

        for(int x=0;x<ar.length;x++){
            for(int y=0;y<ar.length;y++){
                System.out.print(dp[x][y]+"  ");
            }
            System.out.println();
        }
        //根据dp得出数组 找到最长的字串
        return getString(dp,str);
    }

    static String getString(boolean[][] dp,String str){
        int start = 0;
        int len = 0;
        for(int x=0;x<dp.length;x++){
            for(int y=0;y<dp.length;y++){

                if(dp[x][y] && ab(x-y)>len){
                    len = ab(x-y);
                    start = y;
                }

            }
        }
        System.out.println(start + "   " + len);
        return str.substring(start,start+len+1);
    }

    static int ab(int x){
        return x>0?x:-x;
    }

}
