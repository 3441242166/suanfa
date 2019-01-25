package main.leetcode;

import java.util.*;

public class PartitionLabels {


    public static void main(String[] strs){
        List list = partitionLabels("ababcbacadefegdehijhklij");

        for(int x=0;x<list.size();x++){
            System.out.println(list.get(x)+"  .");
        }
    }


    public static List<Integer> partitionLabels(String S) {
        char[] ar = S.toCharArray();
        List<Integer> list = new ArrayList<>();

        int begin = 0;
        //保存每个字符最后一次出现的位置
        Map<Character,Integer> map = new HashMap<>(ar.length);
        for(int x=0;x<ar.length;x++){
            map.put(ar[x],x);
        }


        while(begin<ar.length){

            int end = map.get(ar[begin]);
            for(int x=begin;x<end;x++){
                //如果不包含 并且 在范围内
                if(x<end){
                    end = Math.max(end,map.get(ar[x]));
                }

            }
            list.add(end-begin+1);
            begin = end+1;

        }

        return list;
    }
}
