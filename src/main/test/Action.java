package main.test;

public class Action<T> {

    T val;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public void move(){
        System.out.print(val);
    }
}

