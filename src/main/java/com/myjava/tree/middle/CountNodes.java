package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

public class CountNodes {


    /**
     *
     *  222. 完全二叉树的节点个数
     *
     *  给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *
     *  完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
     *
     *  其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
     *
     *  若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     *
     *
     *  完全二叉树,只有最后一层节点是非满二叉树
     *
     *
     *  年轻人耗子尾汁，少用暴力法解题，不要欺负老题目
     *
     *
     *  完全二叉树
     *  除了最底层节点,其他层都是满的
     *
     *  首先需要明确完全二叉树的定义：它是一棵空树或者它的叶子节点只出在最后两层，
     *  若最后一层不满则叶子节点只在最左侧。
     *
     *
     * 再来回顾一下满二叉的节点个数怎么计算，如果满二叉树的层数为h，则总节点数为：2^h - 1.
     * 那么我们来对 root 节点的左右子树进行高度统计，分别记为 left 和 right，有以下两种结果：
     *
     * left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
     * left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找。
     *
     *
     *
     */

    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        //当前层left         root.left 下一层
        if (left == right){
            //满二叉树 左树高 = 右树高
            return countNodes(root.right) + (1<<right);
        }else{
            //非满树,左子树 一定是满的
            return countNodes(root.left) + (1<<right);

        }
    }



    //计算完全二叉树高度  因为左子树是满的
    public int countLevel(TreeNode root){
        int level = 0;
        while (root != null){
            level++;
            root = root.left;
        }
        return level;
    }


}
