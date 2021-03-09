package com.myjava.tree.low;

import com.myjava.common.TreeNode;

public class SearchBST {

    /**
     *  700. 二叉搜索树中的搜索
     *
     *  给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
     *
     *  返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     *
     *  例如，
     *
     *  给定二叉搜索树:
     *
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     *
     *  和值: 2
     *  你应该返回如下子树:
     *
     *       2
     *      / \
     *     1   3
     *  在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
     *
     *
     *  解题思路
     * 欢迎大家关注，我会持续更新刷题题解，希望对大家有所帮助！
     *
     * 此题考查的是二叉树知识内容里的搜索二叉树基本操作。
     * 搜索二叉树是一个有序树：
     * ·若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值。
     * ·若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值。
     * ·它的左、右子树也分别为二叉搜索树。
     *
     * 本题可用方法：递归法、迭代法。
     *
     *
     *  我用递归法
     *
     *  二叉搜索树
     *
     *  二叉搜索树是一棵二叉树，每个节点都有以下特性：
     *
     *  大于左子树上任意一个节点的值，
     *
     *  小于右子树上任意一个节点的值。
     *
     *
     *  递归实现非常简单：
     *
     * 如果根节点为空 root == null 或者根节点的值等于搜索值 val == root.val，返回根节点。
     *
     * 如果 val < root.val，进入根节点的左子树查找 searchBST(root.left, val)。
     *
     * 如果 val > root.val，进入根节点的右子树查找 searchBST(root.right, val)。
     *
     * 返回根节点。
     *
     * 树是理解递归最好的题目。
     * 迭代方法破坏了树结构，只能查一次
     * 二叉搜索树就是一个二分的过程
     *
     */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return root;
        }
        if (root.val == val){
            return root;
        }
        //val一个值，二分，不用搜索全部左右子树
        return val < root.val ? this.searchBST(root.left,val) : this.searchBST(root.right,val);
    }


}
