package main.leetcode;

public class WordSearch {


    public static void main(String[] args){
        char[][] board = new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        System.out.print(exist(board,"abcb"));
    }

    static boolean[][] is;

    static boolean exist(char[][] board, String word) {

        is = new boolean[board.length][board[0].length];
        char[] str = word.toCharArray();


        for(int x=0;x<board.length;x++){
            for(int y=0;y<board[0].length;y++){

                if(search(board,x,y,str,0)){
                    return true;
                }

            }
        }

        return false;
    }

    static boolean search(char[][] board,int posX,int posY,char[] str,int pos){
        if(posX>=board.length || posX<0 || posY>=board[0].length ||posY<0 || is[posX][posY] ){
            return false;
        }
        if(!(board[posX][posY] == str[pos])){
            return false;
        }
        if(pos == str.length-1){
            return true;
        }


        is[posX][posY] = true;
        if(search(board,posX,posY+1,str,pos+1)){
            return true;
        }
        if(search(board,posX,posY-1,str,pos+1)){
            return true;
        }
        if(search(board,posX+1,posY,str,pos+1)){
            return true;
        }
        if(search(board,posX-1,posY,str,pos+1)){
            return true;
        }
        is[posX][posY] = false;
        return false;
    }
}
