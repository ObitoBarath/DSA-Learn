package treeTraversalPractices;


import java.util.List;

public  interface TreeTraversalAPI  {


    <T> List<T> preOrderTraversal(TreeNode<T> treeNode);

    <T> TreeNode<T> inOrderTraversal(TreeNode<T> treeNode);
}
