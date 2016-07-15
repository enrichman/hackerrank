/**
 * Copyright (C) Datalytics - All Rights Reserved
 * Created by Enrico Candino <enrico.candino@datalytics.it> on Jul,, 13.
 */
package it.enricocandino.hr.algorithms.graphtheory;

import it.enricocandino.hr.Solution;

import java.io.File;
import java.util.*;

public class SnakesAndLadders extends Solution {

    private static List<Node> visited = new ArrayList<Node>();
    private static List<Node> toVisit = new ArrayList<Node>();

    public void solve(File file) throws Exception {
        Scanner in = new Scanner(file);

        int testCases = in.nextInt();
        for(int t=0; t<testCases; t++) {

            Node[] nodes = new Node[100];

            int ladders = in.nextInt();
            for(int l=0; l<ladders; l++) {
                int start = in.nextInt();
                int end = in.nextInt();
                add(start, end, nodes, 0);
            }

            int snakes = in.nextInt();
            for(int l=0; l<snakes; l++) {
                int start = in.nextInt();
                int end = in.nextInt();
                add(start, end, nodes, 0);
            }

            for(int l=0; l<100; l++) {
                for(int r=1; r<=6; r++) {
                    if(l+r < 100)
                        add(l, l+r, nodes, r);
                }
            }

            toVisit = new ArrayList<Node>(Arrays.asList(nodes));
            toVisit.get(0).setWeight(0);

            while(visited.size() < toVisit.size()) {

                List<Node> remaining = new ArrayList<Node>(toVisit);
                remaining.removeAll(visited);
                Collections.sort(remaining);

                Node next = remaining.get(0);

                for(Vertex v : next.getVertexs()) {
                    int w = v.getWeight() + next.getWeight();
                    if(w < v.getNode().getWeight()) {
                        v.getNode().setWeight(w);
                        v.getNode().setPrev(next);
                    }
                }

                visited.add(next);
            }

            System.out.println(toVisit.get(99).getWeight());
        }
    }

    private static void add(int start, int end, Node[] nodes, int weight) {
        Node startNode = nodes[start];
        if(startNode == null) {
            startNode = new Node();
        }
        Node endNode = nodes[end];
        if(endNode == null) {
            endNode = new Node();
        }

        startNode.addVertex(new Vertex(endNode, weight));
        nodes[start] = startNode;
        nodes[end] = endNode;
    }

    private static class Node implements Comparable<Node> {

        private Node prev;
        private int weight = Integer.MAX_VALUE;
        private List<Vertex> vertexs = new ArrayList<Vertex>();

        private void addVertex(Vertex vertex) {
            this.vertexs.add(vertex);
        }

        public List<Vertex> getVertexs() {
            return vertexs;
        }

        private void setWeight(int weight) {
            this.weight = weight;
        }

        private int getWeight() {
            return weight;
        }

        private Node setPrev() {
            return this.prev;
        }

        private void setPrev(Node node) {
            this.prev = prev;
        }

        public int compareTo(Node o) {
            return weight - o.getWeight();
        }
    }

    private static class Vertex {

        private int weight;
        private Node node;

        private Vertex(Node node) {
            this(node, 0);
        }

        private Vertex(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        private void setNode(Node node) {
            this.node = node;
        }

        private Node getNode() {
            return this.node;
        }

        private int getWeight() {
            return weight;
        }

    }

}
