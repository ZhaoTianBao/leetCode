package tree;

import com.myjava.common.TreeNode;
import com.myjava.tree.middle.*;
import com.myjava.utils.TreeUtil;
import org.junit.Test;

import java.util.List;

public class MiddleTreeTest {


    @Test
    public void test94(){
        String treeStr = "[1,null,2,3]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        List<Integer> integers = new InorderTraversal().inorderTraversal(root);
        System.out.println(integers);

        List<Integer> integers2 = new InorderTraversal().inorderTraversal2(root);
        System.out.println(integers2);

    }



    @Test
    public void test95(){
        int num = 3;
        List<TreeNode> treeNodes = new GenerateTrees().generateTrees(num);
        for (int i = 0; i < treeNodes.size(); i++) {
            new TreeUtil().printTreeContainBlank(treeNodes.get(i));
        }
    }

    @Test
    public void test96(){
        int num = 5;
        int i = new NumTrees().numTrees(num);
        System.out.println(i);


    }

    @Test
    public void test98(){
        String treeStr = "[1,null,2,3]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        boolean validBST = new IsValidBST().isValidBST(root);
        System.out.println(validBST);

    }


    @Test
    public void test102(){
        String treeStr = "[3,9,20,null,null,15,7]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        List<List<Integer>> lists = new LevelOrder().levelOrder(root);
        System.out.println(lists);

    }

    @Test
    public void test103(){
        String treeStr = "[3,9,20,null,null,15,7]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        List<List<Integer>> lists = new ZigzagLevelOrder().zigzagLevelOrder(root);
        System.out.println(lists);

    }





    @Test
    public void test107(){
        String treeStr = "[3,9,20,null,null,15,7]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        List<List<Integer>> lists = new LevelOrderBottom().levelOrderBottom(root);
        System.out.println(lists);

    }


    @Test
    public void test113(){

        String treeStr = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = new TreeUtil().listToTree(treeStr);
        List<List<Integer>> lists = new PathSum().pathSum(root,22);
        System.out.println(lists);


    }





}
