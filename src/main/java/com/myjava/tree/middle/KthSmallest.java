package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    /**
     *
     *  230. 二叉搜索树中第K小的元素
     *
     *
     *  给定一个二叉搜索树的根节点 root ，
     *
     *  和一个整数 k ，
     *
     *
     *  请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *
     *
     *  方法一：递归
     * 算法：
     *
     * 通过构造 BST 的中序遍历序列，则第 k-1 个元素就是第 k 小的元素。
     *
     *
     *
     */

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> num = this.inorder(root,new ArrayList<Integer>());
        return num.get(k-1);

    }


    public List<Integer> inorder(TreeNode root,ArrayList<Integer> arr){
        if (root == null){
            return arr;
        }
        //递增 中序遍历
        this.inorder(root.left,arr);
        arr.add(root.val);
        this.inorder(root.right,arr);
        return arr;
    }


}
