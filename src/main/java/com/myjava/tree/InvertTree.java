package com.myjava.tree;

import com.myjava.common.TreeNode;

public class InvertTree {


    /**
     *  226. 翻转二叉树
     *
     *  自顶向下
     *  自底向上
     *  道理是一样的
     *  只是编程风格差异
     *
     *
     *  递归
     *  这是一道很经典的二叉树问题。显然，我们从根节点开始，递归地对树进行遍历，并从叶子结点先开始翻转。如果当前遍历到的节点 \textit{root}root 的左右两棵子树都已经翻转，那么我们只需要交换两棵子树的位置，即可完成以 \textit{root}root 为根节点的整棵子树的翻转。
     *
     *
     */

    public TreeNode invertTree(TreeNode root){
        //递归出口
        if (root == null){
            return null;
        }
        //保存两个子树
        TreeNode left = this.invertTree(root.left);
        TreeNode right = this.invertTree(root.right);
        //交换
        root.left = right;
        root.right = left;
        return root;
    }
}
