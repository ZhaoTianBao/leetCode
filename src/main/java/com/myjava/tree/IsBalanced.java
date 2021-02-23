package com.myjava.tree;

import com.myjava.common.TreeNode;

public class IsBalanced {

    /**
     *  110. 平衡二叉树
     *
     *  给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     *  本题中，一棵高度平衡二叉树定义为：
     *
     *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     */

    public boolean isBalanced110(TreeNode root)
    {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && this.isBalanced110(root.right)
                && this.isBalanced110(root.left);
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(this.height(root.left),this.height(root.right)) + 1;
    }
}
