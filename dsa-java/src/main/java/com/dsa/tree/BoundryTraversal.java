package com.dsa.tree;

import java.util.ArrayList;

public class BoundryTraversal {

    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(node.data);
        traverseLeft(node.left, ans);
        //why we need to travers this as two trees as element will be added of there is only one element in list

        traverseLeaf(node.left, ans);
        traverseLeaf(node.right, ans);
        traverseRight(node.right, ans);
        return ans;
    }

    private void traverseLeaf(Node root, ArrayList<Integer> ans) {
        if(root==null) {
            return;
        }
        if(root.left==null && root.right==null) {
            ans.add(root.data);
        }
        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);
    }

    private void traverseLeft(Node root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        ans.add(root.data);
        if (root.left != null) {
            traverseLeft(root.left, ans);
        } else {
            traverseLeft(root.right, ans);
        }
        return;
    }

    private void traverseRight(Node root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if(root.right!=null) {
            traverseRight(root.right, ans);
        } else {
            traverseRight(root.left, ans);
        }
        ans.add(root.data);
        return;

    }

    public static void main(String[] args) {
        BoundryTraversal b = new BoundryTraversal();
        ArrayList<Integer> ans = b.boundary(Node.buildTree());
        ans.stream().forEach(s -> System.out.print(" " + s));
    }
}
