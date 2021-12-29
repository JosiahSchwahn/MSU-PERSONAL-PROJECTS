package com.company;

/* Outlab 4 on Graphs and Min. Spanning trees
    Author: Josiah Schwahn
    Due Date: March 30th, 2020
 */

// API's used in this program, just imported them all b/c im lazy
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //scanner to read in files
        Scanner fin = new Scanner(new File("/Users/josiah/Library/Preferences/IdeaIC2019.3/scratches/input.txt"));

        int elements = fin.nextInt();

        Graph graph = new Graph(elements);

        //unweighted graph for this outlab
        graph.printGraph("/Users/josiah/Library/Preferences/IdeaIC2019.3/scratches/input.txt");

        graph.BFS(2);
        graph.BFS(5);

        graph.DFS(2);
        graph.DFS(5);

        System.out.println();

        graph.warshall(2);
        graph.warshall(5);

        //weighted graph
        graph.printGraph("/Users/josiah/Library/Preferences/IdeaIC2019.3/scratches/inputw.txt");


        graph.dijkstra(2);


        graph.prim(2);





    }
}
