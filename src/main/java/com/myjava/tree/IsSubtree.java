package com.myjava.tree;

import com.myjava.common.TreeNode;

public class IsSubtree {

    /**
     *
     *  572. 另一个树的子树
     *  给定两个非空二叉树 s 和 t，
     *
     *  检验 s 中是否包含和 t 具有相同结构和节点值的子树。
     *
     *  s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     *
     * 看到题目描述，首先判断一个树是否是另一棵树的子树，很明显想到可以用递归，
     *
     * 但是两棵树完全相同也可以看做一棵树是另一棵树的子树。
     * 1 t在s左子树上
     * 2 t在s右子树上
     * 3 t和s相同
     *
     * 所以自然而然想到用一个判断两棵树是否相同的递归函数。
     * 然后就上代码吧~~
     *
     *
     *
     *
     *
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // t 为null 返回 true
        if (t == null){
            return true;
        }
        // t 不为null  s为null 返回false
        if (s == null){
            return false;
        }
        // t在s左子树上 , t在s右子树上 , t和s相同
        return this.isSubtree(s.left,t) || this.isSubtree(s.right,t) || this.isSameTree(s,t);
    }


    /**
     * 判断 2个树 是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.val != t.val){
            return false;
        }
        return this.isSameTree(s.left,t.left) && this.isSameTree(s.right,t.right);
    }






}
