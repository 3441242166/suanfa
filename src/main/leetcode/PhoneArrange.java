package main.leetcode;


import java.util.ArrayList;
import java.util.List;

public class PhoneArrange {

    static char[][] data =new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    static List<String> list = new ArrayList<>();

    public static void main(String[]strs){
        letterCombinations("7");
    }

    public static List<String> letterCombinations(String digits) {
        char[] ar = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        search(sb,ar,0);
        return null;
    }

    public static void search(StringBuilder sb,char[] ar,int length){
        if(ar.length==length){
            list.add(sb.toString());
            System.out.println(sb);
            return;
        }

        if(getPos(ar[length])!=7&&getPos(ar[length])!=9) {
            for (int x = 0; x < 3; x++) {
                sb.append(data[getPos(ar[length])][x]);
                search(sb, ar, length + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }else {

            for (int x = 0; x < 4; x++) {
                sb.append(data[getPos(ar[length])][x]);
                search(sb, ar, length + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static int getPos(char ch){
        switch (ch){
            case '2':
                return 0;
            case '3':
                return 1;
            case '4':
                return 2;
            case '5':
                return 3;
            case '6':
                return 4;
            case '7':
                return 5;
            case '8':
                return 6;
            case '9':
                return 7;
        }
        return 0;
    }

}
