package main.java;

import java.util.Arrays;
import java.util.List;

public class PathCalculator {

    public static void main(String[] args) throws InvalidVertexException {
        List<String> vertices = Arrays.asList("Seattle", "Denver", "Chicago", "San Diego", "Detroit", "Minneapolis",
                "Boston", "Atlanta");
        Graph graph = new Graph(vertices);
        graph.addEdge("Chicago", "Denver");
        graph.addEdge("Seattle", "Denver");
        graph.addEdge("San Diego", "Denver");
        graph.addEdge("Chicago", "Detroit");
        graph.addEdge("Chicago", "Atlanta");
        graph.addEdge("Detroit", "Minneapolis");
        graph.addEdge("Detroit", "Boston");
        graph.addEdge("Boston", "Atlanta");


        graph.printAdjacencyList();
        graph.findPath("San Diego", "Chicago");
    }
}
