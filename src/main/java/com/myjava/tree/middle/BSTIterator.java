package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {


    /**
     *
     *  173. 二叉搜索树迭代器
     *
     *
     *  实现一个二叉搜索树迭代器。
     *
     *  你将使用二叉搜索树的根节点初始化迭代器。
     *
     *  调用 next() 将返回二叉搜索树中的下一个最小的数。
     *
     *
     *
     *  在研究这个问题的解决方案之前，让我们来总结以下问题的陈述中要求我们实现什么。
     *
     *  我们有一个迭代器类，它有两个函数，即 next() 和 hasNext()。
     *
     *  hasNext() 函数的作用是：返回一个布尔值，表示二叉搜索树中是否还有元素。
     *
     *  next() 函数返回二叉搜索树中下一个最小元素。因此，我们第一次调用 next()
     *
     *  函数时，应返回二叉搜索树中的最小元素；同理，当我们最后一次调用 next() 时，
     *
     *  应返回二叉搜索树中的最大元素。
     *
     *  你可能想知道迭代器的作用是什么。本质上，迭代器可以用于迭代任何容器的对象。
     *
     *  就本题而言，容器是一个二叉搜索树。如果定义了这样的一个迭代器，
     *
     *  那么遍历的逻辑就可以被抽象出来，我们可以使用迭代器按一定顺序处理元素。
     *
     *  现在我们知道了为数据结构设计一个迭代器类背后的原因，通常，
     *
     *  迭代器只是逐个遍历容器的每个元素。对于二叉搜索树，我们希望迭代器以升序返回元素。
     *
     *
     *  二叉搜索树的一个重要的特性是是二叉搜索树的中序序列是升序序列；因此，中序遍历是该解决方案的核心。
     *
     *
     *  初始化一个空数组用来存放二叉搜索树的中序序列。
     *  我们按中序遍历二叉搜索树，按照左中右的顺序处理节点。
     *  一旦所有节点都在数组中，则我们只需要一个指针或索引来实现 next() 和 hasNext 这两个函数。
     *
     * 每当调用 hasNext() 时，我们只需要检查索引是否达到数组末尾。
     *
     * 每当调用 next() 时，我们只需要返回索引指向的元素，并向前移动一步，以模拟迭代器的进度。
     *
     *
     *
     *
     */

    List<Integer> nodesSorted = new ArrayList<>();

    //迭代器的索引
    int index = -1;

    public BSTIterator(TreeNode root) {
        this.dfs(root,nodesSorted);

    }



    public void dfs(TreeNode root,List<Integer> nodesSorted){
        //中序遍历
        if (root == null){
            return;
        }
        this.dfs(root.left,nodesSorted);
        nodesSorted.add(root.val);
        this.dfs(root.right,nodesSorted);
    }




    public int next() {
        return nodesSorted.get(++index);
    }

    public boolean hasNext() {
        return index+1 < nodesSorted.size();
    }





}
