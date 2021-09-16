import java.util.*;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if(root == null) {
            root = new Node(value);
        } else if(value < root.value) {
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    private void delete(int value) {
        root = deleteRecur(root, value);
    }

    private Node deleteRecur(Node root, int value) {
        if(root == null) return null;
        if(value == root.value)
    }

    private boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if(root == null) return false;
        if(value == root.value) return true;
        if(value < root.value) return searchRec(root.left, value);
        return searchRec(root.right, value);
    }

    private void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    private void print() {
        inorder(root);
        System.out.println();
    }

    public static void main(String[]args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.print();
        System.out.println(bst.search(1));
    }
}