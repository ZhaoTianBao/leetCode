package com.myjava.tree;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
    /**
     *
     *  897. 递增顺序查找树
     *
     *  给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，
     *  并且每个结点没有左子结点，只有一个右子结点。
     *
     *  示例 ：
     *
     * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
     *
     *        5
     *       / \
     *     3    6
     *    / \    \
     *   2   4    8
     *  /        / \
     * 1        7   9
     *
     * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     *
     *  1
     *   \
     *    2
     *     \
     *      3
     *       \
     *        4
     *         \
     *          5
     *           \
     *            6
     *             \
     *              7
     *               \
     *                8
     *                 \
     *                  9
     *
     *  方法一：中序遍历 + 构造新的树
     * 我们在树上进行中序遍历，就可以从小到大得到树上的节点。我们把这些节点的对应的值存放在数组中，它们已经有序。接着我们直接根据数组构件题目要求的树即可。
     *
     *  为什么要多创建cur？在increasingBST方法外面创建ans对象不行吗？这样ans就是全局变量了，
     *  inorder方法也可以用到，但是我这样运行没有输出，为什么啊？
     *
     *  是每次递归赋值的时候使用, ans 是用来保存结果二叉树的头结点的,
     *  ans.right 就是新的二叉树的头结点. 需要在 inorder 函数里面使用 cur ,
     *  所以 cur 要定义为全局, 如果使用 ans 代替 cur, 那么主函数里面也需要一个 TreeNode 变量来记录头节点
     *
     *  TreeNode ans = new TreeNode(0), cur = ans 这个语句后面的 cur = ans 是什么意思？为什么不用这个输出是空？
     *  这个不是和链表在第一个结点前面加一个头结点是一个意思吗，加了的话，根结点的操作和子结点的操作就能统一了，
     *  就不需要单独为根结点的操作做特殊处理了。不加cur=ans不是应该会报空指针异常的吗
     *
     *  ans可以理解是链表的头节点，是不动的。后面对链表进行增加元素是通过cur，
     *  所以需要对cur进行初始化操作，让其等于链表头节点。
     *
     *
     *  一个普通变量 要在函数中修改实参 是不是得传变量的地址（也就是指针，变量的门牌号）进去 指针同理
     *  指针指向了一个变量的门牌号 但是请注意！指针本身也是一个变量 所以它自己也有一个自己的门牌号，当指针传入函数时，传入的是自己的门牌号，而不是指针指向的变量的门牌号 所以必须传指针的指针 才能修改指针
     *
     *  据函数值传递的原则 函数内想要修改一个变量 需要传入这个变量的指针 即使这个变量本身就是指针
     *
     *
     */

    public TreeNode increasingBST(TreeNode root) {
        //构建 二叉树中序遍历
        List<Integer> vals = new ArrayList<>();
        this.dfs(root,vals);
        //构建二叉树
        TreeNode ans = new TreeNode(0);
        //     *  ans可以理解是链表的头节点，是不动的。后面对链表进行增加元素是通过cur，
        //     *  所以需要对cur进行初始化操作，让其等于链表头节点。
        TreeNode cur = ans;
        for (Integer val : vals) {
            cur.right = new TreeNode(val);
            //     *  ans可以理解是链表的头节点，是不动的。后面对链表进行增加元素是通过cur，
            //     *  所以需要对cur进行初始化操作，让其等于链表头节点。
            cur = cur.right;
        }
        return ans.right;
    }

    public void dfs(TreeNode root,List<Integer> vals){
        if (root == null){
            return;
        }
        this.dfs(root.left,vals);
        vals.add(root.val);
        this.dfs(root.right,vals);
    }


}
