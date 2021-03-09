package com.myjava.tree;

import com.myjava.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class IsCousins {


    /**
     *  993. 二叉树的堂兄弟节点
     *
     *  在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     *
     *
     *
     *  如果二叉树的两个节点深度相同，
     *  但父节点不同，
     *
     *  则它们是一对堂兄弟节点。
     *
     *
     *
     *
     *  我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
     *
     *  只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
     *
     *
     *
     *
     *
     *
     *  当且仅当一对节点深度相同而父节点不相同时，它们是堂兄弟节点。
     *  一种非常直接的方法就是通过某种方法求出每一个节点的深度与父节点。
     *
     *  算法
     *
     *  我们用深度优先搜索标记每一个节点，对于每一个节点 node，它的父亲为 par，深度为 d，
     *  我们将其记录到 Hashmap 中：parent[node.val] = par 且 depth[node.val] = d。
     *
     *  深度优先搜索（DFS）：双HashMap缓存思路
     *
     */
    //节点深度
    Map<Integer,Integer> depth;
    //节点父节点
    Map<Integer,TreeNode> parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();

        this.dfs(root,null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode root, TreeNode par){
        if (root != null){
                                        // 父节点 深度 + 1
            depth.put(root.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(root.val,par);
            this.dfs(root.left,root);
            this.dfs(root.right,root);
        }

    }


}
