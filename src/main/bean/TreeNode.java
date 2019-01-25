package main.bean;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }

    /**
     * 生成二叉树
     * @param data
     * @return
     */
    public static TreeNode createTree(Integer ...data){
        TreeNode[] ar = new TreeNode[data.length];
        for(int x=0;x<ar.length;x++){
            if(data[x] ==null) {
                ar[x] = null;
            } else {
                ar[x] = new TreeNode(data[x]);
            }
        }

        for(int x=0;x<ar.length;x++){
            if(ar[x]==null){
                continue;
            }
            if(2*x+1<ar.length){
                ar[x].left = ar[2*x+1];
            }else {
                ar[x].left = null;
            }
            if(2*x+2<ar.length){
                ar[x].right = ar[x*2+2];
            }else {
                ar[x].right = null;
            }
        }

        return ar[0];
    }

}
