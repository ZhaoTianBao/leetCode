package com.myjava.tree;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevels {


    /**
     *  637. 二叉树的层平均值
     *
     *  给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     *
     *  示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     *  
     *
     * 提示：
     *
     * 节点值的范围在32位有符号整数范围内。
     *
     *
     *  方法一：深度优先搜索
     *
     * 使用深度优先搜索计算二叉树的层平均值，需要维护两个数组，counts 用于存储二叉树的每一层的节点数，
     *
     * sums 用于存储二叉树的每一层的节点值之和。
     *
     * 搜索过程中需要记录当前节点所在层，
     *
     * 如果访问到的节点在第 ii 层，则将 counts[i] 的值加 11，并将该节点的值加到 sums[i]。
     *
     * 遍历结束之后，第 ii 层的平均值即为 sums[i]/counts[i]。
     *
     *
     *  简单的来说，DFS是一条路走到底。 而BFS是跟所有最靠近邻居都打个交道
     *
     *
     *
     *
     *
     *
     *   level会一直<=sumsSize,。在第一层的时候，
     *
     *
     *   level=0，这时sum.size也等于0，所以sum[0]会赋值进去， 关键点
     *   sum 比 level 多一个
     *
     *   递归左节点 的时候，level变成1了，sumSize也是1，sum[1]=左节点的值，
     *
     *   sumSize就变为2 了，层次遍历左节点为空后，才开始遍历右节点，
     *
     *   拿第一层来说，sumSize为2，而level在根节点level=0的基础上+1，
     *
     *   也就是level=1，所以此时level<sumSize，
     *
     *   sum[1]=原有左节点的值+右节点的值
     *
     *
     *   他这个是深度优先遍历啊，每一层遍历完最左边的节点，
     *
     *   遍历右边的节点时都是在level<sumSize的情况下进行的，
     *
     *
     *   求和sum[level]当然是当前节点值加上原有的sum[level],并且这一层节点的数量counts+1
     *
     *
     *
     *
     *
     *
     *
     */



    public List<Double> averageOfLevels(TreeNode root){
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        this.dfs(root,0,counts,sums);
        //处理结果
        List<Double> averages = new ArrayList<>();
        for (int i = 0; i < sums.size(); i++) {
            averages.add(i,sums.get(i)/counts.get(i));
        }
        return averages;
    }


    /**
     *
     * @param root
     * @param level
     * @param counts 第几层
     * @param sums  求和
     */
    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums){
        if (root == null){
            return;
        }
        //level=0，这时sum.size也等于0，所以sum[0]会赋值进去， 关键点
        //     *   sum 比 level 多一个
        if (level < sums.size()){
            //更新当前层，多个节点  set add 区别 add 有重复，set 没有，为add，update操作
            sums.set(level,sums.get(level) + root.val);
            counts.set(level,counts.get(level) + 1);
        }else{
            //初始化 level = 0
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        this.dfs(root.left,level + 1,counts,sums);
        this.dfs(root.right,level + 1,counts,sums);
    }


}
