package com.myjava.tree;

import com.myjava.common.TreeNode;

public class SumOfLeftLeaves {
    /**
     *
     *
     * 404. 左叶子之和
     *
     *
     * 计算给定二叉树的所有左叶子之和。
     *
     *
     * 判断左叶子的条件：通过当前节点的父节点进行判断。
     * 如果父节点的左节点不为空，且这个左节点没有左右孩子，那么这个节点就是左叶子。
     *
     *
     */




    public int sumOfLeftLeaves(TreeNode root){
        if (root == null){
            return 0;
        }
        //记录左叶子节点的值
        int leftNum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            leftNum = root.left.val;
        }
        return leftNum + this.sumOfLeftLeaves(root.left) + this.sumOfLeftLeaves(root.right);
    }
}
