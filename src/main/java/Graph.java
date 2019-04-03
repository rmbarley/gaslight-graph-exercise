package main.java;

import java.util.*;

public class Graph {
    private Map<String, ArrayList<String>> adjacencyList;
    private List<String> vertices;
    private int vertexSize;

    public Graph(List<String> vertices) {
        this.vertices = vertices;
        this.vertexSize = vertices.size();
        this.adjacencyList = new HashMap<>();

        // Populate Adjacency List with given vertices
        for (int i = 0; i < vertexSize; i++) {
            ArrayList<String> neighbors = new ArrayList<>();
            adjacencyList.put(getVertexAtIndex(i), neighbors);
        }
    }

    public void addEdge (String start, String destination) throws InvalidVertexException {
        if (vertexDoesNotExist(start) || vertexDoesNotExist(destination)) {
            throw new InvalidVertexException("Vertex does not exist");
        }
        adjacencyList.get(start).add(destination);
        adjacencyList.get(destination).add(start);

    }

    public ArrayList<String> getNeighbors (String source) throws InvalidVertexException {
        if (vertexDoesNotExist(source)) throw new InvalidVertexException("Vertex does not exist");
        return adjacencyList.get(source);
    }

    private String getVertexAtIndex (int index) {
        return vertices.get(index);
    }


    public Map<String, ArrayList<String>> getAdjacencyList () {
        return adjacencyList;
    }

    public void printAdjacencyList() throws InvalidVertexException {
        for (int i = 0; i < vertexSize; i++) {
            System.out.println(getVertexAtIndex(i) + " " + getNeighbors(getVertexAtIndex(i)));
        }
    }

    private boolean vertexDoesNotExist(String vertex) {
        return !adjacencyList.containsKey(vertex);
    }

    public ArrayList<String> findPath(String start, String end) throws InvalidVertexException {
        Iterator<String> cursor = adjacencyList.get(start).iterator();
        String current = start;
        String next = null;
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> whereIveBeen = new ArrayList<>();

        path.add(start);
        whereIveBeen.add(start);


        while (cursor.hasNext()) {
            if (getNeighbors(current).contains(end)) {
                path.add(end);
                return path;
            }
            whereIveBeen.add(current);
            current = cursor.next();
        }

//        for (String node : adjacencyList.get(start)) {
//            if (this.getNeighbors(node).contains(end)) {
//                path.add(end);
//            } else {
//                start = adjacencyList.keySet()
//            }
//        }
        System.out.println(path);
        return path;
    }

}

