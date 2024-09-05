# Graph-Explorer
GUI application that visualizes and interacts with weighted, undirected graphs derived from text file data. The application implements Kruskal’s Algorithm for minimum spanning trees and Dijkstra’s Algorithm for shortest path calculations. Features include graph display, clearing, saving, and graph statistics.

Set-up Instructions:
1. Download the Graph-Explorer-main file into a zip. Graph-Explorer -> Code -> Download zip
2. Extract the zip file into a folder
3. Open any IDE (IntelliJ or Eclipse preferred)
4. Open Project -> Choose the extracted Graph-Explorer-main folder
5. In the IDE go to Graph-Explorer-main -> src -> GraphExplorer -> GraphExplorerGUI -> Set up correct JDK Version if needed -> Run GraphExplorerGUI

User Instructions:
1. The program comes with three files with different edge lists representing graphs as USA states.
2. Choose one of the three files at the top right of the application where it says select file.
3. Button features:

       Go - Will run the selected file and display graphs vertices, edge list, whether it is connected or not, the MST total weight, and the MST edges.
   
       Shortest Path - This will ask the user to enter the first and second vertexes, then display the shortest path from the first vertex to the second and their total distance.
   
       Show Graph - This will display the selected file graph
   
       Save - This will save the shortest path into a separate text file named: ShortestPath.txt - This can be found in Graph-Explorer-main -> src -> Data -> ShortestPath.txt
   
       Clear - This will clear all the displayed data from the application.
   
       Exit - This will close and quit the application

5. Help -> About - This will open up a separate application that explains Graph-Explorer
6. New - This works almost exactly like the select file except that it has all the data files opened to it. Only the files that are in the select files tab work, but feel free the create your own.

For questions or contributions, please contact me at kirillkongrichanichenko@gmail.com
