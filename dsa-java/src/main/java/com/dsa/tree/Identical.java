package com.dsa.tree;

public class Identical {

    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }

        
        if(root1.data != root2.data) {
            return false;
        }
        boolean l = isIdentical(root1.left, root2.left);
        boolean r = isIdentical(root1.right, root2.right);
        return l && r;
    }

    public static void main(String[] args) {
        Identical i = new Identical();
        System.out.println(i.isIdentical(Node.buildTree(), Node.buildTree()));

    }
}
