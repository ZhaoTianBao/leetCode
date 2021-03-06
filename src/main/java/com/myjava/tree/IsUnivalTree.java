package com.myjava.tree;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsUnivalTree {


    /**
     *  965. 单值二叉树
     *
     *  如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     *  只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     *
     *  输入：[1,1,1,1,1,null,1]
     *  输出：true
     *
     *
     *  方法一：深度优先搜索
     *  思路与算法
     *
     *  我们先进行一次深度优先搜索，获取这颗树中的所有节点的值。然后，就可以判断所有节点的值是不是都相等了。
     *
     *
     */


    List<Integer> list = new ArrayList<>();

    public boolean isUnivalTree(TreeNode root) {
        //获取list
        this.dfs(root,list);
        //判断单值
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(0)){
                return false;
            }
        }
        return true;
    }


    public void dfs(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        this.dfs(root.left,list);
        this.dfs(root.right,list);
    }
}
