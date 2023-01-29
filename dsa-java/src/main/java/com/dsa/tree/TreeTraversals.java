
package com.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {

    /**
     * 1
     * 2 3
     * 4 5 6 7
     * 
     * @param root
     */
    public void inOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.getData());
        inOrderRecursive(root.right);
    }

    public ArrayList<Integer> proOrderRecursive(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            System.out.print(tmp.getData());
            list.add(tmp.data);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

        }

        return (ArrayList<Integer>) list;
    }

    public void bfsTravers(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            final Node element = queue.poll();
            if (element == null) {
                System.out.print(" | ");
                if (!queue.isEmpty())
                    queue.add(null);
            } else {
                System.out.print(element.getData());
                if (element.getLeft() != null) {
                    queue.add(element.getLeft());
                }
                if (element.getRight() != null) {
                    queue.add(element.getRight());
                }
            }
        }
    }

    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();


        return list;
    }

    public static void main(String[] args) {

        TreeTraversals traversals = new TreeTraversals();
        Node root = Node.buildTree();
        System.out.println("BFS Result");
        //bfsTravers(root);
        //inOrder(root);
        traversals.proOrderRecursive(root);
    }
}
