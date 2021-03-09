package com.myjava.tree.low;

import com.myjava.common.TreeNode;

public class SortedArrayToBST {
    /**
     *
     * 108. 将有序数组转换为二叉搜索树
     *
     * 二叉搜索树 bst，根节点的值都大于左子树，小于右子树的值
     *
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * 选取数组中的一个元素作为根节点，然后构造左子树，递归构造左子树
     *
     * BST的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。
     * 果然刷题的动力来源于自己写代码，并且一次就ac时的快感。对于菜鸡的我来说，即使是简单级别一次性通过，也能获得巨大的成就感。革命尚未成功，还需继续努力。
     * 因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～ 又因为本题要求高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥～
     *
     *
     *
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return this.createBSTTree(nums,0,nums.length -1);
    }


    public TreeNode createBSTTree(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int middle = (left + right)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = this.createBSTTree(nums,left,middle -1);
        root.right = this.createBSTTree(nums,middle + 1,right);
        return root;
    }


}
