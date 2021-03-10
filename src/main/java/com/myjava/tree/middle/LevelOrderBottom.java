package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    /**
     *
     *
     *
     * 107. 二叉树的层序遍历 II
     *
     *
     *  给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层序遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     *
     * 方法一：广度优先搜索
     * 树的层次遍历可以使用广度优先搜索实现。
     * 从根节点开始搜索，每次遍历同一层的全部节点，使用一个列表存储该层的节点值。
     *
     *
     *  如果要求从上到下输出每一层的节点值，做法是很直观的，在遍历完一层节点之后，
     *  将存储该层节点值的列表添加到结果列表的尾部。这道题要求从下到上输出每一层的节点值，
     *  只要对上述操作稍作修改即可：在遍历完一层节点之后，将存储该层节点值的列表添加到结果列表的头部。
     *
     *
     *
     *  为了降低在结果列表的头部添加一层节点值的列表的时间复杂度，
     *  结果列表可以使用链表的结构，
     *
     *  在链表头部添加一层节点值的列表的时间复杂度是 O(1)。
     *
     *
     *
     */


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //反向存储,展示顺序 用链表
        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }

            }
            //将list 插入头部,则为反向输出
            res.add(0,level);
        }
        return res;

    }
}
