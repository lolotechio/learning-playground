package io.lolotech.udemy.dsa.video150;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Graph {

    private int numberOfNodes;
    private Map<Integer, List<Integer>> adjacentList;

    public Graph() {
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(Integer node) {
        this.adjacentList.put(node, new ArrayList<>());
        this.numberOfNodes++;
    }

    public void addEdge(Integer node1, Integer node2) {
        this.adjacentList.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        this.adjacentList.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    public void showConnections() {
        var allNodes = adjacentList.keySet();
        for (var node : allNodes) {
            var nodeConnections = this.adjacentList.get(node);
            StringBuilder connections = new StringBuilder();
            for (var vertex : nodeConnections) {
                connections.append(vertex).append(" ");
            }
            System.out.println(node + " --> " + connections);
        }
    }
}
