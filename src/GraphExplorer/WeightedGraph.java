package GraphExplorer;

import java.util.*;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        WeightedGraph.java
 * Description  Concrete class in the triad of defining data structures in
 *              Java with interfaces, abstract classes and concrete classes.
 *              It extends the abstract AbstractGraph class.
 * Date         11/17/2023
 * @author	<i>Kirill Grichanichenko</i>
 * @param       <V> generic type
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class WeightedGraph<V> extends AbstractGraph<V> 
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  WeightedGraph()-default constructor
     * Description  Construct an empty graph
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public WeightedGraph() 
    {
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  WeightedGraph()-overloaded constructor
     * Description  Construct a graph from vertices and edges stored in arrays.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       vertices V[]
     * @param       edges int[][]
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public WeightedGraph(V[] vertices, int[][] edges) 
    {
        createWeightedGraph(java.util.Arrays.asList(vertices), edges);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  weightedGraph()-overloaded constructor
     * Description  Construct a graph from vertices and edges stored in List.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       numberOfVertices int
     * @param       edges List
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public WeightedGraph(int[][] edges, int numberOfVertices) 
    {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V)(Integer.valueOf(i)));

        createWeightedGraph(vertices, edges);
    }

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  WeightedGraph()-overloaded constructor
     * Description  Construct a graph for integer vertices 0, 1, 2 and edge list.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       vertices List
     * @param       edges List
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public WeightedGraph(List<V> vertices, List<WeightedEdge> edges) 
    {
        createWeightedGraph(vertices, edges);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  WeightedGraph()-overloaded constructor
     * Description  Construct a graph from integer vertices 0, 1, and edge array.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges List
     * @param       numberOfVertices int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public WeightedGraph(List<WeightedEdge> edges, int numberOfVertices) 
    {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V)(Integer.valueOf(i)));

        createWeightedGraph(vertices, edges);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  createWeightedGraph()
     * Description  Create adjacency lists from edge arrays.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges int[][]
     * @param       vertices List
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void createWeightedGraph(List<V> vertices, int[][] edges) 
    {
        this.vertices = vertices;     

        for (int i = 0; i < vertices.size(); i++) 
        {
            neighbors.add(new ArrayList<Edge>()); // Create a list for vertices
        }

        for (int i = 0; i < edges.length; i++) 
        {
            neighbors.get(edges[i][0]).add(
              new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  createWeightedGraph()
     * Description  Create adjacency lists from edge arrays.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges List
     * @param       vertices List
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void createWeightedGraph(
        List<V> vertices, List<WeightedEdge> edges) 
    {
        this.vertices = vertices;     

        for (int i = 0; i < vertices.size(); i++) 
        {
            neighbors.add(new ArrayList<Edge>()); // Create a list for vertices
        }

        for (WeightedEdge edge: edges) 
        {      
            neighbors.get(edge.u).add(edge); // Add an edge into the list
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getWeight()
     * Description  Return the weight on the edge (u, v).
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       u int
     * @param       v int
     * @throws      java.lang.Exception exp
     * @return      weight double
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public double getWeight(int u, int v) throws Exception 
    {
        for (Edge edge : neighbors.get(u)) 
        {
            if (edge.v == v) 
            {
                return ((WeightedEdge)edge).weight;
            }
        }

        throw new Exception("Edge does not exit");
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getEdgesFromGraph()
     * Description  Retrieve edges from graph
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @return      edges List WeightedEdge
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public List<WeightedEdge> getEdgesFromGraph() {
    List<WeightedEdge> edges = new ArrayList<>();
    for (int u = 0; u < neighbors.size(); u++) {
        for (Edge edge : neighbors.get(u)) {
            edges.add((WeightedEdge) edge);
        }
    }
    return edges;
}

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayEdges
     * Description  Return the edges as a String.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @return      output String
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/     
    public String displayEdges() 
    {
        StringBuilder output = new StringBuilder();
        for (int u = 0; u < neighbors.size(); u++) 
        {
            output.append(getVertex(u) + " (" + u + "): ");
            for (Edge edge: neighbors.get(u)) 
            {
                output.append("(" + edge.u +
                  ", " + edge.v + ", " + ((WeightedEdge)edge).weight + ") ");
            }
            output.append('\n');
        }
        return output.toString();
    }    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayWeightedEdges
     * Description  Return the edges as a String.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @return      output String
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/     
    public StringBuffer displayWeightedEdges() 
    {
        StringBuffer out = new StringBuffer();
        for(int i = 0; i < getSize(); i++)
        {
            out.append(getVertex(i) + " (" + i + "): ");
            for(Edge edge: neighbors.get(i)){
                out.append("(" + edge.u + ", " + edge.v + ", " + ((WeightedEdge)edge).weight + ") ");
            }
            out.append("\n");
        }
        return out;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       printWeightedEdges() 
     * Description  Displays edges with weights
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void printWeightedEdges() 
    {
        for (int i = 0; i < getSize(); i++) 
        {
            System.out.print(getVertex(i) + " (" + i + "): ");
            for (Edge edge : neighbors.get(i)) 
            {
                System.out.print("(" + edge.u +
                  ", " + edge.v + ", " + ((WeightedEdge)edge).weight + ") ");
            }
            System.out.println();
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
     * Method       addEdge() 
     * Description  Add edges to the weighted graph
     * Date         11/17/2023
     * @param       u int  
     * @param       v int  
     * @param       weight double
     * @return      Boolean
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean addEdge(int u, int v, double weight) 
    {
        return addEdge(new WeightedEdge(u, v, weight));
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
     * Method       getMinimumSpanningTree() 
     * Description  Get a minimum spanning tree rooted at vertex 0
     * Date         11/17/2023  
     * @return      MST
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public MST getMinimumSpanningTree() 
    {
        return getMinimumSpanningTree(0);
    }

    /** Get a minimum spanning tree rooted at a specified vertex
     * @param startingVertex
     * @return  */
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
     * Method       getMinimumSpanningTree() 
     * Description  Get a minimum spanning tree rooted at vertex 0
     * Date         11/17/2023  
     * @param       startingVertex int
     * @return      MST
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public MST getMinimumSpanningTree(int startingVertex) 
    {
        // cost[v] stores the cost by adding v to the tree
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++) 
        {
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost 
        }
        cost[startingVertex] = 0; // Cost of source is 0

        int[] parent = new int[getSize()]; // Parent of a vertex
        parent[startingVertex] = -1; // startingVertex is the root
        double totalWeight = 0; // Total weight of the tree thus far

        List<Integer> T = new ArrayList<>();

        // Expand T
        while (T.size() < getSize()) 
        {
            // Find smallest cost v in V - T 
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++) 
            {
                if (!T.contains(i) && cost[i] < currentMinCost) 
                {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            T.add(u); // Add a new vertex to T
            totalWeight += cost[u]; // Add cost[u] to the tree

            // Adjust cost[v] for v that is adjacent to u and v in V - T
            for (Edge e : neighbors.get(u)) 
            {
                if (!T.contains(e.v) && cost[e.v] > ((WeightedEdge)e).weight) 
                {
                    cost[e.v] = ((WeightedEdge)e).weight;
                    parent[e.v] = u; 
                }
            }
        }

        return new MST(startingVertex, parent, T, totalWeight);
    }

    /** MST is an inner class in WeightedGraph */
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Class        MST
     * Description  MST inner class inside the WeightedGraph class that 
     *              extends the Tree class.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public class MST extends Tree 
    {
        private double totalWeight; // Total weight of all edges in the tree

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Constructor   MST()
        * Description   Construct a MST with root, parent, and searchOrder, and totalWeight
        * Date          11/17/2023
        * @author       <i>Kirill Grichanichenko</i>
        * @param        root int
        * @param        parent int[]
        * @param        searchOrder List
        * @param        totalWeight double
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
        public MST(int root, int[] parent, List<Integer> searchOrder, double totalWeight) 
        {
            super(root, parent, searchOrder);
            this.totalWeight = totalWeight;
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        getTotalWeight() 
        * Description   Retrieve total weight from MST
        * Date          11/17/2023
        * @author       <i>Kirill Grichanichenko</i>
        * @return       totalWeight double
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
        public double getTotalWeight() 
        {
            return totalWeight;
        }
    }

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       ShortestPathTree
     * Description  Find single source shortest paths.
     * Date         11/17/2023
     * @param       sourceVertex int
     * @return      shortest path ShortestPathTree
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public ShortestPathTree getShortestPath(int sourceVertex) 
    {
        // cost[v] stores the cost of the path from v to the source
        double[] cost = new double[getSize()];
        for (int i = 0; i < cost.length; i++) 
        {
            cost[i] = Double.POSITIVE_INFINITY; // Initial cost set to infinity
        }
        cost[sourceVertex] = 0; // Cost of source is 0

        // parent[v] stores the previous vertex of v in the path
        int[] parent = new int[getSize()];
        parent[sourceVertex] = -1; // The parent of source is set to -1

        // T stores the vertices whose path found so far
        List<Integer> T = new ArrayList<>();

        // Expand T
        while (T.size() < getSize()) 
        {
            // Find smallest cost v in V - T 
            int u = -1; // Vertex to be determined
            double currentMinCost = Double.POSITIVE_INFINITY;
            for (int i = 0; i < getSize(); i++) 
            {
                if (!T.contains(i) && cost[i] < currentMinCost) 
                {
                    currentMinCost = cost[i];
                    u = i;
                }
            }

            T.add(u); // Add a new vertex to T

            // Adjust cost[v] for v that is adjacent to u and v in V - T
            for (Edge e : neighbors.get(u)) 
            {
                if (!T.contains(e.v) 
                    && cost[e.v] > cost[u] + ((WeightedEdge)e).weight) 
                {
                    cost[e.v] = cost[u] + ((WeightedEdge)e).weight;
                    parent[e.v] = u; 
                }
            }
        }
        
        // Create a ShortestPathTree
        return new ShortestPathTree(sourceVertex, parent, T, cost);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Class        ShortestPathTreeShortestPathTree
     * Description  ShortestPathTree is an inner class in WeightedGraph.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public class ShortestPathTree extends Tree 
    {
        private double[] cost; // cost[v] is the cost from v to source

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Constructor  ShortestPathTree()-constructor
         * Description  Construct a path
         * Date         11/17/2023
         * @author      <i>Kirill Grichanichenko</i>
         * @param       source int
         * @param       parent int[]
         * @param       searchOrder List
         * @param       cost double[]
        *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
        public ShortestPathTree(int source, int[] parent, 
            List<Integer> searchOrder, double[] cost) 
        {
            super(source, parent, searchOrder);
            this.cost = cost;
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method       getCost
        * Description  Return the cost for a path from the root to vertex v.
        * Date         11/17/2023
        * @author      <i>Kirill Grichanichenko</i>
        * @param       v int
        * @return      cost double
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public double getCost(int v) 
        {
            return cost[v];
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method       printAllPaths
        * Description  Print paths from all vertices to the source.
        * Date         11/17/2023
        * @author      <i>Kirill Grichanichenko</i>
        *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public void printAllPaths() 
        {
            System.out.println("All shortest paths from " +
                vertices.get(getRoot()) + " are:");
            for (int i = 0; i < cost.length; i++) 
            {
                printPath(i); // Prints a path from i to the source
                System.out.println("(cost: " + cost[i] + ")"); // Path cost
            }
        }
        
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method       displayAllPaths()
        * Description  Displays paths from all vertices to the source.
        * Date         11/17/2023
        * @author      <i>Kirill Grichanichenko</i>
        * @return      String output
        *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public String displayAllPaths()
        {
            StringBuilder output = new StringBuilder("\nAll shortest paths from " +
                vertices.get(getRoot()) + " with costs are:\n");
            for (int i = 0; i < cost.length; i++) 
            {
                output.append(displayPath(i));
                //printPath(i); // Print a path from i to the source
                output.append("(cost: " + cost[i] + ")\n"); // Path cost
            }
            return output.toString();
        }
    }
}
