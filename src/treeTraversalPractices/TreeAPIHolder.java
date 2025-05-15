package treeTraversalPractices;

public class TreeAPIHolder  {

    public static TreeTraversalAPI getTreeTraversalAPI() {
        return new TreeImplementation();
    }
}
