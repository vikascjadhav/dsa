package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightDiameter {

    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int ans = Math.max(left, right) + 1;
        return ans;

    }

    public int diameterIterative(Node root) {
        int l = heightIterative(root.left) +1;
        int r = heightIterative(root.right) +1 ;
        return l +r ;
    }
    


    public int heightIterative(Node root) {
        int height = 0;
        Queue<Node> q = new LinkedList<>();
        Node seperatorNode = new Node(-1);
        q.add(root);
        q.add(seperatorNode);

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.getData() == -1 && !q.isEmpty()) {
                q.add(seperatorNode);
                height++;
            } else {
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return height + 1;
    }

    public static void main(String[] args) {
        HeightDiameter h = new HeightDiameter();
        System.out.println("Recursive Approach height :" + h.height(Node.buildTree()));
        System.out.println("Iterative Approach height :" + h.heightIterative(Node.buildTree()));
        System.out.println("Iterative Approach Diameter :" + h.diameterIterative(Node.buildTree()));


    }
}
