package com.myjava.tree;

import com.myjava.common.TreeNode;

public class DiameterOfBinaryTree {

    /**
     *
     *  543. 二叉树的直径
     *
     *
     *  给定一棵二叉树，你需要计算它的直径长度。
     *
     *
     *  一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     *  这条路径可能穿过也可能不穿过根结点。
     *
     *  穿过根节点的是最大的
     *
     *          1
     *          / \
     *         2   3
     *        / \
     *       4   5
     *  返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     *  注意：两结点之间的路径长度是以它们之间边的数目表示。
     *
     *
     *  方法一：深度优先搜索
     *
     *  首先我们知道一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
     *
     *  因为二叉树，子节点没法找父节点信息
     *  而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径（深度）拼接得到。
     *  深度，为当前节点的层数 一个点深度就是1
     *  一个节点  =  左右子节点深度max+1
     *
     *
     *  2叶子节点路径长度 = 该根节点 左子树深度 + 右子树深度
     *  深度优先搜索
     *
     *  末尾 ， 没孩子 叶子节点的深度 是 1   没儿子节点，儿子节点是0，该节点是1
     *
     *  一个节点 深度  下面有基层节点 + 1
     *  dept = max(left,right)+1
     *
     *
     */


    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.getDep(root);
        return max;
    }

    //获取深度
    public int getDep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = this.getDep(root.left);
        int right = this.getDep(root.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        max = Math.max(left + right,max);
        //返回节点深度
        return Math.max(left,right) + 1;
    }
}
