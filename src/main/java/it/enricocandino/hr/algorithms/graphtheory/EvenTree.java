/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 13.
 */
package it.enricocandino.hr.algorithms.graphtheory;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.*;

public class EvenTree extends Solution {

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);

        Node[] nodes = new Node[in.nextInt()];
        int vertexs = in.nextInt();

        for(int i=0; i<vertexs; i++) {
            int vA = in.nextInt() - 1;
            int vB = in.nextInt() - 1;

            Node nA = nodes[vA];
            if(nA == null) {
                nA = new Node(vA+1);
            }
            nodes[vA] = nA;

            Node nB = nodes[vB];
            if(nB == null) {
                nB = new Node(vB+1);
            }
            nodes[vB] = nB;

            nB.addChild(nA);
        }

        int count = 0;
        for(int i=0; i<nodes.length; i++) {
            Node n = nodes[i];

            for(Node child : n.getChildren()) {
                List<Node> subTree = child.getSubTree(n);
                if((subTree.size()+1) %2 == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static class Node {

        private String name;
        private List<Node> children = new ArrayList<Node>();

        public Node(int number) {
            this.name = "Node #"+number;
        }

        public void addChild(Node node) {
            children.add(node);
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public List<Node> getSubTree(Node parent) {
            List<Node> subTree = new ArrayList<Node>(children);
            for(Node c : children) {
                if(c != parent) {
                    List<Node> sub = c.getSubTree(c);
                    for (Node n : sub) {
                        if (!subTree.contains(n))
                            subTree.add(n);
                    }
                }
            }
            return subTree;
        }
    }

}
