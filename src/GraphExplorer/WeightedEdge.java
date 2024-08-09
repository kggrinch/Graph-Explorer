package GraphExplorer;

/**
 * Class        WeightedEdge.java
 * Description  Extends the Edge class defined in Abstract class and implements
 *              the Comparable interface.
 * Date         11/17/2023
 * @author	<i>Kirill Grichanichenko</i>
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class WeightedEdge extends AbstractGraph.Edge implements Comparable<WeightedEdge>
{
    
    public double weight; // The weight on edge (u, v)
  
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  WeightedEdge()-constructor
     * Description  Create a weighted edge on (u, v).
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       u int
     * @param       v int
     * @param       weight double
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
  public WeightedEdge(int u, int v, double weight)
  {
      super(u, v);
      this.weight = weight;
  }
  
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  WeightedEdge()-constructor
     * Description  Compare two edges on weights.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edge WeightedEdge
     * @return      -1, 0, or 1 int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
  @Override
  public int compareTo(WeightedEdge edge)
  {
      if (weight > edge.weight)
      {
          return 1;
      }
      else if (weight == edge.weight)
      {
          return 0;
      }
      else
      {
          return -1;
      }
  }
  
  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       toString()
     * Description  prints the weightedEdge as toString
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @return      String string
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
  @Override
  public String toString()
  {
      return super.toString() + ", " + weight + "), ";
  }
}
