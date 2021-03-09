package com.myjava.tree.low;

import com.myjava.common.TreeNode;

public class RangeSumBST {

    /**
     *  938. 二叉搜索树的范围和
     *
     *
     *  给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     *
     * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
     * 输出：32
     *
     *
     *  方法一：深度优先搜索
     *
     *  我们对树进行深度优先搜索，对于当前节点 node，如果 node.val 小于等于 L，
     *
     *  那么只需要继续搜索它的右子树；如果 node.val 大于等于 R，那么只需要继续搜索它的左子树；
     *
     *  如果 node.val 在区间 (L, R) 中，则需要搜索它的所有子树。
     *
     *
     *
     */
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        //：该节点的右孩子的左孩子的值比该节点的值大，缩小了了遍历的范围
        if (root != null){
            if (root.val < low){
                //当前小于L，则只需要遍历右子树即可
                this.rangeSumBST(root.right,low,high);
            }else if(root.val > high){
                //当前大于R，则只需要遍历左子树即可
                this.rangeSumBST(root.left,low,high);
            }else{
                //当前在L~R，则两个子树都要遍历
                sum += root.val;
                this.rangeSumBST(root.left,low,high);
                this.rangeSumBST(root.right,low,high);
            }
        }
        return sum;
    }



}
