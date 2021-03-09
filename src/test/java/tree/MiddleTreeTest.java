package tree;

import com.myjava.common.TreeNode;
import com.myjava.tree.middle.GenerateTrees;
import com.myjava.tree.middle.InorderTraversal;
import com.myjava.tree.middle.NumTrees;
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







}
