package main.book;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args){
        System.out.println(Arrays.toString(getNext("abcaby")));
        System.out.println(KMP("abxabcabcaby","xabcabcaby"));
    }


    static int[] getNext(String str){
        int len = str.length();
        int[] next = new int[len];
        char[] ar = str.toCharArray();

        int low = 0;
        int sum = 0;

        for(int fast = 1;fast<len;fast++){
            if(ar[low] == ar[fast]){
                next[fast] = ++sum;
                low++;
            }else {
                if(low - 1 <0){
                    next[fast] = 0;
                    sum = 0;
                    continue;
                }

                low = next[low-1];
                sum = next[low];
                fast--;

            }

        }
        return next;
    }

    static int KMP(String parent,String child){
        int len  = parent.length();
        int pos = 0;
        int[] next = getNext(child);
        char[] par = parent.toCharArray();
        char[] car = child.toCharArray();

        int low = 0;
        int sum = 0;

        for(int fast = 0;fast<len;fast++){

            if(par[fast] == car[low]){
                low++;
                sum++;

                if(sum == child.length()){
                    return pos;
                }

            }else {
                if(low-1<0){
                    pos = fast+1;
                    sum = 0;
                    continue;
                }
                low = next[low-1];
                sum = low;
                pos += low+1;

                fast--;
            }

        }

        return -1;
    }

}
