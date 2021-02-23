package com.myjava.tree;

import com.myjava.common.TreeNode;

public class IsSameTree {
    /**
     *  100
     *  相同的树
     *
     *  给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *
     *  如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */

    public boolean isSameTree100(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return this.isSameTree100(p.left,q.left) && this.isSameTree100(p.right,q.right);
    }

}
