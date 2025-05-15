package treeTraversalPractices;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.util.stream.Collectors;

class  TreeNode<T>{

    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data){
        this.data = data;
        this.left = this.right = null;
    }


    public static void main(String[] args) {
        double d = Double.parseDouble("1.3");
        System.out.println("d = " + d);

    }
    public static void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
