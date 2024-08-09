package GraphExplorer;

import java.util.ArrayList;
import java.util.List;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Abstract     AbstractGraph.java
 * Description  Crucial abstract class in the triad of defining data structures
 *              in Java with interfaces, abstract classes and concrete classes.
 *              The AbstractGraph overrides the Graph abstract methods and 
 *              provides a number of other methods to be used by the 
 *              UnweightedGraph and WeightedGraph classes
 * Date         11/17/2023 
 * @author	<i>Kirill Grichanichenko</i>
 * @param       <V> generic type
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public abstract class AbstractGraph<V> implements Graph<V> 
{
    protected List<V> vertices = new ArrayList<>(); // Store vertices
    protected List<List<Edge>> neighbors = new ArrayList<>(); // Adjacency lists

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AbstractGraph()-default constructor
     * Description  Not used
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    protected AbstractGraph() 
    {
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AbstractGraph()-overloaded constructor
     * Description  Construct a graph from vertices and edges stored in arrays.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       vertices V{}
     * @param       edges int[][]
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    protected AbstractGraph(V[] vertices, int[][] edges) 
    {
        for (int i = 0; i < vertices.length; i++)
            addVertex(vertices[i]);

        createAdjacencyLists(edges, vertices.length);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AbstractGraph()-overloaded constructor
     * Description  Construct a graph from vertices and edges stored in List.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       vertices List
     * @param       edges List
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    protected AbstractGraph(List<V> vertices, List<Edge> edges) 
    {
        for (int i = 0; i < vertices.size(); i++)
            addVertex(vertices.get(i));

        createAdjacencyLists(edges, vertices.size());
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AbstractGraph()-overloaded constructor
     * Description  Construct a graph for integer vertices 0, 1, 2 and edge list.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges List
     * @param       numberOfVertices int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    protected AbstractGraph(List<Edge> edges, int numberOfVertices) 
    {
        for (int i = 0; i < numberOfVertices; i++) 
            addVertex((V)(Integer.valueOf(i))); // vertices is {0, 1, ...}

        createAdjacencyLists(edges, numberOfVertices);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  AbstractGraph()-overloaded constructor
     * Description  Construct a graph from integer vertices 0, 1,... and edge array.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges int[][]
     * @param       numberOfVertices int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    protected AbstractGraph(int[][] edges, int numberOfVertices) 
    {
        for (int i = 0; i < numberOfVertices; i++) 
            addVertex((V)(Integer.valueOf(i))); // vertices is {0, 1, ...}

        createAdjacencyLists(edges, numberOfVertices);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       createAdjacencyLists()
     * Description  Create adjacency lists for each vertex.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges int[][]
     * @param       numberOfVertices int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void createAdjacencyLists(int[][] edges, int numberOfVertices) 
    {
        for (int i = 0; i < edges.length; i++) 
        {
            addEdge(edges[i][0], edges[i][1]);
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       createAdjacencyLists()
     * Description  Create adjacency lists for each vertex.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges List Edges
     * @param       numberOfVertices int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void createAdjacencyLists(List<Edge> edges, int numberOfVertices) 
    {
        for (Edge edge: edges) 
        {
            addEdge(edge.u, edge.v);
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getSize
     * Description  Overridden method to return number of vertices in the graph.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @return      size int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public int getSize() 
    {
      return vertices.size();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getVertices
     * Description  Overridden method to return number of vertices as a List 
     *              in the graph.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @return      list List V
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public List<V> getVertices() 
    {
      return vertices;
    }

     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getVertex
     * Description  Return the object for the specified vertex.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @return      vertex V
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    @Override
    public V getVertex(int index) 
    {
        return vertices.get(index);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getIndex
     * Description  Return the index for the specified vertex object.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v V
     * @return      index int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    @Override
    public int getIndex(V v) 
    {
        return vertices.indexOf(v);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getNeighbors
     * Description  Return the neighbors of the specified vertex.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       index int
     * @return      neighbors List Integer
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    @Override
    public List<Integer> getNeighbors(int index) 
    {
        List<Integer> result = new ArrayList<>();
        for (Edge e: neighbors.get(index))
            result.add(e.v);

        return result;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getDegree
     * Description  Return the degree for a specified vertex.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v int
     * @return      degree int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    @Override
    public int getDegree(int v) 
    {
        return neighbors.get(v).size();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       printEdges
     * Description  Print the edges.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public void printEdges() 
    {
        for (int u = 0; u < neighbors.size(); u++) 
        {
            System.out.print(getVertex(u) + " (" + u + "): ");
            for (Edge e: neighbors.get(u)) 
            {
                System.out.print("(" + getVertex(e.u) + ", " +
                    getVertex(e.v) + ") ");
            }
            System.out.println();
        }
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayEdges
     * Description  Return the edges as a String.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @return      output String
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    @Override
    public String displayEdges()
    {
        StringBuilder output = new StringBuilder();
        for(int u = 0; u < neighbors.size(); u++)
        {
            output.append(getVertex(u) + " (" + u + "): ");
            for(Edge e : neighbors.get(u))
            {
                output.append("(" + getVertex(e.u) + ", " + getVertex(e.v) + ") ");
            }
            output.append('\n');
        }
        return output.toString();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       clear
     * Description  Clear graph.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    @Override 
    public void clear() 
    {
        vertices.clear();
        neighbors.clear();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       addVertex
     * Description  Add a vertex to the graph.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       vertex V
     * @return      true/false Boolean
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    @Override 
    public boolean addVertex(V vertex) 
    {
        if (!vertices.contains(vertex)) 
        {
            vertices.add(vertex);
            neighbors.add(new ArrayList<Edge>());
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       addEdge
     * Description  Add an edge to the graph.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       e Edge
     * @return      true/false Boolean
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    protected boolean addEdge(Edge e) 
    {
        if (e.u < 0 || e.u > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.u);

        if (e.v < 0 || e.v > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.v);

        if (!neighbors.get(e.u).contains(e)) 
        {
            neighbors.get(e.u).add(e);
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       addEdge
     * Description  Add an edge to the graph.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       u int
     * @param       v int
     * @return      true/false Boolean
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
    @Override 
    public boolean addEdge(int u, int v) 
    {
        return addEdge(new Edge(u, v));
    }

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Class        Edge
     * Description  Edge nested class inside the AbstractGraph class.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static class Edge 
    {
        public int u; // Starting vertex of the edge
        public int v; // Ending vertex of the edge

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Constructor   Edge()-default constructor
        * Description   Construct an edge for (u, v).
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @param        u int
        * @param        v int
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
        public Edge(int u, int v) 
        {
            this.u = u;
            this.v = v;
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method       equals()
         * Description  Overridden method to check equality between edges.
         * @return      true or false Boolean
         * @param       o Object
         * @author      <i>Kirill Grichanichenko</i>
         * Date         11/17/2023 
        *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public boolean equals(Object o) 
        {
            return u == ((Edge)o).u && v == ((Edge)o).v; 
        }
        
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Method       toString()
         * Description  ToString to display the graph.
         * @return      String string
         * @author      <i>Kirill Grichanichenko</i>
         * Date         11/17/2023  
        *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        @Override
        public String toString()
        {
            return "(" + u + ", " + v;
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       dfs
     * Description  Depth-First Search method. Obtain a DFS tree starting from 
     *              vertex vCreates a parents int array and Boolean array for 
     *              the visited vertices. Calls recursive overloaded dfs method. 
     *              Returns a Tree object.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v int
     * @return      tree Tree
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public Tree dfs(int v) 
    {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1; // Initialize parent[i] to -1

        // Mark visited vertices
        boolean[] isVisited = new boolean[vertices.size()];

        // Recursively search
        dfs(v, parent, searchOrder, isVisited);

        // Return a search tree
        return new Tree(v, parent, searchOrder);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       dfs
     * Description  Overloaded Depth-First Search method.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       u int
     * @param       parent int[]
     * @param       searchOrder List<Integer>
     * @param       isVisited Boolean[]
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void dfs(int u, int[] parent, List<Integer> searchOrder,
        boolean[] isVisited) 
    {
        // Store the visited vertex
        searchOrder.add(u);
        isVisited[u] = true; // Vertex v visited

        for (Edge e : neighbors.get(u)) 
        {
            if (!isVisited[e.v]) 
            {
                parent[e.v] = u; // The parent of vertex e.v is u
                dfs(e.v, parent, searchOrder, isVisited); // Recursive search
            }
        }
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       bfs
     * Description  Breadth-First Search method. Obtain a DFS tree starting from 
     *              vertex v. Creates a parents int array and Boolean array for 
     *              the visited vertices. Returns a Tree object.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v int
     * @return      tree Tree
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public Tree bfs(int v) 
    {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
          parent[i] = -1; // Initialize parent[i] to -1

        java.util.LinkedList<Integer> queue =
            new java.util.LinkedList<>(); // list used as a queue
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v); // Enqueue v
        isVisited[v] = true; // Mark it visited

        while (!queue.isEmpty()) 
        {
            int u = queue.poll(); // Dequeue to u
            searchOrder.add(u); // u searched
            for (Edge e: neighbors.get(u)) 
            {
                if (!isVisited[e.v]) 
                {
                    queue.offer(e.v); // Enqueue w
                    parent[e.v] = u; // The parent of w is u
                    isVisited[e.v] = true; // Mark it visited
                }
            }
        }

        return new Tree(v, parent, searchOrder);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Class        Tree
     * Description  Tree inner class inside the AbstractGraph class.
     * Date         11/17/2023 
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public class Tree 
    {
        private int root; // The root of the tree
        private int[] parent; // Store the parent of each vertex
        private List<Integer> searchOrder; // Store the search order

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Constructor   Tree()
        * Description   Construct a tree with root, parent, and searchOrder.
        * Date          11/17/2023
        * History Log   7/18/2018, 5/7/2020
        * @author       <i>Kirill Grichanichenko</i>
        * @param        root int
        * @param        parent int[]
        * @param        searchOrder List
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
        public Tree(int root, int[] parent, List<Integer> searchOrder) 
        {
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method       getRoot
        * Description  Return the root of the tree.
        * Date         11/17/2023 
        * @author      <i>Kirill Grichanichenko</i>
        * @return      root int
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public int getRoot() 
        {
            return root;
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        getParent
        * Description   Return the parent of vertex v.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @param        v int
        * @return       root int
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public int getParent(int v) 
        {
            return parent[v];
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        getSearchOrder
        * Description   Return a list representing search order.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @return       list List
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public List<Integer> getSearchOrder() 
        {
            return searchOrder;
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        getNumberOfVerticesFound
        * Description   Return number of vertices found.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @return       vertices int
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public int getNumberOfVerticesFound() 
        {
            return searchOrder.size();
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        getPath
        * Description   Return the path of vertices from a vertex to the root.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @param        index int
        * @return       vertices List
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
        public List<V> getPath(int index) 
        {
            ArrayList<V> path = new ArrayList<>();

            do 
            {
                path.add(vertices.get(index));
                index = parent[index];
            }
            while (index != -1);

            return path;
        }

        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        printPath
        * Description   Print a path from the root to vertex v.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @param        index int
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public void printPath(int index) 
        {
            List<V> path = getPath(index);
            System.out.print("A path from " + vertices.get(root) + " to " +
                vertices.get(index) + ": ");
            for (int i = path.size() - 1; i >= 0; i--)
                System.out.print(path.get(i) + " ");
        }
        
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        displayPath()
        * Description   Displays the path from the root to vertex v.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @param        index int
        * @return       String string
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        public String displayPath(int index)
        {
            StringBuilder output = new StringBuilder("A path from " + 
                vertices.get(root) + " to " + vertices.get(index) + ": ");
            List<V> path = getPath(index);
            for (int i = path.size() - 1; i >= 0; i--)
                output.append(path.get(i) + " ");
            return output.toString();
        }
        
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        printTree
        * Description   Print the whole tree.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
        public void printTree() 
        {
            System.out.println("Root is: " + vertices.get(root));
            System.out.print("Edges: ");
            for (int i = 0; i < parent.length; i++) 
            {
                if (parent[i] != -1) 
                {
                    // Display an edge
                    System.out.print("(" + vertices.get(parent[i]) + ", " +
                        vertices.get(i) + ") ");
                }
            }
            System.out.println();
        }
        
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * Method        printTree()
        * Description   Print the whole tree using StringBuffer.
        * Date          11/17/2023 
        * @author       <i>Kirill Grichanichenko</i>
        * @param        out StringBuffer
        * @return       StringBuffer stringBuffer
       *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
        public StringBuffer printTree(StringBuffer out)
        {
            out = new StringBuffer(); // Clear
            out.append("Root is: " + vertices.get(root));
            out.append("\nMST Edges: ");
            for(int i = 0; i < parent.length; i++)
            {
                if(parent[i] != -1)
                {
                    out.append("(" + vertices.get(parent[i]) + ", " + vertices.get(i) + ") ");
                }
            }
            out.append("\n");
            return out;
        }
    }
}
