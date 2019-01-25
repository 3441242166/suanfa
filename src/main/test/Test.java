package main.test;

public class Test {



    public static void main(String[] args){
        Action<? super People> action = new Action<>();

        action.setVal(new Student());

        Object obj = action.getVal();
    }

}
