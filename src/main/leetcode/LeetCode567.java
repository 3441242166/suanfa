package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode567 {

    public static void main(String[] args) {
        System.out.println(new LeetCode567().checkInclusion("algorithm","altruistic"));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();

        char[] temp = s1.toCharArray();
        char[] str = s2.toCharArray();

        for(char c:temp){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }

        int start = -1;
        int end = -1;

        for(int x=0;x<str.length;x++){

            if(map.containsKey(str[x])){

                if(map.get(str[x])>0){

                    if(start == -1){
                        start = x;
                    }
                    end = x;

                    map.put(str[x],map.get(str[x])-1);

                    if(check(map)){
                        return true;
                    }

                }else {
                    map.put(str[start],map.get(str[start])+1);
                    start++;
                    x--;

                }

            }else {
                if(start == -1){
                    continue;
                }

                for(int y = start;y<=end;y++){
                    map.put(str[y],map.get(str[y])+1);
                }

                start = -1;
                end = -1;
            }

        }

        return false;

    }

    boolean check(Map<Character,Integer> map){
        for(Character c:map.keySet()){
            if(map.get(c)!=0){
                return false;
            }
        }
        return true;
    }


}
