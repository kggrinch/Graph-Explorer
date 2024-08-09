package GraphExplorer;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        GraphExplorerGUI.java
 * Description  A class representing the GUI used in GraphExplorer
 *              This program reads data from text files and builds WeightedGraph
 *              using vertices as a String ArrayList and an ArrayList of WeightedEdges. The
 *              WeightedEdges DisjointSetClass.kruskalAlgorithm yields an MST from the the graph,
 *              and the ds.dijkstraAlgorithm yields the shortest path tree taking into account
 *              the weights of the graph. 
 * Project      GraphExplorer
 * Date         11/17/2023     
 * @author      <i>Kirill Grichanichenko</i>
 * @see     	javax.swing.JFrame
 * @see     	java.awt.Toolkit            
 *****************************************************************************/
public class GraphExplorerGUI extends javax.swing.JFrame 
{
    private String fileName = "src/Data/WeightedEdgesCities0.txt";
    private final String shortestPathFile = "src/Data/ShortestPath.txt";
    private StringBuffer output = new StringBuffer();
    private List<WeightedEdge> edges;
    private WeightedGraph<Integer> graph;
    private int numberOfVertices = 0;
    private boolean isConnected = false;
    private String shortestPathSaved = "";
    private boolean shortestPathButtonClicked = false;
          
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Constructor  GraphExplorerGUI()-Default Constructor
    * Description  Create an instance of GUI form, set the icon image, set
    *              default button, and instantiate list and graph.
    * @author      <i>Kirill Grichanichenko</i>
    * Date         11/17/2023            
    *****************************************************************************/
    public GraphExplorerGUI() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Images/Cities_small.png"));
        this.getRootPane().setDefaultButton(goJButton);
        edges = new ArrayList<>();
        graph = new WeightedGraph<>(edges, numberOfVertices); 
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * Method       readFromFile()
    * Description  Read text files and create ArrayLists of vertices and edges.
    * @author      <i>Kirill Grichanichenko</i>
    * @param       fileName String
    * Date         11/17/2023      
    *****************************************************************************/
    private void readFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            Scanner inFile = new Scanner(file);
            edges = new ArrayList();
            
            String line = inFile.nextLine();
            numberOfVertices = Integer.parseInt(line);
            
