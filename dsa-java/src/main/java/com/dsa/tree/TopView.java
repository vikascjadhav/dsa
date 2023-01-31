package com.dsa.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    static class Pair<T1, T2> {
        T1 hd;
        T2 node;

        Pair(T1 hd, T2 node) {
            this.hd = hd;
            this.node = node;
        }
    }

    ArrayList<Integer> topView(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        Queue<TopView.Pair<Integer, Node>> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new TopView.Pair<Integer, Node>(0, root));
        map.put(0, root.data);

        while (!q.isEmpty()) {

            TopView.Pair<Integer, Node> front = q.poll();

            if (front.node.left != null) {
                int newLevel = front.hd - 1;
                if (map.get(newLevel) == null) {
                    map.put(newLevel, front.node.left.data);
                }
                q.add(new TopView.Pair<Integer, Node>(newLevel, front.node.left));
            }

            if (front.node.right != null) {
                int newLevel = front.hd + 1;
                if (map.get(newLevel) == null) {
                    map.put(newLevel, front.node.right.data);
                }
                q.add(new TopView.Pair<Integer, Node>(newLevel, front.node.right));
            }
        }

        map.values().stream().forEach(ans::add);
        return ans;
    }

    public static void main(String[] args) {
        TopView t = new TopView();
        t.topView(Node.buildTree()).stream().forEach(t1->System.out.print(" "+t1));;
    }
}
