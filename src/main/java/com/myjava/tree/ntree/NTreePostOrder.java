package com.myjava.tree.ntree;

import com.myjava.common.NTreeNode;

import java.util.ArrayList;
import java.util.List;

public class NTreePostOrder {

    /**
     *
     *  590. N 叉树的后序遍历
     *
     *  给定一个 N 叉树，返回其节点值的 后序遍历 。
     *
     *  N 叉树 在输入中按层序遍历进行序列化表示，
     *
     *  每组子节点由空值 null 分隔。
     *
     *  进阶：
     *
     *  递归法很简单，你可以使用迭代法完成此题吗?
     *
     *
     *
     */
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> postorder(NTreeNode root) {
        if (null == root){
            return list;
        }
        //子节点
        for (NTreeNode child : root.children) {
            this.postorder(child);
        }
        //根节点
        list.add(root.val);
        return list;
    }



}
