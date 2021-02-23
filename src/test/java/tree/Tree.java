package tree;

import com.myjava.common.TreeNode;
import com.myjava.tree.*;
import com.myjava.utils.TreeUtil;
import org.junit.Test;


public class Tree {
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


}
