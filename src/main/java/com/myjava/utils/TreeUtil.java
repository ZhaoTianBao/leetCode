package com.myjava.utils;

import com.myjava.common.TreeNode;

import java.util.*;

public  class TreeUtil {
    public TreeNode listToTree(String src){
        src = src.substring(1,src.length()-1);
        String[] strList = src.split(",");

        TreeNode root  ;
        TreeNode result = null;
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i =0 ; i< strList.length ; i++){
            if (i == 0){
                root = new TreeNode(Integer.parseInt(strList[i]));
                result = root;
                queue.add(root);
            }
            if (!queue.isEmpty()){
                root = queue.poll();
            }else {
                break;
            }
            if ( i+1 < strList.length  && !strList[i+1].equals( "null")){
                root.left = new TreeNode(Integer.parseInt(strList[i +1]));
                queue.add(root.left);
            }
            if ( i + 2 < strList.length && !strList[i+2].equals( "null")){
                root.right = new TreeNode(Integer.parseInt(strList[i +2]));
                queue.add(root.right);
            }
            i = i +1;
        }
        return result;
    }


    /**
     * 打印 二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> treeToList(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue queue = new LinkedList();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for (int i=0; i< length; i++) {
                TreeNode node = (TreeNode)queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!list.isEmpty()){
                result.add(list);
            }
        }
        return result;
    }

    public void printTree(TreeNode treeNode){
        List<List<Integer>> lists = this.treeToList(treeNode);
        System.out.println(lists);
    }


    public void printTreeContainBlank(TreeNode treeNode){
        List<List<Integer>> lists = this.treeToListContainBlank(treeNode);
        System.out.println(lists);
    }


    /**
     *
     * 方法有问题,还需修理
     * @param root
     * @return
     */
    public List<List<Integer>> treeToListContainBlank(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue queue = new LinkedList();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            for (int i=0; i< length; i++) {
                TreeNode node = (TreeNode)queue.poll();
                if (node != null){
                    list.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    list.add(null);
                }


            }
            if (!list.isEmpty()){
                result.add(list);
            }
        }
        return result;
    }

}
