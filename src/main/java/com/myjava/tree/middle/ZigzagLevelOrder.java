package com.myjava.tree.middle;

import com.myjava.common.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {

    /**
     *
     *  103. 二叉树的锯齿形层序遍历
     *
     *
     *  给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层序遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     *
     *
     * Queue 中 add() 和 offer()都是用来向队列添加一个元素。
     * 在容量已满的情况下，
     * add() 方法会抛出IllegalStateException异常，
     * offer() 方法只会返回 false 。
     *
     *
     * poll,peek,element的共同点：
     * 都是返回队列中的首个元素
     *
     *
     * poll：将首个元素从队列中弹出，如果队列是空的，就返回null
     * peek：查看首个元素，不会移除首个元素，如果队列是空的就返回null
     * element：查看首个元素，不会移除首个元素，如果队列是空的就抛出异常NoSuchElementException
     * Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。
     * 在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null 。
     *
     *
     *  推荐offer
     *  poll
     *  peek
     *
     *
     *
     *
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null){

            // 满 false
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            //当前层，元素的数量
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //按顺序弹出队列元素，加入集合
                TreeNode node = queue.poll();
                level.add(node.val);
                //当前元素的左子树入队，即把下一层的元素加入队列
                if (node.left != null){
                    queue.offer(node.left);
                }
                //当前元素的右子树入队，即把下一层的元素加入队列
                if (node.right != null){
                    queue.offer(node.right);
                }


            }
            //奇数层要翻转下
            // if (n%2 == 1){
            if (res.size()%2 == 1){
                Collections.reverse(level);
            }
            res.add(level);
            

        }
        return res;


     }



}
