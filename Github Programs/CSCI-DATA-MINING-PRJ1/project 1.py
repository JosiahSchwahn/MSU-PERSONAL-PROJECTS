import csv              #get data into a 2d array that can easily be manipualted
import pandas as pd
import numpy as np
import math
import matplotlib.pyplot as plt



data = list(csv.reader(open('/Users/josiah/Desktop/flag.csv')))

#1.) Finds the mean of any numerical column in our data set, user enters
# what column they want by indexing into the data frame

def mean_of_column(data, col):
    
    temp = 0
    
    for i in range(len(data)):    

        temp = int(temp) + int(data[i][col])
        
    temp = temp / len(data)

    return temp

# user can pick which column they want to calculate the mean of
# if the values are intetgers

print("---Problem 1---")

#mean_of_column(data, 3)
    
#2.)

def covariance(data, col_1, col_2):

    mean_col_1 = mean_of_column(data, col_1)
    mean_col_2 = mean_of_column(data, col_2)

    row_total = 0

    for i in range(len(data)):
     
        value_1 = int(data[i][col_1]) - mean_col_1
        value_2 = int(data[i][col_2]) - mean_col_2


        row_total = row_total + (value_1 * value_2)
        

    final = row_total / (len(data) - 1)

    print("The Covariance between column: " + str(col_1) + " and column: " + str(col_2) + " is " + str(final))

    return final

print("---problem 2---")
#covariance(data, 1,1)



#3.) Corelation Function


def correlation(data, col_1, col_2):

    mean1 = mean_of_column(data, col_1)

    mean2 = mean_of_column(data, col_2)
    

    variance1 = 0
    variance2 = 0

    cov = covariance(data, col_1, col_2)


    for i in range(len(data)):

        value_1 = (int(data[i][col_1]) - mean1) * (int(data[i][col_1]) - mean1)
        value_2 = (int(data[i][col_2]) - mean2) * (int(data[i][col_2]) - mean2)

        variance1 = variance1 + value_1
        variance2 = variance2 + value_2

    final_variance = variance1 * variance2
    
    sqrt_final_variance = math.sqrt(final_variance)


    print()

    correlation = cov / sqrt_final_variance

    print("The Correlation is: " + '%.8f'%correlation) 
    return(correlation)


print("---Problem 3---")
#correlation(data, 1, 2)


def range_norm(data, col_1):

    maximum = 0
    minimum = 10000
    temp = 0


    for i in range(len(data)):
        if ((int(data[i][col_1])) < minimum):
            minimum = int(data[i][col_1])
            
        if((int(data[i][col_1])) > maximum):
            maximum = int(data[i][col_1])


    for j in range(len(data)):
        data[j][col_1] = (int(data[j][col_1]) - minimum) / (maximum - minimum)
    

print("---Problem 4---")
#range_norm(data, 3)


def standard_norm(data, col_1):

    mean = mean_of_column(data, col_1)

    total = 0
    

    for i in range(len(data)):

        temp = ((float(data[i][col_1]) - mean)**2)

        total = total + temp

    mean2 = total / len(data)

    standard_deviation = mean2 ** (1/2)

    for j in range(len(data)):

        data[i][col_1] = (float(data[i][col_1]) - mean2) / (standard_deviation)

print("---Problem 5---")
#standard_norm(data, 3)




#--Multivariate-Mean-- (Excluding string variables, columns 0, 17, 28, 29
# are all string variables that we didnt one-hot encode


def multivariate_mean(data):

    multivariate_mean = 0
    
    for i in range(1,17):
        print("Mean of Column " + str(i) + " is = " + str(mean_of_column(data, i)))

        multivariate_mean = multivariate_mean + mean_of_column(data, i)

    for i in range(18,27):
        print("Mean of Column " + str(i) + " is = " + str(mean_of_column(data, i)))

        multivariate_mean = multivariate_mean + mean_of_column(data, i)


    multivariate_mean_total = multivariate_mean / len(data)

    print("Multti variate mean for the flag data is: " + str(multivariate_mean_total))
    return(multivariate_mean_total)
        



#multivariate_mean(data)




def covaraince_matrix(data):

    dataframe = pd.DataFrame(data, columns = ["name","landmass", "zone", "area", "population", "language", "religion",
                                              "bars", "stripes", "colors", "red", "green", "blue", "gold", "white", "black",
                                              "orange", "mainhue", "circles", "crosses", "saltires", "quarters", "sunstars",
                                              "crescent", "triangle", "icon", "animate", "text","topleft", "botright"])

    dropped_data = dataframe.drop(columns = ['topleft','botright','mainhue','name'])
    

    print(dropped_data)

    test = dropped_data.astype(np.float)

    print(np.cov(test.T))

    
    
   
          


#covaraince_matrix(data)


def scatter_plots(data):
    
    dataframe = pd.DataFrame(data, columns = ["name","landmass", "zone", "area", "population", "langauge", "religion",
                                              "bars", "stripes", "colors", "red", "green", "blue", "gold", "white", "black",
                                              "orange", "mainhue", "circles", "crosses", "saltires", "quarters", "sunstars",
                                            "crescent", "triangle", "icon", "animate", "text","topleft", "botright"])
    print(dataframe)
    
    dropped_data = dataframe.drop(columns = ['topleft','botright','mainhue','name'])

    print(dropped_data)

    int_data = dropped_data.astype(np.float)

    

    #plot 1
    
    scatter_plot1 = int_data.plot.scatter(x = "landmass", y = "crosses")

    plt.savefig("pair1.pdf")

    #plot 2

    scatter_plot2 = int_data.plot.scatter(x = "religion", y = "crescent")

    plt.savefig("pair2.pdf")

    #plot 3

    scatter_plot3 = int_data.plot.scatter(x = "langauge", y = "saltires")

    plt.savefig("pair3.pdf")

    #plot 4

    scatter_plot4 = int_data.plot.scatter(x = "area", y = "colors")

    plt.savefig("pair4.pdf")

    #plot 5

    scatter_plot5 = int_data.plot.scatter(x = "population", y = "text")

    plt.savefig("pair5.pdf")

    

    



scatter_plots(data)

    


