package com.myjava.tree.low;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {


    /**
     *  872. 叶子相似的树
     *
     *
     *  请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     *
     *
     *
     * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
     *
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     *
     * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     *
     * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * 输出：true
     *
     * 方法：深度优先搜索
     * 思路和算法
     *
     * 首先，让我们找出给定的两个树的叶值序列。之后，我们可以比较它们，看看它们是否相等。
     *
     * 要找出树的叶值序列，我们可以使用深度优先搜索。如果结点是叶子，那么 dfs 函数会写入结点的值，然后递归地探索每个子结点。这可以保证按从左到右的顺序访问每片叶子，因为在右孩子结点之前完全探索了左孩子结点。
     *
     * 叶子值，无需考虑根值，叶子节点从左到右，左子树到右子树
     *
     */



    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        this.dfs(root1,leaves1);
        this.dfs(root2,leaves2);
        return leaves1.equals(leaves2);
    }


    public void dfs(TreeNode root, List<Integer> leavesVal){
        if (root != null){
            if (root.left == null && root.right == null){
                //此处叶子节点加入
                leavesVal.add(root.val);
            }
            //但是循环还是继续
            this.dfs(root.left,leavesVal);
            this.dfs(root.right,leavesVal);
        }
    }



}
