package main.leetcode;

public class ComplexNumberMultiply {



    public static void main(String[] args){

    }

    public String complexNumberMultiply(String a, String b) {

        FuShu f1 = new FuShu(a);
        FuShu f2 = new FuShu(b);



        return f1.think(f1,f2).toString();
    }


    static class FuShu{
        int first;
        int last;
        public FuShu(String str){

        }

        @Override
        public String toString(){
            return null;
        }

        public FuShu think(FuShu a,FuShu b){
            return null;
        }
    }

}
