package main.leetcode;

public class Leetcode925 {

    public static void main(String[] args) {
        isLongPressedName("alex","aaleex");
    }


    public static boolean isLongPressedName(String name, String typed) {
        int i =0;
        int j =0;

        while(j<typed.length()){
            if(i == name.length()){
                return true;
            }

            System.out.println(" "+name.charAt(i)+"  "+typed.charAt(j));

            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }

        }

        if(i == name.length()){
            return true;
        }

        return false;
    }
}
