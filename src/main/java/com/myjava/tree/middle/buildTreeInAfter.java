package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTreeInAfter {


    /**
     *
     *  106. 从中序与后序遍历序列构造二叉树
     *
     *  根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     *  注意:
     *  你可以假设树中没有重复的元素。
     *
     *  例如，给出
     *
     *  中序遍历 inorder = [9,3,15,20,7]
     *  后序遍历 postorder = [9,15,7,20,3]
     *  返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *
     *
     *
     *
     *
     *
     */
   
    //存储

    int post_idx;
    int[] postorder;
    int[] inorder;
 	Map<Integer,Integer> idx_map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //进来的参数赋值
        this.postorder = postorder;
        this.inorder = inorder;
        //  从后序遍历的最后一个元素开始  此为根节点
        post_idx = postorder.length - 1;
        int idx = 0;
        // 建立 (元素,下表) 哈希表 map
        for (int val : inorder) {
            idx_map.put(val,idx++);
        }
        //左子树 相关 只是便于构建 用了左子树的起始点
        return dfs(0,inorder.length -1);
    }


    public TreeNode dfs(int in_left,int in_right){
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right){
            return null;
        }
        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);
        //下标减一 --   左右根   依次右起都是根
        post_idx--;
        //依次是右边子树
        root.right = dfs(index+1,in_right);
        root.left = dfs(in_left,index-1);
        return root;




    }


}
