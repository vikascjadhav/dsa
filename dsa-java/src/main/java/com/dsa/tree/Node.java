package com.dsa.tree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public static Node buildTree() {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        return head;
    }

    public static Node buildTree1() {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(8);
        return head;
    }

    public static Node buildInOrdertree(String nodes[], int i) {
        Node root = null;

        if (i < nodes.length ) {
            root = new Node(Integer.parseUnsignedInt(nodes[i]));

            root.left = buildInOrdertree(nodes, 2 * i + 1);
            root.right = buildInOrdertree(nodes, 2 * i + 2);
        }

        return root;

    }

    public static Node buildTreeFromString(String str) {
        Node root = null;
        String nodes[] = str.split(" ");
        root = buildInOrdertree(nodes, 0);
        return root;
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BTree [data=" + data + ", left=" + left + ", righTree=" + right + "]";
    }

}
