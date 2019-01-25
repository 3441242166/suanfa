package main.leetcode;

import main.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * 输出：[7,4,1]
 *
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *
 * 提示：
 *
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 * @author Administrator
 */
public class LeetCode863 {


    public static void main(String[] args){

    }


    List<Integer> answer = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root,target,K);
        return answer;
    }


    int dfs(TreeNode root,TreeNode target,int sum){
       if(root == null){
           return -1;
       }

       if(root.val == target.val){
           search(root,sum);
           return 1;
       }

       boolean isRight;
       int left = dfs(root.left,target,sum);
       int right = dfs(root.right,target,sum);

       int max;
       if( left > right){
           max = left;
           isRight = false;
       }else {
           max = right;
           isRight = true;
       }


       if(max == -1){
           return -1;
       }else {
           if(max == sum){
               answer.add(root.val);
               return -1;
           }

           if(isRight){
               search(root.left,sum-max-1);
           }else {
               search(root.right,sum-max-1);
           }

           return max+1;
       }

    }


    void search(TreeNode node,int sum){
        if(node == null){
            return;
        }

        if(sum == 0){
            answer.add(node.val);
            return;
        }

        search(node.left,sum-1);
        search(node.right,sum-1);

    }

}
