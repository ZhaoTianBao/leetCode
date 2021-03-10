package com.myjava.tree.middle;

import com.myjava.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    /**
     *  102. 二叉树的层序遍历
     *
     *  给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *  示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层序遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     *
     *  方法一：广度优先搜索
     * 思路和算法
     *
     * 我们可以用广度优先搜索解决这个问题。
     *
     * 我们可以想到最朴素的方法是用一个二元组 (node, level) 来表示状态，它表示某个节点和它所在的层数，每个新进队列的节点的 level 值都是父亲节点的 level 值加一。最后根据每个点的 level 对点进行分类，分类的时候我们可以利用哈希表，维护一个以 level 为键，对应节点值组成的数组为值，广度优先搜索结束以后按键 level 从小到大取出所有值，组成答案返回即可。
     *
     *  本文将会讲解为什么这道题适合用广度优先搜索（BFS），以及 BFS 适用于什么样的场景。
     *
     * DFS（深度优先搜索）和 BFS（广度优先搜索）就像孪生兄弟，提到一个总是想起另一个。然而在实际使用中，我们用 DFS 的时候远远多于 BFS。那么，是不是 BFS 就没有什么用呢？
     *
     * 如果我们使用 DFS/BFS 只是为了遍历一棵树、一张图上的所有结点的话，那么 DFS 和 BFS 的能力没什么差别，我们当然更倾向于更方便写、空间复杂度更低的 DFS 遍历。不过，某些使用场景是 DFS 做不到的，只能使用 BFS 遍历。这就是本文要介绍的两个场景：「层序遍历」、「最短路径」。
     *
     * 本文包括以下内容：
     *
     * DFS 与 BFS 的特点比较
     * BFS 的适用场景
     * 如何用 BFS 进行层序遍历
     * 如何用 BFS 求解最短路径问题
     *
     *   DFS 遍历使用递归：
     *
         void dfs(TreeNode root) {
         if (root == null) {
         return;
         }
         dfs(root.left);
         dfs(root.right);
         }
         BFS 遍历使用队列数据结构：

         Java

         void bfs(TreeNode root) {
         Queue<TreeNode> queue = new ArrayDeque<>();
         queue.add(root);
         while (!queue.isEmpty()) {
         TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
         if (node.left != null) {
         queue.add(node.left);
         }
         if (node.right != null) {
         queue.add(node.right);
         }
         }
         }

     *      只是比较两段代码的话，最直观的感受就是：DFS 遍历的代码比 BFS 简洁太多了！
     *
     *      这是因为递归的方式隐含地使用了系统的 栈，我们不需要自己维护一个数据结构。
     *
     *      如果只是简单地将二叉树遍历一遍，那么 DFS 显然是更方便的选择。
     *
     *
     *
     *      这个遍历顺序也是 BFS 能够用来解「层序遍历」、「最短路径」问题的根本原因。
     *
     *      简单来说，层序遍历就是把二叉树分层，然后每一层从左到右遍历：
     *
     *
     *
     *
     */

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        //自定义队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //一层
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(level);

        }
        return res;
    }



}
