package com.myjava.tree;

import com.myjava.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {

    /**
     *
     *  653. 两数之和 IV - 输入 BST
     *
     *  给定一个二叉搜索树( BST  Binary Search Tree )和一个目标结果，
     *
     *  如果 BST 中存在   两个元素   且它们的和等于给定的目标结果，则返回 true。
     *
     *  案例 1:
     *
     * 输入:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 9
     *
     * 输出: True
     *  
     *
     * 案例 2:
     *
     * 输入:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 28
     *
     * 输出: False
     *
     *
     *  方法一：使用 HashSet【通过】
     *
     *  最简单的方法就是遍历整棵树，找出所有可能的组合，
     *  判断是否存在和为 k 的一对节点。现在在此基础上做一些改进。
     *
     *
     *  如果存在两个元素之和为 k，即 x+y=k，并且已知 x 是树上一个节点的值，
     *
     *  则只需判断树上是否存在一个值为 y 的节点，使得 y=k−x。基于这种思想，
     *
     *  在树的每个节点上遍历它的两棵子树（左子树和右子树），寻找另外一个匹配的数。
     *
     *  在遍历过程中，将每个节点的值都放到一个 set 中。
     *
     *  对于每个值为 p 的节点，在 set 中检查是否存在 k−p。如果存在，那么可以在该树上找到两个节点的和为 k；
     *
     *  否则，将 pp 放入到 set 中。
     *
     *  如果遍历完整棵树都没有找到一对节点和为kk，那么该树上不存在两个和为 k 的节点。
     *
     *
     *
     *
     *
     *  BFS  就是LinkList 一个队列 queue
     *
     *  peek() 返回队头
     *  offer() 插入队尾
     *  poll()  移除队尾
     *
     */


    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> sets = new HashSet<>();
        return this.dfs(root,k,sets);
    }

    public Boolean dfs(TreeNode root, int k, Set<Integer> set){
        if (root == null){
            return false;
        }
        //表达式
        if (set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return this.dfs(root.left,k,set) || this.dfs(root.right,k,set);
    }
}
