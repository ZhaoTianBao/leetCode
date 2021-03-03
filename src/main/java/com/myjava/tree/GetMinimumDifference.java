package com.myjava.tree;

import com.myjava.common.TreeNode;

import java.util.Map;

public class GetMinimumDifference {


    /**
     *
     * 530. 二叉搜索树的最小绝对差
     *
     *  给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *
     * 方法一：中序遍历
     * 思路与算法
     *
     * 考虑对升序数组 aa 求任意两个元素之差的绝对值的最小值，答案一定为相邻两个元素之差的最小值，即
     *
     * \textit{ans}=\min_{i=0}^{n-2}\left\{a[i+1]-a[i]\right\}
     * ans=
     * i=0
     * min
     * n−2
     * ​
     *  {a[i+1]−a[i]}
     *
     * 其中 nn 为数组 aa 的长度。其他任意间隔距离大于等于 22 的下标对 (i,j)(i,j) 的元素之差一定大于下标对 (i,i+1)(i,i+1) 的元素之差，故不需要再被考虑。
     *
     * 回到本题，本题要求二叉搜索树任意两节点差的绝对值的最小值，而我们知道二叉搜索树有个性质为二叉搜索树中序遍历得到的值序列是递增有序的，因此我们只要得到中序遍历后的值序列即能用上文提及的方法来解决。
     *
     * 朴素的方法是经过一次中序遍历将值保存在一个数组中再进行遍历求解，
     * 我们也可以在中序遍历的过程中用 \textit{pre}pre 变量保存前驱节点的值，
     * 这样即能边遍历边更新答案，不再需要显式创建数组来保存，
     * 需要注意的是 \textit{pre}pre 的初始值需要设置成任意负数标记开头，
     * 下文代码中设置为 -1−1。
     *
     * 二叉树的中序遍历有多种方式，包括递归、栈、Morris 遍历等，读者可选择自己最擅长的来实现。
     * 下文代码提供最普遍的递归方法来实现，其他遍历方法的介绍可以详细看「94. 二叉树的中序遍历的官方题解」，
     * 这里不再赘述。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，其中 nn 为二叉搜索树节点的个数。每个节点在中序遍历中都会被访问一次且只会被访问一次，因此总时间复杂度为 O(n)O(n)。
     *
     * 空间复杂度：O(n)O(n)。递归函数的空间复杂度取决于递归的栈深度，而栈深度在二叉搜索树为一条链的情况下会达到 O(n)O(n) 级别。
     *
     *
     *
     */


    //记录前一个值
    int pre;
    //记录差值
    int ans;

    public int getMinimumDifference(TreeNode root) {
        //内部不能重新带类型 如 int pre = -1 就不行
        pre = -1;
        // ans 初始 无值，只有最大上限 写法  不能不写，代表无限大，不写就是0了
        ans = Integer.MAX_VALUE;
        this.dfs(root);
        return ans;
    }



    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        this.dfs(root.left);
        //初始赋值
        if (pre == -1){
            pre = root.val;
        }else{
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        this.dfs(root.right);
    }


}
