package com.myjava.tree;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * 257. 二叉树的所有路径
     *
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     *  方法一：深度优先搜索
     * 思路与算法
     *
     * 最直观的方法是使用深度优先搜索。在深度优先搜索遍历二叉树时，我们需要考虑当前的节点以及它的孩子节点。
     *
     * 如果当前节点不是叶子节点，则在当前的路径末尾添加该节点，并继续递归遍历该节点的每一个孩子节点。
     * 如果当前节点是叶子节点，则在当前路径末尾添加该节点后我们就得到了一条从根节点到叶子节点的路径，将该路径加入到答案即可。
     *
     *  广度优先，要使用    Queue<TreeNode>
     *
     *
     */

    public List<String> binaryTreePaths(TreeNode root){
        List<String> paths = new ArrayList<String>();
        this.constructPaths(root,"",paths);
        return paths;
    }

    /**
     *
     * 先声明，然后操作做结果，后使用结果
     */
    public void constructPaths(TreeNode root,String begin,List<String> paths){
        if (root != null){
            StringBuilder str = new StringBuilder(begin);
            str.append(Integer.toString(root.val));
            // 当前节点是叶子节点
            if (root.left == null && root.right == null){
                // 把路径加入到答案中 返回
                paths.add(str.toString());
            }else{
                // 当前节点不是叶子节点，继续递归遍历
                str.append("->");
                constructPaths(root.left,str.toString(),paths);
                constructPaths(root.right,str.toString(),paths);
            }
        }
    }
}
