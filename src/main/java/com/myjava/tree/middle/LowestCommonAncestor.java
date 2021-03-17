package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

public class LowestCommonAncestor {
    /**
     *
     *  236. 二叉树的最近公共祖先
     *
     *
     *  给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     *  百度百科中
     *
     *  最近公共祖先的定义为：“
     *
     *  对于有根树 T 的两个节点 p、q，
     *
     *  最近公共祖先表示为一个节点 x，
     *
     *  满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     *  我们递归遍历整棵二叉树，定义
     *
     *
     *  表示 x 节点的子树中是否包含 p 节点或 q 节点，如果包含为 true，
     *
     *  否则为 false。那么符合条件的最近公共祖先 xx 一定满足如下条件：
     *
     *  1
     *  flson && frson
     *
     ​*
     *  说明左子树和右子树均包含 p 节点或 q 节点，
     *  如果左子树包含的是 p 节点，那么右子树只能包含 q 节点，
     *  反之亦然，因为 p 节点和 q 节点都是不同且唯一的节点，
     *  因此如果满足这个判断条件即可说明 x 就是我们要找的最近公共祖先
     *
     *  2
     *  x = p ∣∣ x = q      &&      flson ∣∣ frson
     *
     *  再来看第二条判断条件，这个判断条件即是考虑了 x 恰好是 p 节点或 q 节点
     *
     *  且它的左子树或右子树有一个包含了另一个节点的情况，
     *
     *  因此如果满足这个判断条件亦可说明 x 就是我们要找的最近公共祖先。
     *
     *  p,q2个点在 一颗左或右子树上
     * ​
     *
     *
     *
     *
     */
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root,p,q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        //在左子树上
        boolean leftNode = this.dfs(root.left,p,q);
        //在右子树上
        boolean rightNode = this.dfs(root.right,p,q);
        //在当前节点上
        boolean currentNode = root.val == p.val || root.val == q.val;
        //完成判断 锁定该节点了
        if ((leftNode && rightNode) || currentNode && (leftNode || rightNode)){
            res = root;
        }
        //存在情况返回 循环
        return leftNode || rightNode || currentNode;
    }



}
