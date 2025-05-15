package treeTraversalPractices;

import java.util.ArrayList;
import java.util.List;

public class TreeImplementation implements  TreeTraversalAPI {

    @Override
    public <T> List<T> preOrderTraversal(TreeNode<T> treeNode) {

        List<T> list = new ArrayList<>();

        if (treeNode != null){
            preOrderTraversalHelper(treeNode , list);
        }


        return list;
    }

    @Override
    public <T> TreeNode<T> inOrderTraversal(TreeNode<T> treeNode) {

        TreeNode<T> updatedTreeNode = new TreeNode<>(null);
        inOrderTraversalHelper(treeNode , updatedTreeNode);
        return updatedTreeNode;

    }
    public <T> void inOrderTraversalHelper(TreeNode<T> treeNode , TreeNode<T> outputTreeNode){
        if (treeNode != null){
            inOrderTraversalHelper(treeNode.left , outputTreeNode);

            if (outputTreeNode == null){
                outputTreeNode = new TreeNode<>(treeNode.data);
            }

            while (outputTreeNode.right != null){
                outputTreeNode = outputTreeNode.right;
            }
            outputTreeNode.right = new TreeNode<>(treeNode.data);

            inOrderTraversalHelper(treeNode.right , outputTreeNode);
        }
    }

    public <T> void preOrderTraversalHelper(TreeNode<T>  treeNode , List<T> list){

        if (treeNode != null){
            list.add(treeNode.data);
            preOrderTraversalHelper(treeNode.left,list);
            preOrderTraversalHelper(treeNode.right,list);
        }

    }
}
