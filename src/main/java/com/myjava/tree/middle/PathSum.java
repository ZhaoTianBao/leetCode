package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    /**
     *  113. 路径总和 II
     *
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     *
     *  注意到本题的要求是，找到所有满足从「根节点」到某个「叶子节点」经过的路径上的节点之和等于目标和的路径。核心思想是对树进行一次遍历，在遍历时记录从根节点到当前节点的路径和，以防止重复计算。
     *
     *  方法一：深度优先搜索
     * 思路及算法
     *
     * 我们可以采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
     *。
     *
     *
     */


    //存储单行结果,ArrayList 也可以

    Deque<Integer> queue = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum){
        if (root == null){
            return;
        }
        //放到最后,其实 arrayList add 一样
        //末尾加入
        queue.offerLast(root.val);
        sum -= root.val;
        //完成条件 该节点是叶子节点
        // 一整条路结束条件
        if (root.left == null && root.right == null && sum == 0){
            // 双向队列 转 单项队列  其实都一样
            res.add(new LinkedList<>(queue));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        //末尾移除
        queue.pollLast();
    }
}
