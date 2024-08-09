package GraphExplorer;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Interface    Graph.java
 * Description  Crucial interface in the triad of defining data structures
 *              in Java with interfaces, abstract classes and concrete classes.
 *              The Graph interface provides a number of method to be defined
 *              used by the UnweightedGraph and WeightedGraph class via the 
 *              AbstractGraph class which implements this interface.
 *              concrete classes.
 * Date         11/17/2023
 * @author	<i>Kirill Grichanichenko</i>
 * @param       <V> generic type
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public interface Graph<V> 
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getSize
     * Description  Return the number of vertices in the graph.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @return      size int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getSize();

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getVertices
     * Description  Return the vertices in the graph as a list
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @return      list List
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public java.util.List<V> getVertices();
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getVertices
     * Description  Return the object for the specified vertex index
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       index int
     * @return      vertex V
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/     
    public V getVertex(int index);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getIndex
     * Description  Return the index for the specified vertex object
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v V
     * @return      index int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public int getIndex(V v);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getNeighbors
     * Description  Return the neighbors of vertex with the specified index
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       index int
     * @return      list List
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public java.util.List<Integer> getNeighbors(int index);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       getDegree
     * Description  Return the degree for a specified vertex.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v int
     * @return      degree int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getDegree(int v);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       printEdges
     * Description  Print the edges.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void printEdges();

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayEdges
     * Description  Display the edges as String.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @return      output String
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String displayEdges();
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       clear
     * Description  Clear graph.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void clear();
 
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       addVertex
     * Description  Add a vertex to the graph.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       vertex V
     * @return      true/false boolean
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean addVertex(V vertex);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       addEdge
     * Description  Add an edge to the graph.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       u int
     * @param       v int
     * @return      true/false boolean
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean addEdge(int u, int v);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       dfs
     * Description  Obtain a depth-first search tree.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v int
     * @return      tree Tree
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public AbstractGraph<V>.Tree dfs(int v);

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       bfs
     * Description  Obtain a breadth-first search tree.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       v int
     * @return      tree Tree
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public AbstractGraph<V>.Tree bfs(int v);
}
