package main.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SlidingPuzzle {

    public static void main(String[] args){

    }

    public int slidingPuzzle(int[][] board) throws InterruptedException {
        int[][] answer = new int[][]{
                {1,2,3},
                {4,5,0}
        };

        Set<int[][]> set = new HashSet<>();

        LinkedBlockingQueue<int[][]> queue = new LinkedBlockingQueue<>();
        queue.put(board);
        int pace = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int x=0;x<size;x++){
                int[][] temp = queue.poll();
                int posX = 0;
                int posY = 0;

            }
        }


        return 0;
    }


}
