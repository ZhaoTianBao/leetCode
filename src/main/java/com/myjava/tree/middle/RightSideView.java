package com.myjava.tree.middle;


import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {


    /**
     *  199. 二叉树的右视图
     *
     *
     *  给定一棵二叉树，想象自己站在它的右侧，
     *
     *  按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     *
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     *   广度优先 记录层序遍历
     *
     *
     *
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // 从根节点开始访问，根节点深度是0
        this.dfs(root,0);
        return list;

    }


    // 根 右 左 右侧观看
    public void dfs(TreeNode root,int depth){
        if (root == null){
            return;
        }
        // 如果当前节点所在深度还没有出现在res里，
        // 说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        // dept 可能大于 等于 size  大于的时候,多个节点在一层
        if (depth == list.size()){
            list.add(root.val);
        }
        this.dfs(root.right,depth+1);
        this.dfs(root.left,depth+1);
    }



    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    //层序遍历 取出最后的一个节点,就是最右边的节点
                    if (i == size-1){
                        list.add(node.val);
                    }
                    //模板
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }

                }
            }
        }

        return list;

    }


}





