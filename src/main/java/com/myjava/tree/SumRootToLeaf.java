package com.myjava.tree;

import com.myjava.common.TreeNode;

public class SumRootToLeaf {

    /**
     *
     *  1022. 从根到叶的二进制数之和
     *
     *  给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     *  例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     *
     *  对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     *
     *  返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * 解题思路
     * 根据题目要求，底层的节点在最终形成的二进制数的高位。
     *
     * 同时，每个到叶节点的路径，应该形成一个二进制数。
     *
     * 由此，我们可以通过递归的方式求解，最符合题目要求的遍历方式为先序遍历。
     *
     * 因为采用先序遍历，我们可以从根节点开始，通过乘2或者左移实现二进制数到十进制数的转换，很方便。
     *
     *
     */

    int ans;
    public int sumRootToLeaf(TreeNode root) {
        //初始化 一个0 占位
        this.dfs(root,0);
        return ans;
    }
    //val 上一层
    public void dfs(TreeNode root,int val){
        if (root == null){
            return;
        }
        //前序遍历
        if (root.left == null && root.right == null){
            ans += 2*val + root.val;
        }
        // 当前 节点 及以上节点  累计和
        this.dfs(root.left,2*val + root.val);
        this.dfs(root.right,2*val + root.val);
    }


}
