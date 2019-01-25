package main.leetcode;
/*
    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
 */

public class LandSum {

    public static void main(String[] strs){
        char[][] ar = new char[][]{
                {'1','1','1','0','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','1'}};

        System.out.println(numIslands(ar));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] is = new boolean[grid.length][grid[0].length];
        Integer sum = 0;

        for(int x=0;x<grid.length;x++){
            for(int y=0;y<grid[0].length;y++){

                if(grid[x][y] == '1' && !is[x][y]){
                    search(grid,is,x,y);
                    sum++;
                }

            }
        }

        return sum;
    }

    public static void search(char[][] grid,boolean[][] is,int x,int y){
        if(is[x][y] || grid[x][y]=='0'){
            return;
        }else{
            is[x][y] = true;
            if(x-1>=0){
                search(grid,is,x-1,y);
            }
            if(x+1<grid.length){
                search(grid,is,x+1,y);
            }
            if(y-1>=0){
                search(grid,is,x,y-1);
            }
            if(y+1<grid[0].length){
                search(grid,is,x,y+1);
            }
        }
    }

}
