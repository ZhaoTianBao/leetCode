package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {


    /**
     *
     *  145. 二叉树的后序遍历
     *
     *
     *  给定一个二叉树，返回它的 后序 遍历。
     *
     *
     *
     */


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.dfs(root,list);
        return list;
    }


    //dfs 后续遍历 左右根
    public void dfs(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        this.dfs(root.left,list);
        this.dfs(root.right,list);
        list.add(root.val);
    }

}
