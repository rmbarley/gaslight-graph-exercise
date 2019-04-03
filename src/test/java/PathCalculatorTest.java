package test.java;

import main.java.Graph;
import main.java.InvalidVertexException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PathCalculatorTest {
    private List<String> vertices;
    private Graph graph;
    private Map adjacencyList;

    @Before
    public void setUp() {
        this.vertices = Arrays.asList("Seattle", "Denver", "Chicago");
        this.graph = new Graph(vertices);
        this.adjacencyList = graph.getAdjacencyList();
    }

    @Test
    public void testCreateGraphWithValidVertices() {
        assertNotNull(this.graph);
    }

    @Test
    public void testGraphShouldPopulateAMap() {
       assertNotNull(graph.getAdjacencyList());
    }

    @Test
    public void testAdjacencyListShouldBeSizeV() {
        assertEquals(adjacencyList.size(), vertices.size());
    }

//    @Test
//    public void testAdjacencyListShouldContainVertices() {
//        Assert.assertThat(this.adjacencyList.values(), CoreMatchers.hasItems(vertices.get(1), vertices.get(2)));
//    }

    @Test
    public void testGraphCanAddEdges() throws InvalidVertexException {
        graph.addEdge("Seattle", "Denver");
        assertEquals(adjacencyList.get("Seattle"), new HashSet<>(Collections.singleton("Denver")));
    }

    @Test(expected = InvalidVertexException.class)
    public void testAddEdgeShouldThrowExceptionIfVertexDNE () throws InvalidVertexException {
        graph.addEdge("Cincinnati", "Boston");
        fail();
    }

    @Test(expected = InvalidVertexException.class)
    public void testGetNeighborShouldThrowExceptionIfVertexDNE () throws InvalidVertexException {
        graph.getNeighbors("Cincinnati");
        fail();
    }

    @Test
    public void testFindsPathIfNodesAreNeighbors() throws InvalidVertexException {
        graph.addEdge("Seattle", "Denver");
        ArrayList path = graph.findPath("Seattle", "Denver");
        assertEquals(path, Arrays.asList("Seattle", "Denver"));
    }

    public void testFindsPathIfNeighborsAreNeighbors() throws InvalidVertexException {
        graph.addEdge("Seattle", "Denver");
        ArrayList path = graph.findPath("Seattle", "Denver");
        assertEquals(path, Arrays.asList("Seattle", "Denver"));
    }

}
