package com.myjava.tree;

import com.myjava.common.TreeNode;

public class MinDiffInBST {
    /**
     *
     *  783. 二叉搜索树节点最小距离
     *
     *
     *  给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
     *
     *  示例：
     *
     * 输入: root = [4,2,6,1,3,null,null]
     * 输出: 1
     * 解释:
     * 注意，root是树节点对象(TreeNode object)，而不是数组。
     *
     * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
     *
     *           4
     *         /   \
     *       2      6
     *      / \
     *     1   3
     *
     * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
     *
     *
     *
     * 方法二：中序遍历【通过】
     * 思路和算法
     *
     * 在二叉搜索树中，中序遍历会将树中节点按数值大小顺序输出。只需要遍历计算相邻数的差值，取其中最小的就可以了。
     *
     *  排序 ，根左右，由小到大
     *
     */

    //前一个值
    Integer prev;
    //最小值
    Integer ans;

    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        this.dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        //中序 排序 小到大
        this.dfs(root.left);
        if (prev != null){
            ans = Math.min(ans,root.val - prev);
        }
        prev = root.val;
        this.dfs(root.right);
    }

}
