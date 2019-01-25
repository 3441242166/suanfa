package main.leetcode;

import java.util.Arrays;

public class FenLei {


    public static void main(String[] args){

        int[] ar = new int[]{5,2,9,1,5,8,8,3,5};
        sort(ar,5);
        System.out.println(Arrays.toString(ar));

    }

    public static void sort(int[] ar,int num){
        int left = -1;
        int right = ar.length;

        for(int x=0;x<right;x++){
            if(ar[x]>num){
                swep(ar,--right,x--);
            }else if (ar[x]<num){
                swep(ar,++left,x);
            }
        }

    }


    static void swep(int[] ar,int x,int y){
        int temp = ar[x];
        ar[x] = ar[y];
        ar[y] = temp;
    }
}
