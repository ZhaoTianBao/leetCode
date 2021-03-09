package tree;

import com.myjava.common.TreeNode;
import com.myjava.tree.SumRootToLeaf;
import com.myjava.tree.low.*;
import com.myjava.utils.TreeUtil;
import org.junit.Test;

import java.util.List;


public class TreeTest {
    @Test
    public void testTree(){
        TreeNode treeNode = new TreeUtil().listToTree("[3,1,null,null,2]");
        System.out.println(treeNode);
    }

    @Test
    public void test100(){
//        TreeNode a = new TreeNode(1,new TreeNode(2),new TreeNode(3));
//        TreeNode b = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode p = new TreeUtil().listToTree("[1,2,3]");
        TreeNode q = new TreeUtil().listToTree("[1,2,3]");
        System.out.println(new IsSameTree().isSameTree100(p, q));
    }

    @Test
    public void test101(){
        TreeNode root = new TreeUtil().listToTree("[1,2,2,3,4,4,3]");
        System.out.println(new IsSymmetric().isSymmetric(root));
    }

    @Test
    public void test104(){

        TreeNode root = new TreeUtil().listToTree("[2,null,3,null,4,null,5,null,6]");
        System.out.println(new MaxDepth().maxDepth104(root));
    }

    @Test
    public void test107(){
        TreeNode root = new TreeUtil().listToTree("[3,9,20,null,null,15,7]");
        System.out.println(new MaxDepth().maxDepth104(root));
    }

    @Test
    public void test110(){
        TreeNode root = new TreeUtil().listToTree("[3,9,20,null,null,15,7]");
        System.out.println(new IsBalanced().isBalanced110(root));
    }


    @Test
    public void test111(){
        TreeNode root = new TreeUtil().listToTree("[2,null,3,null,4,null,5,null,6]");
        System.out.println(new MinDepth().minDepth111(root));
    }

    @Test
    public void test108(){
        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(nums);
        System.out.println(treeNode);

    }

    @Test
    public void test112(){
        int targetSum = 22;
        String treeStr = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        boolean b = new HasPathSum().hasPathSum(root, targetSum);
        System.out.println(b);
    }
    @Test
    public void test226(){
        String treeStr = "[4,2,7,1,3,6,9]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        TreeNode treeNode = new InvertTree().invertTree(root);
        new TreeUtil().printTree(treeNode);
    }

    @Test
    public void test235(){
        String treeStr = "[6,2,8,0,4,7,9,null,null,3,5]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        TreeNode p = new TreeUtil().listToTree("[2]");
        TreeNode q = new TreeUtil().listToTree("[8]");
        //返回结果
//        TreeNode p = new TreeUtil().listToTree("[3]");
//        TreeNode q = new TreeUtil().listToTree("[5]");
        TreeNode treeNode = new LowestCommonAncestor().lowestCommonAncestor(root, p, q);
        new TreeUtil().printTree(treeNode);
    }

    @Test
    public void test257(){
        String treeStr = "[1,2,3,null,5]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        List<String> list = new BinaryTreePaths().binaryTreePaths(root);
        System.out.println(list);
    }


    @Test
    public void test404(){
        String treeStr = "[3,9,20,null,null,15,7]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        int i = new SumOfLeftLeaves().sumOfLeftLeaves(root);
        System.out.println(i);
    }

    @Test
    public void test501(){
        //中序遍历 有序的
        String treeStr = "[1,null,2,2]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        int[] mode = new FindMode().findMode(root);
        System.out.println(mode);
        for (int i = 0; i < mode.length; i++) {
            System.out.println(mode[i]);
        }
    }

    @Test
    public void test530(){
        //中序遍历 有序的
        String treeStr = "[1,null,3,2]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        int minimumDifference = new GetMinimumDifference().getMinimumDifference(root);
        System.out.println(minimumDifference);
    }


    @Test
    public void test543(){
        //中序遍历 有序的
        String treeStr = "[1,null,3,2]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        int minimumDifference = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println(minimumDifference);
    }

    @Test
    public void test559(){
        //一个疑问，怎么字符窜 生成 N叉树结构 ？？？
        String treeStr = "[1,null,3,2]";
        //list 转 树

        TreeNode root = new TreeUtil().listToTree(treeStr);
        int minimumDifference = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println(minimumDifference);
    }

