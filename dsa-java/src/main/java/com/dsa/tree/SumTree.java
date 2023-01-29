package com.dsa.tree;

/*
 * Given a Binary Tree. Return true if, for every node X in the tree other than the leaves, its value is equal to the sum of its left subtree's value and its right subtree's value. Else return false.

An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.
 */
public class SumTree {

    int sumTree(Node root) {
        if (root == null) {
            return 0;

        }
        if (root.left == null && root.right == null)
            return 0;
        return sumTree(root.left) + root.data + sumTree(root.left);
    }

    boolean isSumTree(Node root) {
        // Your code here
        int l = sumTree(root.left);
        int r = sumTree(root.right);

        return l == r;
    }

    public static void main(String[] argsc) {
        SumTree sum = new SumTree();
        Node root = Node.buildTreeFromString("9 9 10 10 5");
        TreeTraversals t = new TreeTraversals();
        t.inOrderRecursive(root);
        System.out.println();
        System.out.println(sum.isSumTree(root));
        
    }

}
