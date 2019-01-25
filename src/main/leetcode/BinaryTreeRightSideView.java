package main.leetcode;

import main.bean.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {


    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = rightSideView(TreeNode.createTree(1,2,3,null,5,null,4));

        for(int x=0;x<list.size();x++){
            System.out.print(list.get(x)+" ");
        }

    }

    public static List<Integer> rightSideView(TreeNode root) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.offer(root);
        else
            return list;

        while (!queue.isEmpty()){
            int size = queue.size();
            //System.out.print("size = "+size+"  ");
            for(int x=0;x<size;x++){
                TreeNode temp = queue.poll();
                //System.out.print("temp = "+temp.val+"  ");
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
                if(x==size-1)
                    list.add(temp.val);
            }

        }


        return list;
    }

}
