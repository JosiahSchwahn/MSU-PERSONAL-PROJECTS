
"""
Part 1: Think about the data
Answer the following questions:
1. [1 point] Why are you interested in this data set?

 - Besides being two wine connoisseur, we were interested in this data to see if there were any relationships between the most 
popular characteristics in different types of wines.

2. [1 point] How many numerical attributes and categorical attributes are there in the data set?

 - 13 Numerical
 - 1 Categorical

3. [1 point] Are there any missing values? If there are missing values, how are you planning to
handle these (will all data instances with missing values be removed? Will all attributes with
missing values be removed? Will missing values be imputed? If so, how?)

 - There are no missing values.

4. Before doing any analysis, answer the following questions:

1. [1 point] Why do you expect clusters to be present in the data?

 - I expect clusters in the data to be present since some attributes are not independent of one another. In other words, if one type of wine
has a high/low value of a given attribute, similar attributes will follow leading to clustering between them.

2. [1 point] Why might finding clusters in this data set be helpful (how might this help us
understand or analyze the data)?

 - It can help us find matching characteristics between wine attributes. For example, this could help a salesman sell different wines based on an individual's preference to easily match them with another similar wine (based on our clustering).

3. [1 point] How many clusters do you expect to see in the data? Provide a range of values
to answer this question. For example, 2 to 4. Why do you expect a number of clusters
in this range?

 - We expect to see around 3-5 clusters for our dataset.

4. [1 point] Do you expect that the clusters will be of similar size (i.e., cluster 1 is about the
same size as cluster 2, is about the same size as cluster 3, etc..)? Why or why not?

 - We don't expect the clusters to be the same size, looking at the range of values in our dataset from a quick glance there is a typical range of where the values sit forming the large clusters and some larger/smaller values that will form smaller outside clusters.


"""

import pandas as pd
import numpy as np
import random



file = "/Users/josiah/Downloads/wine.data"
attribute_names_col = ['Class','Alcohol','Malic acid', 'Ash', 'Alcalinity of Ash', 'Magnesium', 'total phenols', 'Flavanoids', 'Nonflavanoid phenols', 'Proanthocyanins', 'Color intensity', 'Hue', 'OD280/OD315 of diluted wines', 'Proline']


df1 = pd.read_csv(file, names=attribute_names_col) 

#print(df1.head())


def K_means(df1, clusters_k, convergence_parameter):

    #just print the top of the data frame
    #print(df1) 

    X = np.array(df1)


    #gets the amount of clusters and finds random numbers within the range of data set values
    initial_means = random.sample(range(0, len(df1)), clusters_k)
    

    centroids = []
    
    for i in initial_means:
        centroids.append(df1.loc[i])
    

    centroids = np.array(centroids)


    def calc_distance(X1, X2):
        return(sum((X1 - X2)**2))**0.5


    def findClosestCentroids(ic, X):
        assigned_centroid = []
        for i in X:
            distance=[]
            for j in ic:
                distance.append(calc_distance(i, j))
            assigned_centroid.append(np.argmin(distance))
        return assigned_centroid

    def calc_centroids(clusters, X):
        new_centroids = []
        new_df = pd.concat([pd.DataFrame(X), pd.DataFrame(clusters, columns=['cluster'])],
                        axis=1)
        for c in set(new_df['cluster']):
            current_cluster = new_df[new_df['cluster'] == c][new_df.columns[:-1]]
            cluster_mean = current_cluster.mean(axis=0)
            new_centroids.append(cluster_mean)
        return new_centroids


    get_centroids = findClosestCentroids(centroids, X)

    print("This is the intial set of Data and what Clusters they are assigned to\n")
    
    print(get_centroids)
    print("")

    #How many times we want to run the alogorithm/iterations of K-means algo

    for i in range(convergence_parameter):
        get_centroids = findClosestCentroids(centroids, X)
        centroids = calc_centroids(get_centroids, X)
    

    print("This is now the data after " + str(convergence_parameter) + " interations of the K-Means Algo\n")
    
    print(get_centroids)


#K_means(df1, 7, 5)





def DBSCAN(df1):





DBSCAN(df1)