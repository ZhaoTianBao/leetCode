package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST {

    /**
     *
     *  98. 验证二叉搜索树
     *
     *  二叉搜索树概念
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     *
     *  输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     *
     *
     * 方法二：中序遍历
     *
     * 思路和算法
     *
     * 基于方法一中提及的性质，我们可以进一步知道二叉搜索树「中序遍历」得到的值构成的序列一定是升序的，这启示我们在中序遍历的时候实时检查当前节点的值是否大于前一个中序遍历到的节点的值即可。如果均大于说明这个序列是升序的，整棵树是二叉搜索树，否则不是，下面的代码我们使用栈来模拟中序遍历的过程。
     *
     * 可能由读者不知道中序遍历是什么，我们这里简单提及一下，中序遍历是二叉树的一种遍历方式，它先遍历左子树，再遍历根节点，最后遍历右子树。而我们二叉搜索树保证了左子树的节点的值均小于根节点的值，根节点的值均小于右子树的值，因此中序遍历以后得到的序列一定是升序序列。
     *
     *
     *
     *
     *
     */

    public boolean isValidBST(TreeNode root) {
        //双向队列
        Deque<TreeNode> stack = new LinkedList<>();
        // 前一个 初始值
        // 初始值要设置为 double inorder = - Double.MAX_VALUE; ，这和 Double.MIN_VALUE 有什么区别呢？
        // 因为算法要先使用一个很小的值来判断接受树中各结点的值，而Double.MIN_VALUE表示的是一个最小的正数，
        // 注意是大于0的正数，因此这里对最大值取反获得最小的数
        double inorder = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;

    }
}
