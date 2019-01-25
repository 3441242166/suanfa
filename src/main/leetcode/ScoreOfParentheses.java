package main.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ScoreOfParentheses {



    public static void main(String[] args){

    }


    public static String findLongestWord(String s, List<String> d) {

        char[] str = s.toCharArray();

        int max = -1;
        int pos = -1;

        for(int x=0;x<d.size();x++){
            char[] temp = d.get(x).toCharArray();

            for(int y=0,z=0;y<str.length;){
                if(z == temp.length){
                    if(temp.length>max){
                        max = temp.length;
                        pos = y;
                    }
                    break;
                }

                if(temp[z]==str[y]){
                    y++;
                    z++;
                }else{
                    y++;
                }
            }

        }
        return pos==-1?"":d.get(pos);

    }

}
