package com.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Zigzag {
    ArrayList<Integer> zigzag(Node root) {
        boolean leftToRight = true;
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int[] tmp = new int[size];
            for (int i = 0; i < size; i++) {
                Node front = q.poll();
                int index = leftToRight ? i : size - 1 - i;

                tmp[index] = front.data;

                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            leftToRight = leftToRight ? false : true;
          //  IntStream s = IntStream.of(tmp);
            //s.forEachOrdered(snum -> result.add(snum));
            for(int i =0; i<  tmp.length; i++) {
                result.add(tmp[i]);
            }

        }

      
        return result;

    }

    public static void main(String[] args) {
        Zigzag z = new Zigzag();
        Node root = Node.buildTree();

        z.zigzag(root).stream().forEach(num -> System.out.print(" " + num));
    }

}
