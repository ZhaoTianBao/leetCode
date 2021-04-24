package com.myjava.tree.middle;

import com.myjava.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connect {

    /**
     *  116. 填充每个节点的下一个右侧节点指针
     *
     *  给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     *  方法一：层次遍历
     *
     * 思路与算法
     *
     * 题目本身希望我们将二叉树的每一层节点都连接起来形成一个链表。因此直观的做法我们可以对二叉树进行层次遍历，在层次遍历的过程中将我们将二叉树每一层的节点拿出来遍历并连接。
     *
     * 层次遍历基于广度优先搜索，它与广度优先搜索的不同之处在于，广度优先搜索每次只会取出一个节点来拓展，而层次遍历会每次将队列中的所有元素都拿出来拓展，这样能保证每次从队列中拿出来遍历的元素都是属于同一层的，因此我们可以在遍历的过程中修改每个节点的 \text{next}next 指针，同时拓展下一层的新队列。
     *
     *
     *
     */


    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        //声明一个队列
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
       // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()){
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node cur = queue.poll();


                //处理 下一个指针 不是最后一个   peek 头部元素指针,不取出来
                if (i < size - 1){
                    cur.next = queue.peek();

                }


                //模板
                // 拓展下一层节点
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }



        }
        // 返回节点
        return root;
    }

}
