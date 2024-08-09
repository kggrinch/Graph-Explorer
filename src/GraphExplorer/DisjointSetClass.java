package GraphExplorer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        DisjointSetClass.java
 * Description  Crucial class for Graph-Explorer. This class
 *              is used to implement Kruskal's Algorithm to find MST, 
 *              and Dijkstra's Algorithm to find Shortest Path with weights.
 * Date         11/17/2023 
 * @author	<i>Kirill Grichanichenko</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class DisjointSetClass {
    
    private static double totalWeight = 0;
    private final Map<Integer, Integer> parent = new HashMap();

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  DisjointSetClass() -default constructor
     * Description  Construct an empty DisJointSet Class
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public DisjointSetClass() 
    {
        
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getTotalWeight()
     * Description  A getter method used to retrieve the total weight.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @return      double totalWeight
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public static double getTotalWeight()
    {
        return totalWeight;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       make_set()
     * Description  Creates numberOfVertices disjoint sets (one for each vertex)
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       numberOfVertices int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public void make_set(int numberOfVertices)
    {
        for(int i = 0; i < numberOfVertices; i++)
        {
            parent.put(i, i);
        }
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       find_set()
     * Description  Recursive method to find the root of the set
     *              in private int (find k)
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       k int
     * @return      int k 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private int find_set(int k)
    {
        if(parent.get(k) == k)
            return k;
        
        return find_set(parent.get(k));
                    
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       union_sets()
     * Description  Performs the union_sets of two subsets
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       a int
     * @param       b int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void union_sets(int a, int b)
    {
        int u = find_set(a);
        int v = find_set(b);
        parent.put(u, v);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       kruskalsAlgorithm()
     * Description  Method that constructs MST using Kruskal's Algorithm
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges             List WeightedEdge
     * @param       numberOfVertices  int
     * @return      mst               List WeightedEdge
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public static List<WeightedEdge> kruskalsAlgorithm(List<WeightedEdge> edges, int numberOfVertices)
    {
        // Initialize
        totalWeight = 0;
        List<WeightedEdge> minimumSpanningTree = new ArrayList();
        DisjointSetClass disjoint = new DisjointSetClass();
        
        disjoint.make_set(numberOfVertices);
        
        int index = 0;
        
         // Sort edges based on weight.
        Collections.sort(edges, Comparator.comparingDouble(e -> e.weight));
        
        // Iterate until the minimum spanning tree has (numberOfVetices - 1) edges
        while(minimumSpanningTree.size() != numberOfVertices - 1)
        {
            WeightedEdge nextEdge = edges.get(index++);
            int u = disjoint.find_set(nextEdge.u);
            int v = disjoint.find_set(nextEdge.v);
            
            // Check if adding this edge would create a cycle
            if(u != v)
            {
                minimumSpanningTree.add(nextEdge);
                disjoint.union_sets(u, v); // Union the sets of the vertices
                totalWeight += nextEdge.weight;
            }
        }
        return minimumSpanningTree;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       dijkstraAlgorithm()
     * Description  Method that constructs shortest path using Dijkstra's Algorithm
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges             List WeightedEdge
     * @param       numberOfVertices  int
     * @param       source            int 
     * @return      shortestPath      List WeightedEdge
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public List<WeightedEdge> dijkstrasAlgorithm(List<WeightedEdge> edges, int numberOfVertices, int source) 
    {
         // Initialize
        List<WeightedEdge> shortestPath = new ArrayList<>();
        Map<Integer, Double> distance = new HashMap<>();
        Map<Integer, Integer> previousNode = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));

        // Initialize distances to infinity for all vertices except the source
        for (int i = 0; i < numberOfVertices; i++) 
        {
            distance.put(i, Double.POSITIVE_INFINITY);
        }
        distance.put(source, 0.0);

        // Add all vertices to the queue
        for (int i = 0; i < numberOfVertices; i++) 
        {
            priorityQueue.add(i);
        }
        
        // Iterate through and get the vertex with the smallest weight
        while (!priorityQueue.isEmpty()) 
        {
            int u = priorityQueue.poll();
            
            for (WeightedEdge edge : edges) 
            {
                if (edge.u == u) 
                {
                    double newDistance = distance.get(u) + edge.weight;
                    
                    // Update if a shorter path is found
                    if (newDistance < distance.get(edge.v)) 
                    {
                        distance.put(edge.v, newDistance);
                        previousNode.put(edge.v, u);

                        priorityQueue.remove(edge.v);
                        priorityQueue.add(edge.v);
                    }
                }
            }
        }
        // Rebuild the shortest path
        for (int i = 0; i < numberOfVertices; i++) 
        {  
            if (i != source) 
            {
                int current = i;
                int pred = previousNode.get(current);
                shortestPath.add(new WeightedEdge(pred, current, distance.get(current) - distance.get(pred)));
            }
        }
    return shortestPath;
    }
}
