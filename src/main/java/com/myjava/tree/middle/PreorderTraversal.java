package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {


    /**
     *
     *  144. 二叉树的前序遍历
     *
     *  给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     *
     *
     *
     *
     */


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.dfs(root,list);
        return list;
    }

    //dfs
    public void dfs(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        this.dfs(root.left,list);
        this.dfs(root.right,list);
    }
}
