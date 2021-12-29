package com.company;


import java.util.*;
import java.io.*;


public class Graph {

    //instance field used to keep track of the seen nodes, the matrix and the size of the matrix
    private boolean seen[];
    private int [][] matrix;
    private int dimensions;


    //constructor for the graph, taking in the file dimensions and turning them into a graph

    Graph(int size){

        this.dimensions = size;

        this.seen = new boolean[this.dimensions];

        this.matrix = new int[this.dimensions][this.dimensions];

    }
    //clears the array of visited nodes so it can be used for multiple methods
    private void clearVisited(){

        for(int i = 0; i < this.seen.length; i++){

            this.seen[i] = false;
        }
    }
    //prints the graph in the format desired
    public void printGraph(String filename) throws FileNotFoundException {

        File file = new File(filename);

        Scanner scanner = new Scanner(file);

        int dimensions = scanner.nextInt();

        System.out.println("Graph: (Adjacency Matrix)");

        while (scanner.hasNextLine()){

            for (int k = 0; k < dimensions; k++){

                for(int p = 0; p < dimensions; p++){

                    this.matrix[k][p] = scanner.nextInt();

                    System.out.print(this.matrix[k][p] + " ");
                }

                System.out.println();

            }

            for(int g = 0; g < dimensions; g++){

                System.out.print("Node " + g + " is connected to: ");

                for(int j = 0; j < dimensions; j++){

                    if(this.matrix[g][j] > 0){

                        System.out.print(j + " ");

                    }

                }

                System.out.println();

            }


        }
    }

    //method for Depth first search algorthim
    public void DFS(int op){

        clearVisited();

        useDFS(op);

        this.seen[op] = false;

        System.out.println("Using DFS and starting from Index " + op + " we can reach indexes =");

        for(int k = 0; k < this.seen.length; k++){

            if(this.seen[k]){

                System.out.print(k + " ");
            }
        }

        System.out.println();

        clearVisited();

    }
    //methond used to find the min. in Dijkstra min spanning tree method
    private int findMinDijkstra(int array[]){

        int smallIndex = -1;

        int small = Integer.MAX_VALUE;

        for(int y = 0; y < array.length; y++){

            if (this.seen[y] == false && array[y] <= small){

                small = array[y];
                smallIndex = y;
            }
        }
        return smallIndex;
    }

    //method used in DFS
    public void useDFS(int j){
        this.seen[j] = true;

         for(int i = 0; i < this.dimensions; i++){

             if(this.matrix[i][j] > 0 && ! this.seen[i]){
                 useDFS(i);
             }
         }
    }

    //Breath first search, search algorithm
    public void BFS(int start){

        boolean seen[] = new boolean[this.dimensions];
        Queue<Integer> a = new LinkedList<>();

        a.add(start);

        int source = start;

        System.out.print("Using BFS and starting at index " + start + " we can reach indexes =");

        while (!a.isEmpty()){

            start = a.remove();
            seen[start] = true;

            for(int i = 0; i < this.dimensions; i++){

                if(this.matrix[i][start] > 0 && !seen[i]){

                    a.add(i);
                }
            }

        }

        System.out.println();
        seen[source] = false;

        for(int j= 0; j < seen.length; j++){

            if(seen[j]){

                System.out.print(j + " ");
            }
        }

        System.out.println();

    }

    // Dijkstra min spanning tree algorithm used to find the shorest path of a square matrix (nodes and graphs)
    public void dijkstra(int start){


        int parents[] = new int[this.dimensions];
        int edge[] = new int[this.dimensions];


        parents[start] = start;

        for(int i = 0; i < this.dimensions; i++){

            edge[i] = Integer.MAX_VALUE;
            this.seen[i] = false;
        }

        edge[start] = 0;


        for(int count = 0; count < this.dimensions - 1; count++){

            int u = findMinDijkstra(edge);

            this.seen[u] = true;

            for(int v = 0; v < this.dimensions; v++){

                if(!seen[v] && this.matrix[u][v] != 0 && edge[u] != Integer.MAX_VALUE && edge[u] + matrix[u][v] < edge[v]){

                    edge[v] = edge[u] + this.matrix[u][v];
                    parents[v] = u;
                }
            }
        }


        for(int i = 0; i < this.dimensions; i++){

            if (start != i && edge[i] != Integer.MAX_VALUE){

                System.out.println("Using Dijkstra, the shortest path from node # " + start + " to the node # " + i + "has a weight of " + edge[i] + " with a path ");
                path(parents, i, start);
                System.out.println();

            } else if (start != i && edge[i] == Integer.MAX_VALUE){

                System.out.println("Using Dijkstra, the shortest path from node # " + start + " to the node # " + i + " has a weight of 0: no path");
            }
        }

        System.out.println();
    }
    // prints the paths between two nodes if there is one
    public void path(int array[], int orgin, int start){

        if(orgin == start){
            System.out.print(orgin + " ");
            return;
        }

        path(array, array[orgin], start);
        System.out.print(orgin + " ");


    }


    // WARSHALL spanning tree search algorithm used to find the shortest path between a weighted graph
    public void warshall(int start){

        boolean possible[][] = new boolean[dimensions][dimensions];

        System.out.println("Using Warshall's, the nodes we can reach from " + start + " are:");

        for(int i = 0; i < this.dimensions; i++){

            for(int j = 0; j < this.dimensions; j++){

                if(this.matrix[i][j] > 0){

                    possible[i][j] = true;
                }
            }

        }

        for(int b = 0; b < this.dimensions; b++){

            for(int c = 0; c < this.dimensions; c++){

                for(int j = 0; j < this.dimensions; j++){

                    if(!possible[c][j]){

                        possible[c][j] = possible[c][b] && possible[b][j];

                    }
                }
            }
        }


        for(int i = 0; i < this.dimensions; i++){

            if(possible[start][i] && start != i){

                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    // Prim greedy algorithm used to find the min spanning tree for a unweighted undirected graph.
    public void prim(int start){

        boolean flag = true;


        boolean seen[] = new boolean[this.dimensions];

        int smallIndex = -1;
        seen[start] = true;

        int small = Integer.MAX_VALUE;


        String string = "";


        System.out.println("Using Prim, the MST starting point form the node # " + start + " is:");

        while (flag){

            small = Integer.MAX_VALUE;

            for(int t = 0; t < this.dimensions; t++){

                if(seen[t]){

                    for(int i = 0; i < this. dimensions; i++){

                        if(this.matrix[t][i] <= small && !seen[i] && matrix[t][i] != 0){

                            small = this.matrix[t][i];
                            smallIndex = i;

                            string = ("From " + t + " to " + i + " with a weight of " + small);
                        }

                    }

                }
            }

            seen[smallIndex] = true;

            if(small == Integer.MAX_VALUE){

                flag = false;

            } else {

                System.out.println(string);
            }

        }

    }



}
