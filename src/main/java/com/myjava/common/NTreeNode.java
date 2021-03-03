package com.myjava.common;

import java.util.List;

public class NTreeNode {
    /**
     * 多叉树
     */
    public int val;
    public List<NTreeNode> children;


    public NTreeNode() {
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        this.val = _val;
        this.children = _children;
    }
}
