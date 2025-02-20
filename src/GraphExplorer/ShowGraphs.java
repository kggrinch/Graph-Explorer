package GraphExplorer;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        ShowGraphs.java
 * Description  A class with the only purpose to show the content of the text
 *              files and the corresponding graphs.
 * Date         11/17/2023
 * @author	<i>Kirill Grichanichenko</i>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class ShowGraphs extends javax.swing.JDialog {

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Constructor  ShowGraphs()-default constructor
     * Description  Create an instance of the GUI form with predefined image.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
     * @param       parent Frame
     * @param       modal Boolean
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public ShowGraphs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Constructor  ShowGraphs()-default constructor
     * Description  Create an instance of the GUI form with predefined image.
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *  @param       index int
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public ShowGraphs(int index)
    {
        initComponents();
        this.setModal(true);
        this.setResizable(false);
        this.setTitle("Display WeightedEdgesCities" + index + " Graph"); //Makes sure to edit this title.
        displayGraph(index);
          
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method       displayGraph()
     * Description  Method to resize and show image of the selected graph.
     * @param       index int
     * Date         11/17/2023
     * @author      <i>Kirill Grichanichenko</i>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void displayGraph(int index)
    {
        String imageName = "src/Images/Cities" + index + ".png";
        File imagePicture = new File(imageName);
        if(imagePicture.isFile())
        {
            // Set the graphsJLabel to display the graph
            ImageIcon icon = new ImageIcon(imageName);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(graphsJLabel.getWidth(), graphsJLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);
            graphsJLabel.setIcon(newIcon);
        }
        
        graphsJLabel.setToolTipText(imageName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphsJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Shows Graph");

        graphsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphsJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphsJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel graphsJLabel;
    // End of variables declaration//GEN-END:variables
}
