package com.myjava.tree;

import com.myjava.common.TreeNode;

public class MinDepth {


    /**
     *
     * 111. 二叉树的最小深度
     *
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     *  !!!!!  说明：叶子节点是指没有子节点的节点。
     *
     *  叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     *
     *  //一旦 一个子树为空，那么 Math.min 就返回 0 了 就算不了了
     */


    public int minDepth111(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return this.minDepth111(root.right) + 1;
        }
        if(root.right == null){
            return this.minDepth111(root.left) + 1;
        }
        return Math.min(this.minDepth111(root.left),this.minDepth111(root.right)) + 1;
    }


}
