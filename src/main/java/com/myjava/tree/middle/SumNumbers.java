package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

public class SumNumbers {


    /**
     *
     *   129. 求根节点到叶节点数字之和
     *
     *
     * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
     *
     * 每条从根节点到叶节点的路径都代表一个数字：
     *
     * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
     * 计算从根节点到叶节点生成的 所有数字之和 。
     *
     * 叶节点 是指没有子节点的节点。
     *
     *
     *
     * 输入：root = [1,2,3]
     * 输出：25
     * 解释：
     * 从根到叶子节点路径 1->2 代表数字 12
     * 从根到叶子节点路径 1->3 代表数字 13
     * 因此，数字总和 = 12 + 13 = 25
     *
     *
     *  前言
     * 这道题中，二叉树的每条从根节点到叶子节点的路径都代表一个数字。其实，每个节点都对应一个数字，等于其父节点对应的数字乘以 1010 再加上该节点的值（这里假设根节点的父节点对应的数字是 00）。只要计算出每个叶子节点对应的数字，然后计算所有叶子节点对应的数字之和，即可得到结果。可以通过深度优先搜索和广度优先搜索实现。
     *
     * 方法一：深度优先搜索
     * 思路与算法
     *
     * 深度优先搜索是很直观的做法。从根节点开始，遍历每个节点，如果遇到叶子节点，则将叶子节点对应的数字加到数字之和。如果当前节点不是叶子节点，则计算其子节点对应的数字，然后对子节点递归遍历。
     *
     *
     */



    public int sumNumbers(TreeNode root) {
        //目前为止 上一个节点之和
        return this.dfs(root,0);
    }

    public int dfs(TreeNode root,int prevSum){
        if (root == null){
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        //出口 单条路径结束 叶子节点为止
        if (root.left == null && root.right == null){
            return sum;
        }
        //求和 所有路径之和
        return this.dfs(root.left,sum) + this.dfs(root.right,sum);
    }



}
