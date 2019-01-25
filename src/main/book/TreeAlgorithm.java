package main.book;

import main.bean.TreeNode;

import java.util.*;

public class TreeAlgorithm {

    public static void main(String[] args){
        TreeNode node = TreeNode.createTree(1,3,3,4,5,5,4);
        cenScan(node);
        System.out.println(mirrorTree(node));
    }

    /**
     * @param node 头节点
     * @descriptoin  非递归先序遍历
     */
    public static void frontScan(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.push(node);

        while (!stack.isEmpty()){

            TreeNode temp = stack.poll();
            System.out.println(temp.val);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

        }


}
    /**
     * @param node 头节点
     * @descriptoin  非递归中序遍历
     */
    public static void centerScan(TreeNode node){

        LinkedList<TreeNode> stack = new LinkedList<>();

        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.print(" "+node.val);
                node = node.right;
            }
        }
    }
    /**
     * @param node 头节点
     * @descriptoin  非递归后序遍历
     */
    public static void lastScan(TreeNode node){
        LinkedList<TreeNode> stack = new LinkedList<>();



    }
    /**
     * @param node 头节点
     * @descriptoin  层次遍历
     */
    public static void cenScan(TreeNode node){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        TreeNode temp;

        while (!queue.isEmpty()){
            int len = queue.size();

            for(int x=0;x<len;x++){
                temp = queue.poll();
                System.out.print("  "+temp.val);
                if(temp.left!=null) {
                    queue.add(temp.left);
                }
                if(temp.right!=null) {
                    queue.add(temp.right);
                }
            }
            System.out.println();
        }
    }
    /**
     * 二叉树最大宽度
     * 输入:
     *
     *           1
     *          / \
     *         3   2
     *        /     \
     *       5       9
     *      /         \
     *     6           7
     * 输出: 8
     * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
     */
    static int max = 1;
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int maxCen = 0;
    public static int widthOfBinaryTree(TreeNode root) {
        dfs(root,1,1);
        return max;
    }

    /**
     * @param root  传入的节点
     * @param cen   层
     */
    private static void dfs(TreeNode root,int cen,int pos) {
        if(null == root){
            return;
        }

        if(cen>maxCen){
            maxCen = cen;
            map.put(cen,pos);
        }else {
            int dif = pos - map.get(cen) + 1;
            if(dif>max){
                max = dif;
            }
        }

        dfs(root.left,cen+1,pos*2-1);
        dfs(root.right,cen+1,pos*2);

    }

    /**
     * 判断俩个二叉树是否对称
     */

    private static boolean mirrorTree(TreeNode node){
        if(node == null){
            return true;
        }
        return mirrorDfs(node.left,node.right);
    }
    /**
     * 判断俩个二叉树是否对称
     */

    private static boolean mirrorDfs(TreeNode left,TreeNode right){

        if(left == null && right == null){
            return true;
        }
        if(left == null || right==null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        return mirrorDfs(left.left, right.right) && mirrorDfs(left.right,right.left);
    }

    /**
     *  给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     */

    private static boolean hasPathSum(TreeNode root, int sum){
        if(sum < 0){
            return false;
        }
        if(sum == 0){
            return true;
        }

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

}

