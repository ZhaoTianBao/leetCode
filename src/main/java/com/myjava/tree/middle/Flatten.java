package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
    /**
     *
     * 114. 二叉树展开为链表
     *
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，
     *
     * 其中 right 子指针指向链表中下一个结点，
     *
     * 而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     *
     *  输入：root = [1,2,5,3,4,null,6]
     *  输出：[1,null,2,null,3,null,4,null,5,null,6]
     *
     *
     *  方法一：前序遍历
     * 将二叉树展开为单链表之后，单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序。
     *
     * 因此，可以对二叉树进行前序遍历，获得各节点被访问到的顺序。
     *
     * 由于将二叉树展开为链表之后会破坏二叉树的结构，
     *
     * 因此在前序遍历结束之后更新每个节点的左右子节点的信息，将二叉树展开为单链表。
     *
     *
     *
     *
     */

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        this.preOrderDfs(root,list);
        for (int i = 1; i < list.size(); i++) {
            //声明两个,一个是头部指针
            TreeNode pre = list.get(i-1),cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }

    //前序遍历 根左右
    public void preOrderDfs(TreeNode root,List<TreeNode> list){
        if (root != null){
            list.add(root);
            this.preOrderDfs(root.left,list);
            this.preOrderDfs(root.right,list);
        }

    }

}