            while(inFile.hasNext())
            {
                line = inFile.nextLine();
                
                String[] tokenizer = line.split("[\\|]");
                
                for(String tokens: tokenizer)
                {
                    String[] token = tokens.split("[,]");
                    int u = Integer.parseInt(token[0].trim());
                    int v = Integer.parseInt(token[1].trim());
                    double w = Double.parseDouble(token[2].trim());
                    
                    edges.add(new WeightedEdge(u, v, w));
                    edges.add(new WeightedEdge(v, u, w));
                    
                }
            }
        }
        catch(FileNotFoundException exp)
        {
            JOptionPane.showMessageDialog(null, "File Not Found", "File not found error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       createGraph()
     * Description  Created WeightedGraph and associated tree and decide if
     *              the graph is connected. If so, invoke GraphExplorer's Algorithm method
     *              on the graph to generate the MST.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023 
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void createGraph()
    {
        resultsJTextArea.setText("");
        output = new StringBuffer();
        
        graph = new WeightedGraph(edges, numberOfVertices);
        
        // Use kruskal's algorithm.
        edges = DisjointSetClass.kruskalsAlgorithm(edges, numberOfVertices);
        output.append("The number of Vertices is " + numberOfVertices + "\n\n");
        
        // Use dfs to get tree.
        AbstractGraph<Integer>.Tree tree = graph.dfs(0);
        output.append(graph.displayWeightedEdges() + "\n");
        
        // Check if connected.
        if(tree.getNumberOfVerticesFound() == numberOfVertices)
        {
            output.append("The graph is connected");
            isConnected = true;
        }
        else
        {
            output.append("The graph is not connected");
            isConnected = false;
        }
        
        // Display the minimum spanning tree.
        StringBuffer out = displayEdges(edges);
        output.append("\n\nMST Total Weight: " + DisjointSetClass.getTotalWeight());
        output.append("\n\nMST Edges:\n" + out.substring(0, out.length() - 2));
        resultsJTextArea.setText(output.toString());
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayEdges()
     * Description  Return a String of all weighted edges.
     * @author      <i>Kirill Grichanichenko</i>
     * @param       edges List WeightedEdge
     * @return      edges StringBuffer
     * Date         11/17/2023    
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public StringBuffer displayEdges(List<WeightedEdge> edges)
    {
        StringBuffer out = new StringBuffer();
        for(int i = 0; i < edges.size(); i++)
            out.append(edges.get(i));
        return out;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        resultsJScrollPane = new javax.swing.JScrollPane();
        resultsJTextArea = new javax.swing.JTextArea();
        fileJLabel = new javax.swing.JLabel();
        fileJComboBox = new javax.swing.JComboBox<>();
        controlJPanel = new javax.swing.JPanel();
        goJButton = new javax.swing.JButton();
        shortestPathJButton = new javax.swing.JButton();
        showGraphJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        exitGButton = new javax.swing.JButton();
        logoJLabel = new javax.swing.JLabel();
        graphExplorerJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        newJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        shortestPathJMenuItem = new javax.swing.JMenuItem();
        showGraphJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        printJMenuItem = new javax.swing.JMenuItem();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph-Explorer");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 204, 204));
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setText("Graph-Explorer");

        resultsJTextArea.setEditable(false);
        resultsJTextArea.setColumns(20);
        resultsJTextArea.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        resultsJTextArea.setLineWrap(true);
        resultsJTextArea.setRows(5);
        resultsJTextArea.setWrapStyleWord(true);
        resultsJScrollPane.setViewportView(resultsJTextArea);

        fileJLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        fileJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileJLabel.setText("Select File:");

        fileJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fileJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WeightedEdgesCities0", "WeightedEdgesCities1", "WeightedEdgesCities2" }));
        fileJComboBox.setToolTipText("Select File");

        controlJPanel.setLayout(new java.awt.GridLayout(6, 1, 6, 6));

        goJButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        goJButton.setText("Go");
        goJButton.setToolTipText("Shows Results");
        goJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(goJButton);

        shortestPathJButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        shortestPathJButton.setText("Shortest Path");
        shortestPathJButton.setToolTipText("Find Shortest Path");
        shortestPathJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortestPathJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(shortestPathJButton);

        showGraphJButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        showGraphJButton.setText("Show Graph");
        showGraphJButton.setToolTipText("Shows Picture of Graph");
        showGraphJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(showGraphJButton);

        saveJButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveJButton.setMnemonic('S');
        saveJButton.setText("Save");
        saveJButton.setToolTipText("Save Shortest Path");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(saveJButton);

        clearJButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Clears Graphs");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(clearJButton);

        exitGButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exitGButton.setText("Exit");
        exitGButton.setToolTipText("Exits Graph-Explorer");
        exitGButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGButtonActionPerformed(evt);
            }
        });
        controlJPanel.add(exitGButton);

        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cities_small.png"))); // NOI18N

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");
        fileJMenu.setToolTipText("Open File");

        newJMenuItem.setMnemonic('N');
        newJMenuItem.setText("New");
        newJMenuItem.setToolTipText("Creates new graph");
        newJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(newJMenuItem);

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clears Graphs");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save");
        saveJMenuItem.setToolTipText("Save Shortest Path");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);

        shortestPathJMenuItem.setMnemonic('h');
        shortestPathJMenuItem.setText("Shortest Path");
        shortestPathJMenuItem.setToolTipText("Find Shortest Path");
        shortestPathJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortestPathJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(shortestPathJMenuItem);

        showGraphJMenuItem.setMnemonic('p');
        showGraphJMenuItem.setText("Show Graph");
        showGraphJMenuItem.setToolTipText("Shows Picture of Graph");
        showGraphJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(showGraphJMenuItem);
        fileJMenu.add(fileJSeparator);

        printJMenuItem.setMnemonic('o');
        printJMenuItem.setText("Print Form");
        printJMenuItem.setToolTipText("Prints GUI ");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        quitJMenuItem.setMnemonic('x');
        quitJMenuItem.setText("Exit");
        quitJMenuItem.setToolTipText("Exits Graph-Explorer");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        graphExplorerJMenuBar.add(fileJMenu);

        helpJMenu.setMnemonic('l');
        helpJMenu.setText("Help");
        helpJMenu.setToolTipText("Open Help");

        aboutJMenuItem.setMnemonic('t');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("Opens About Form");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        graphExplorerJMenuBar.add(helpJMenu);

        setJMenuBar(graphExplorerJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resultsJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fileJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileJComboBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultsJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       newJMenuItemActionPerformed
     * Description  Event handler to chose a separate file for a graph. Also
     *              calls readFromFile and createGraph methods.
     * @param       evt java.awt.event.KeyEvent
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023 
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void newJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newJMenuItemActionPerformed
        try
        {
          JFileChooser chooser = new JFileChooser("src/Data");
          FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt Files", "txt");
          chooser.setFileFilter(filter);
          int choice = chooser.showOpenDialog(null);
          if(choice == JFileChooser.APPROVE_OPTION)
          {
              File chosenFile = chooser.getSelectedFile();
              fileName = "src/Data/" + chosenFile.getName();
              
              String comboBoxName = chosenFile.getName().replaceFirst("[.][^.]+$", "");
              fileJComboBox.setSelectedItem(comboBoxName);
              
              readFile(fileName);
              createGraph();
          }
          else
          {
              JOptionPane.showMessageDialog(null, "Cannot find file", "File Input Error", JOptionPane.WARNING_MESSAGE);
          }
        }
        catch(IllegalArgumentException exp)
        {
            JOptionPane.showMessageDialog(null, "File incorrect Format", "File input Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_newJMenuItemActionPerformed
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       saveJMenuItemActionPerformed()
     * Description  Event handler to save the shortest Path into
     *              a separate text file. 
     * @param       evt java.awt.event.KeyEvent
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        if(shortestPathButtonClicked == false)
        {
            JOptionPane.showMessageDialog(null, "Shortest path has not been found yet", "Save Error!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            try
            {
            FileWriter filePointer = new FileWriter(shortestPathFile, false); 
            PrintWriter writeFile = new PrintWriter(filePointer, false);
           
            writeFile.print(""); // Clear text file.
            String shortestPath = shortestPathSaved;
            writeFile.print(shortestPath);
            
            writeFile.close();
            
            JOptionPane.showMessageDialog(null, "Shortest path saved", "Save Success", JOptionPane.INFORMATION_MESSAGE);
            
            }
            catch(IOException exp)
            {
                JOptionPane.showMessageDialog(null, "Error saving the file.", "Save Error", JOptionPane.ERROR_MESSAGE);
                exp.printStackTrace();
            }
        }
    }//GEN-LAST:event_saveJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       showGraphJMenuItemActionPerformed()
     * Description  Display picture of the two files and the graphs used.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023     
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void showGraphJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphJMenuItemActionPerformed
        int index = fileJComboBox.getSelectedIndex();
        new ShowGraphs(index).setVisible(true);
    }//GEN-LAST:event_showGraphJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       shortestPathJButtonActionPerformed()
     * Description  If the graph is connected, prompt the user to enter two 
     *              vertices and then display the shortest path between the 
     *              two vertices with taking into account the weight.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023      
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void shortestPathJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortestPathJButtonActionPerformed
        shortestPathJMenuItemActionPerformed(evt);
    }//GEN-LAST:event_shortestPathJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       clearJMenuItemActionPerformed()
     * Description  Event handler to clear the form and start anew.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023     
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        fileJComboBox.setSelectedIndex(0);
        resultsJTextArea.setText("");
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       shortestPathJMenuItemActionPerformed()
     * Description  If the graph is connected, prompt the user to enter two 
     *              vertices and then display the shortest path between the 
     *              two vertices with taking into account the weight.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023      
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void shortestPathJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortestPathJMenuItemActionPerformed
        try {
            goJButtonActionPerformed(evt);
            
            // Check if not connected
            if (!isConnected) 
            {
                resultsJTextArea.setText("Graph is not connected");
            } 
            else 
            {
                int v1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first vertex"));
                int v2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second Vertex"));
                goJButton.doClick();
                if(v2 > graph.getSize() - 1 || v2 < 0 || v1 > graph.getSize() - 1 || v1 < 0) // Validate Input
                {
                    JOptionPane.showMessageDialog(null, "Cannot find path", "Path Error!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                     // Get edges from the graph
                    List<WeightedEdge> edges = graph.getEdgesFromGraph();
                    DisjointSetClass ds = new DisjointSetClass();
                    ds.make_set(graph.getSize());
                    
                    // Use Dijkstra's algorithm
                    List<WeightedEdge> shortestPath = ds.dijkstrasAlgorithm(edges, graph.getSize(), v1);
                    
                    // Track path and total weight.
                    List<Integer> path = new ArrayList<>();
                    double shortestPathTotalWeight = 0;
                    int currentVertex = v2;

                    // Rebuild the path.
                    while (currentVertex != v1) 
                    {
                        
                        path.add(currentVertex);
                        int pred = -1;
                        for (WeightedEdge edge : shortestPath) 
                        {
                            
                            if (edge.v == currentVertex) 
                            {
                                pred = edge.u;
                                shortestPathTotalWeight += edge.weight;
                                break;
                            }
                        } 
                        if (pred == -1) 
                        { 
                            break;
                        }
                        currentVertex = pred;
                    }
                    
                    // Display the shortest path.
                    shortestPathSaved = ("The shortest path from (" + v1 + ") to (" + v2 + ") is: " + v1 + ", ");
                    output.append("\n\nThe shortest path from (" + v1 + ") to (" + v2 + ") is: " + v1 + ", ");
                    for (int i = path.size() - 1; i >= 1; i--) 
                    {
                        
                        output.append(path.get(i) + ", ");
                        shortestPathSaved += (path.get(i) + ", ");
                    }
                    
                    output.append(v2);
                    shortestPathSaved += v2;
                    
                    shortestPathSaved += "\nShortest Path Total Weight/Distance: " + shortestPathTotalWeight;
                    output.append("\nShortest Path Total Weight/Distance: " + shortestPathTotalWeight);
                    
                    shortestPathButtonClicked = true;
                    resultsJTextArea.setText(output.toString());
                }
            }
        } 
        catch (HeadlessException | NumberFormatException exp) 
        {
        JOptionPane.showMessageDialog(null, "Cannot find path", "Path Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_shortestPathJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       exitGButtonActionPerformed()
     * Description  Event handler to end the application. Calls the quitJButton
     *              doClick event handler,
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023     
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void exitGButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitGButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       quitJMenuItemActionPerformed()
     * Description  Event handler to end the application.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023      
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       aboutJMenuItemActionPerformed()
     * Description  Event handler to bring up the about GUI form. 
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023      
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        About aboutWindow = new About(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       goJButtonActionPerformed()
     * Description  Event handler to start the application. Calls readFromFile
     *              to read both cities and edges text files and createGraph to
     *              create the weighted graph.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023     
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void goJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goJButtonActionPerformed
       try
       {
           resultsJTextArea.setText("");
           output = new StringBuffer();
           String nameOfFile= fileJComboBox.getSelectedItem().toString();
           fileName = "src/Data/" + nameOfFile + ".txt";
           readFile(fileName);
           createGraph();
       }
       catch(Exception exp)
       {
           JOptionPane.showMessageDialog(null, exp.getMessage(), "Cannot create graph", JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_goJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       showGraphJButtonActionPerformed()
     * Description  Display picture of the two files and the graphs used.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023     
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void showGraphJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphJButtonActionPerformed
        showGraphJMenuItemActionPerformed(evt);
    }//GEN-LAST:event_showGraphJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       clearJButtonActionPerformed()
     * Description  Event handler to clear the form and start anew.
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023      
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        clearJMenuItemActionPerformed(evt);
    }//GEN-LAST:event_clearJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       saveJButtonActionPerformed()
     * Description  Event handler to save the shortest Path into
     *              a separate text file. 
     * @param       evt java.awt.event.KeyEvent
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023 
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        saveJMenuItemActionPerformed(evt);
    }//GEN-LAST:event_saveJButtonActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       printFormJMenuItemActionPerformed()
     * Description  Event handler to print the GUI form. 
     * @author      <i>Kirill Grichanichenko</i>
     * Date         11/17/2023     
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       main()
     * Description  Displays splash screen and the main GUI form.
     * Date         11/17/2023 
     * @param       args are the command line strings
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[]) 
    {
        Splash mySplash = new Splash(4000); // duration = 5 seconds.
        mySplash.showSplash(); // Show splash screen
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphExplorerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JButton exitGButton;
    private javax.swing.JComboBox<String> fileJComboBox;
    private javax.swing.JLabel fileJLabel;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JButton goJButton;
    private javax.swing.JMenuBar graphExplorerJMenuBar;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JMenuItem newJMenuItem;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JScrollPane resultsJScrollPane;
    private javax.swing.JTextArea resultsJTextArea;
    private javax.swing.JButton saveJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JButton shortestPathJButton;
    private javax.swing.JMenuItem shortestPathJMenuItem;
    private javax.swing.JButton showGraphJButton;
    private javax.swing.JMenuItem showGraphJMenuItem;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
