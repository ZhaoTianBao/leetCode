package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    /**
     *  95. 不同的二叉搜索树 II
     *
     *  给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     *
     *
     *  输入：3
     * 输出：
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     *
     *  方法一：回溯
     *
     *  回溯算法实际上一个类似枚举的搜索尝试过程，
     *
     *  尝试+枚举
     *
     *  主要是在搜索尝试过程中寻找问题的解，
     *
     *  当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。
     *
     *
     *
     * 思路与算法
     *
     * 二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，
     * 小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。
     *
     *
     * 因此在生成所有可行的二叉搜索树的时候，假设当前序列长度为 nn，
     * 如果我们枚举根节点的值为 ii，
     * 那么根据二叉搜索树的性质我们可以知道左子树的节点值的集合为 [1…i−1]，
     * 右子树的节点值的集合为 [i+1…n]。
     * 而左子树和右子树的生成相较于原问题是一个序列长度缩小的子问题，
     * 因此我们可以想到用回溯的方法来解决这道题目。
     *
     * 我们定义 generateTrees(start, end) 函数表示当前值的集合为 [{start},{end}][start,end]，
     *
     * 返回序列 [{start},{end}][start,end] 生成的所有可行的二叉搜索树。按照上文的思路，
     *
     * 我们考虑枚举 [{start},{end}][start,end] 中的值 ii 为当前二叉搜索树的根，
     *
     * 那么序列划分为了 [{start},i-1][start,i−1] 和 [i+1,{end}][i+1,end] 两部分。
     *
     * 我们递归调用这两部分，即 generateTrees(start, i - 1) 和 generateTrees(i + 1, end)，
     *
     * 获得所有可行的左子树和可行的右子树，那么最后一步我们只要从可行左子树集合中选一棵，
     *
     * 再从可行右子树集合中选一棵拼接到根节点上，并将生成的二叉搜索树放入答案数组即可。
     *
     * 递归的入口即为 generateTrees(1, n)，出口为当 {start}>{end}start>end 的时候，
     *
     * 当前二叉搜索树为空，返回空节点即可。
     *
     *
     *
     *
     */

    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            //空
            return new ArrayList<TreeNode>();
        }
        return this.generateDstTrees(1,n);
    }


    public List<TreeNode> generateDstTrees(int start,int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        //出口
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }
        //枚举可行节点
        for (int i = start; i <=end ; i++) {
            //可行左子树
            List<TreeNode> leftList = this.generateDstTrees(start,i-1);
            //可行右子树
            List<TreeNode> rightList = this.generateDstTrees(i+1,end);

            //拼接所有可能树
            for (int i1 = 0; i1 < leftList.size(); i1++) {
                for (int i2 = 0; i2 < rightList.size(); i2++) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = leftList.get(i1);
                    curr.right = rightList.get(i2);
                    allTrees.add(curr);
                }
            }

        }
        return allTrees;




    }
}
