package main.leetcode;

/**
 * 917. 仅仅反转字母
 * 题目难度 Easy
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */

public class LeetCode917 {

    public static void main(String[] args) {
        System.out.println(new LeetCode917().reverseOnlyLetters("ab-cd"));
    }

    public String reverseOnlyLetters(String S) {

        int len = S.length();
        int fPos = 0;
        int lPos = len-1;
        char[] ar = S.toCharArray();

        while(fPos<lPos){

            while(!isOk(ar[fPos]) && fPos!=lPos){
                fPos++;
            }

            while(!isOk(ar[lPos]) && fPos!=lPos){
                lPos--;
            }

            swep(ar,fPos++,lPos--);

        }

        return new String(ar);
    }


    void swep(char[] ar,int x,int y){
        char temp = ar[x];
        ar[x]  = ar[y];
        ar[y] = temp;
    }


    boolean isOk(char ch){
        return (ch>='a' && ch<='z') || (ch>='A' && ch<='Z');
    }
}
