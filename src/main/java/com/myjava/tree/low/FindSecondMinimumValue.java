package com.myjava.tree.low;

import com.myjava.common.TreeNode;

public class FindSecondMinimumValue {
    /**
     *
     *  671. 二叉树中第二小的节点
     *
     *  给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     *
     *  更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
     *
     *  给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     *
     *  
     *  输入：root = [2,2,5,null,null,5,7]
     *  输出：5
     *  解释：最小的值是 2 ，第二小的值是 5 。
     *
     *  输入：root = [2,2,2]
     *  输出：-1
     *  解释：最小的值是 2, 但是不存在第二小的值。
     *
     *
     *
     *  1.第二小的数字：定义两个变量存放第一小和第二小的数字;
     *
     *  2.其中特别注意的是count计数器,如果二叉树只有一个数字的话,
     *  意味着second没有被赋值,那么count等于0,输出-1;如果count 大于0 那么就输出second;
     *
     *  根节点就是第一个最小值
     *
     *
     */

    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    int count = 0;


    public int findSecondMinimumValue(TreeNode root) {
        this.dfs(root);
        return count == 0 ? -1 : second;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.val < first){
            //初始
//            System.out.println(first);
//            System.out.println(second);
//            System.out.println("111111111");
            //这行不赋值  也行
            //second = first;
            first = root.val;
        } else if(root.val > first && root.val <= second){
//            System.out.println("2222222");
            count++;
            second = root.val;
        }
        this.dfs(root.left);
        this.dfs(root.right);
    }

}
