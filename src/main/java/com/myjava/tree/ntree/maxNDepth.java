package com.myjava.tree.ntree;

import com.myjava.common.NTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class maxNDepth {

    /**
     *  559. N 叉树的最大深度
     *
     *  给定一个 N 叉树，找到其最大深度。
     *
     *  最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     *
     *  N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
     *
     * 提示：
     *
     * 树的深度不会超过 1000 。
     * 树的节点数目位于 [0, 104] 之间。
     *
     * 还是递归香，迭代是又不好写又慢又费内存...
     *
     */

   public int maxDepth(NTreeNode root){
       //该节点空的时候深度 0
       if(root == null){
           return 0;
       }
       //该节点非空 children为空 深度为1
       if (root.children.isEmpty()){
           return 1;
       }
       //该节点非空，children也非空
       //	2 ms	38.7 MB
       //List<Integer> depths = new LinkedList<>();
        //  1 ms	38.8 MB  arrayList 更快速，空间更少
       List<Integer> depths = new ArrayList<>();
       for (NTreeNode child : root.children) {
           depths.add(maxDepth(child));
       }
       // +1 包含自己的深度
       return Collections.max(depths) + 1;
   }



}