    @Test
    public void test563(){
        //一个疑问，怎么字符窜 生成 N叉树结构 ？？？
        String treeStr = "[1,2,3]";
        //list 转 树
        TreeNode root = new TreeUtil().listToTree(treeStr);
        int tilt = new FindTilt().findTilt(root);
        System.out.println(tilt);
    }

    @Test
    public void test572(){
        String s = "[3,4,5,1,2]";
        TreeNode sNode = new TreeUtil().listToTree(s);
        String t = "[4,1,2]";
        TreeNode tNode = new TreeUtil().listToTree(t);
        boolean subtree = new IsSubtree().isSubtree(sNode, tNode);
        System.out.println(subtree);
    }
    @Test
    public void test590(){
//        String s = "[3,4,5,1,2]";
//        TreeNode sNode = new TreeUtil().listToTree(s);
//        boolean subtree = new IsSubtree().isSubtree(sNode, tNode);
//        System.out.println(subtree);
    }


    @Test
    public void test606(){

        String treeStr = "[1,2,3,4]";
        TreeNode treeNode = new TreeUtil().listToTree(treeStr);
        String s1 = new Tree2str().tree2str(treeNode);
        System.out.println(s1);
    }

    @Test
    public void test617(){
        String tree1 = "[1,3,2,5]";
        TreeNode treeNode1 = new TreeUtil().listToTree(tree1);
        String tree2 = "[2,1,3,null,4,null,7]";
        TreeNode treeNode2 = new TreeUtil().listToTree(tree2);
        TreeNode treeNode = new MergeTrees().mergeTrees(treeNode1, treeNode2);
        new TreeUtil().printTree(treeNode);
    }

    @Test
    public void test637(){
        String str = "[1,3,2,5]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        List<Double> doubles = new AverageOfLevels().averageOfLevels(treeNode);
        System.out.println(doubles);
    }


    @Test
    public void test653(){
        String str = "[5,3,6,2,4,null,7]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        boolean bool = new FindTarget().findTarget(treeNode,9);
        System.out.println(bool);
    }


    //https://github.com/ustcyyw/yyw_algorithm 其他人的git刷题库
    @Test
    public void test671(){
        String str = "[2,2,5,null,null,5,7]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        int secondMinimumValue = new FindSecondMinimumValue().findSecondMinimumValue(treeNode);
        System.out.println(secondMinimumValue);
    }




    @Test
    public void test700(){
        String str = "[4,2,7,1,3]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        TreeNode treeNode1 = new SearchBST().searchBST(treeNode, 2);
        new TreeUtil().printTree(treeNode1);
    }

    @Test
    public void test783(){
        String str = "[4,2,6,1,3]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        int i = new MinDiffInBST().minDiffInBST(treeNode);
        System.out.println(i);
    }



    @Test
    public void test872(){
        //String tree1 = "[3,5,1,6,2,9,8,null,null,7,4]";
        String tree1 = "[1,2,3]";
        TreeNode treeNode1 = new TreeUtil().listToTree(tree1);
        //String tree2 = "[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]";
        String tree2 = "[1,3,2]";
        TreeNode treeNode2 = new TreeUtil().listToTree(tree2);
        boolean b = new LeafSimilar().leafSimilar(treeNode1, treeNode2);
        System.out.println(b);
    }




    @Test
    public void test897(){
        String str = "[4,2,7,1,3]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        TreeNode treeNode1 = new IncreasingBST().increasingBST(treeNode);
        new TreeUtil().printTree(treeNode1);
    }



    @Test
    public void test938(){
        String str = "[10,5,15,3,7,null,18]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        int i = new RangeSumBST().rangeSumBST(treeNode, 7, 15);
        System.out.println(i);
    }


    @Test
    public void test965(){
        String str = "[1,1,1,1,1,null,1]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        boolean univalTree = new IsUnivalTree().isUnivalTree(treeNode);
        System.out.println(univalTree);
    }

    @Test
    public void test993(){
        String str = "[1,2,3,null,4,null,5]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        boolean flag = new IsCousins().isCousins(treeNode,5,4);
        System.out.println(flag);
    }


    @Test
    public void test1022(){
        String str = "[1,0,1,0,1,0,1]";
        TreeNode treeNode = new TreeUtil().listToTree(str);
        int i = new SumRootToLeaf().sumRootToLeaf(treeNode);
        System.out.println(i);
    }



}
