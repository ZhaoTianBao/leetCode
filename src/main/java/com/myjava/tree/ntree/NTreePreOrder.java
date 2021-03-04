package com.myjava.tree.ntree;

import com.myjava.common.NTreeNode;


import java.util.ArrayList;
import java.util.List;

public class NTreePreOrder {

    /**
     *
     *  589. N 叉树的前序遍历
     *
     *  给定一个 N 叉树，返回其节点值的 前序遍历 。
     *
     *  N 叉树 在输入中   按层序遍历进行序列化表示，
     *
     *  每组子节点由空值 null 分隔。
     *
     *  示例 1：
     *  1
     *  3 2 4
     *  5 6
     *
     *  方法一：迭代
     *  由于递归实现 N 叉树的前序遍历较为简单，
     *  因此我们只讲解如何使用迭代的方法得到 N 叉树的前序遍历。
     *
     *
     *
     *
     *
     *  输入：root = [1,null,3,2,4,null,5,6]
     *  输出：[1,3,5,6,2,4]
     *
     */

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(NTreeNode root){
        if (root == null){
            return list;
        }
        //先遍历根
        list.add(root.val);
        //再依次遍历孩子就完事了
        for (NTreeNode node : root.children) {
            this.preorder(node);
        }
        return list;
    }
}
