package main.leetcode;

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意:
 * 字符串长度 和 k 不会超过 104。
 *
 * 示例 1:
 *
 * 输入:
 * s = "ABAB", k = 2
 *
 * 输出:
 * 4
 *
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 * 示例 2:
 *
 * 输入:
 * s = "AABABBA", k = 1
 *
 * 输出:
 * 4
 *
 * 解释:
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */

public class LeetCode424 {

    public static void main(String[] args) {
        System.out.println(new LeetCode424().characterReplacement("AAAB",0));
    }


    int[] charSum = new int[26];

    public int characterReplacement(String s, int k) {
        int len = s.length();
        char[] ar = s.toCharArray();
        if(k>=len) {
            return len;
        }

        int max = 0;
        int sum = 0;


        char now = ar[0];
        int temp = k;
        int l = 0;
        boolean isContinue = true;

        for(int x=0;x<len;x++){

            if(temp>=0){

                if(ar[x] == now){
                    sum++;
                    if(isContinue){
                        l = x;
                    }
                }else{
                    if(temp!=0){
                        sum++;
                    }

                    isContinue = false;
                    temp--;
                }
            }else{
                System.out.println("l = "+l);
                max = Math.max(max,sum);
                isContinue = true;
                temp = k;
                x = l;
                now = ar[x+1];
                sum=0;
            }

        }
        temp = temp<0?0:temp;
        max = Math.min(Math.max(max,sum+temp),len);

        return max;
    }

}
