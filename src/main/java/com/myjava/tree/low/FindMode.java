package com.myjava.tree.low;

import com.myjava.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindMode {

    /**
     *
     * 501. 二叉搜索树中的众数
     *
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     *
     *         //中序遍历 有序的
     *
     *
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     *
     * 返回[2].
     *
     * 提示：如果众数超过1个，不需考虑输出顺序
     *
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     *
     *
     * 每个节点的值记录，统计出现的频次
     *
     * 方法一：中序遍历
     * 思路与算法
     *
     * 首先我们一定能想到一个最朴素的做法：因为这棵树的中序遍历是一个有序的序列，
     * 所以我们可以先获得这棵树的中序遍历，然后从扫描这个中序遍历序列，
     * 然后用一个哈希表来统计每个数字出现的个数，这样就可以找到出现次数最多的数字。
     * 但是这样做的空间复杂度显然不是 O(1)O(1) 的，原因是哈希表和保存中序遍历序列的空间代价都是 O(n)O(n)。
     *
     *
     *  这样一颗二叉搜索树的中序遍历序列是 \{ -1, 0, 0, 1, 2, 2 \}{−1,0,0,1,2,2}。我们可以发现重复出现的数字一定是一个连续出现的，例如这里的 00 和 22，它们都重复出现了，并且所有的 00 都集中在一个连续的段内，所有的 22 也集中在一个连续的段内。我们可以顺序扫描中序遍历序列，用 \textit{base}base 记录当前的数字，用 \textit{count}count 记录当前数字重复的次数，用 \textit{maxCount}maxCount 来维护已经扫描过的数当中出现最多的那个数字的出现次数，用 \textit{answer}answer 数组记录出现的众数。每次扫描到一个新的元素：
     *
     * 首先更新 \textit{base}base 和 \textit{count}count:
     * 如果该元素和 \textit{base}base 相等，那么 \textit{count}count 自增 11；
     * 否则将 \textit{base}base 更新为当前数字，\textit{count}count 复位为 11。
     * 然后更新 \textit{maxCount}maxCount：
     * 如果 \textit{count} = maxCountcount=maxCount，那么说明当前的这个数字（\textit{base}base）出现的次数等于当前众数出现的次数，将 \textit{base}base 加入 \textit{answer}answer 数组；
     * 如果 \textit{count} > maxCountcount>maxCount，那么说明当前的这个数字（\textit{base}base）出现的次数大于当前众数出现的次数，因此，我们需要将 \textit{maxCount}maxCount 更新为 \textit{count}count，清空 \textit{answer}answer 数组后将 \textit{base}base 加入 \textit{answer}answer 数组。
     * 我们可以把这个过程写成一个 \text{update}update 函数。这样我们在寻找出现次数最多的数字的时候就可以省去一个哈希表带来的空间消耗。
     *
     * 然后，我们考虑不存储这个中序遍历序列。 如果我们在递归进行中序遍历的过程中，访问当了某个点的时候直接使用上面的 \text{update}update 函数，就可以省去中序遍历序列的空间，代码如下。
     *
     *
     *
     */

    List<Integer> answers = new ArrayList<>();
    int base = 0;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        //深度优先
        this.dfs(root);
        int[] arr = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            arr[i] = answers.get(i);
        }
        return arr;
    }


    public void dfs(TreeNode root){
        if (root == null){
            return ;
        }
        //操作 二叉搜索树 节点值
        //中序遍历要按照顺序才是中序遍历 left root right
        this.dfs(root.left);
        this.updateDfs(root.val);
        this.dfs(root.right);

    }

    public void updateDfs(int x){
        //出现多次
        if (x == base){
            ++count;
        }else{
            //出现一次
            base = x;
            count = 1;
        }
        //处理计数
        //众数值最大并列多个判断
        if (count == maxCount){
            answers.add(base);
        }
        //众数值最大的
        if (count > maxCount){
            maxCount = count;
            answers.clear();
            answers.add(base);
        }
    }
}
