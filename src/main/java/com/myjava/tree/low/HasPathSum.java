package com.myjava.tree.low;

import com.myjava.common.TreeNode;

public class HasPathSum {

    /**
     * 112. 路径总和
     *
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     *
     *  从根节点开始，每当遇到一个节点的时候，从目标值里扣除节点值，
     *  一直到叶子节点判断目标值是不是被扣完。
     *
     *  其实，做为树的递归题目是非常有套路可循的，因为树有两个分支，所以在递归里也有两个分支，一般是通过 递归 A（||，&&）递归 B 来实现分支的。只要明白了这一点，递归函数就不会很难设计。
     *
     *
     *
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return this.nodeAdd(root,0,targetSum);
    }


    public boolean nodeAdd(TreeNode root, int curr, int sum){
        //终止条件
        if (root == null){
            return false;
        }
        curr = curr + root.val;
        if (root.left == null && root.right == null){
            return curr == sum;
        }
        return this.nodeAdd(root.left,curr,sum) || this.nodeAdd(root.right,curr,sum);
    }



}
