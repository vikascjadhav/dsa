package com.dsa.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class VerticalTraversal {
    static class WrapperNode implements Comparable<WrapperNode> {
        Node node;
        int level;
        int hd; // horizontal distance

        public WrapperNode(Node node, int level, int hd) {
            this.node = node;
            this.level = level;
            this.hd = hd;
        }

        @Override
        public int compareTo(WrapperNode o) {
            if (this.hd > ((WrapperNode) o).hd)
                return 1;
            else if (this.hd < ((WrapperNode) o).hd)
                return -1;
            else 
                return 0;
        }

    }

    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, List<WrapperNode>> map = new HashMap<>();

        Queue<WrapperNode> q = new LinkedList<>();
        q.add(new WrapperNode(root, 0, 0));
        while (!q.isEmpty()) {
            WrapperNode front = q.poll();
            if (map.get(front.hd) != null) {
                map.get(front.hd).add(front);
            } else {
                List<WrapperNode> list = new ArrayList<WrapperNode>();
                list.add(front);
                map.put(front.hd, list);
            }
            if (front.node.left != null) {
                q.add(new WrapperNode(front.node.left, 1 + front.level, front.hd - 1));
            }

            if (front.node.right != null) {
                q.add(new WrapperNode(front.node.right, 1 + front.level, front.hd + 1));
            }
        }
        List<WrapperNode> tmpList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<WrapperNode> lst = map.get(key).stream().collect(Collectors.toList());
            tmpList.addAll(lst);
        }
      //  tmpList.sort(null);
        Collections.sort(tmpList);

        tmpList.stream().forEach(s->ans.add(s.node.data));

        return ans;
    }

    public static void main(String[] args) {
        // VerticalTraversal v = new VerticalTraversal();
        VerticalTraversal.verticalOrder(Node.buildTree()).stream().forEach(s -> System.out.print(" " + s));
    }

}
