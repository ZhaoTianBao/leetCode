package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    /**
     *  94. 二叉树的中序遍历
     *
     *  给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     *
     *  就是给一颗树
     *  输入：root = [1,null,2,3]
     *
     *  输出：[1,3,2]根左右
     *
     *      首先我们需要了解什么是二叉树的中序遍历：
     *      按照访问左子树——根节点——右子树的方式遍历这棵树，
     *      而在访问左子树或者右子树的时候我们按照同样的方式遍历，
     *      直到遍历完整棵树。因此整个遍历过程天然具有递归的性质，
     *      我们可以直接用递归函数来模拟这一过程。
     *
     *      定义 inorder(root) 表示当前遍历到 root 节点的答案，
     *      那么按照定义，我们只要递归调用 inorder(root.left)
     *      来遍历 root 节点的左子树，然后将
     *      root 节点的值加入答案，再递归调用inorder(root.right)
     *      来遍历 root 节点的右子树即可，递归终止的条件为碰到空节点。
     *
     *
     *      方法二：迭代
     *
     *
     *      思路与算法
     *
     *      方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的，
     *
     *
     *      区别在于递归的时候隐式地维护了一个栈，
     *
     *
     *      而我们在迭代的时候需要显式地将这个栈模拟出来，
     *      其他都相同，具体实现可以看下面的代码。
     *
     *
     *
     *  归纳
     *
     *  https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/zhuan-ti-jiang-jie-er-cha-shu-qian-zhong-hou-xu--2/
     *
     *
     *
     *
     */


    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        this.dfs(root,list);
        return list;
    }

    public void dfs(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        this.dfs(root.left,list);
        list.add(root.val);
        this.dfs(root.right,list);
    }


    /**
     * 迭代  还要研究下
     */
    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }



}
