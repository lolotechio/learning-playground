package io.lolotech.udemy.dsa.video150;

public class GraphMain {

    public static void main(String[] args) {
        var myGraph = new Graph();

        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(6, 5);

        myGraph.showConnections();
    }
}
