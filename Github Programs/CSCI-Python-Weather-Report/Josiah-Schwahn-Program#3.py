# -----------------------------------------+
# CSCI 127, Joy and Beauty of Data         |
# Program 3: Weather CSV Library           |
# Josiah Schwahn                           |
# Last Modified: Feb 27th, 2019            |
# -----------------------------------------+
# This program takes in a large csv file
# of weather information and finds the
# coldest recording, average temp for a
# given location, the cities in a given
# state and the average percipitation
# for a given month.
# -----------------------------------------+

#Function runs through every line in the CSV file and replaces the current coldest if value
# is less than the current value of coldest.

def coldest_temperature(input_file):
    file = open(input_file, "r")
    file.readline()
    coldest = 0
    location = ""
    date = ""
    
    for line in file:
        info = line.split(",")
        #This if statement is where the replacement happens
        if int(info[-7]) < coldest:
            coldest = int(info[-7])
            location = info[5] + info[6]
            date = info[4]

    file.close()

    print("Coldest Fahrenheit temperature reading: " + str(coldest))
    print("Location: " + location)
    print("Date: " + date)
            

# The average temperature function adds up all the values of the given location argument. It only adds the values
    #  to my average_temp counter if locations match. It counts the readings then divides by the amount of readings.
        # if there are zero readings, it prints the string "not applicable".

def average_temperature(input_file, location):

    location = location.lower()
    file = open(input_file, "r")
    file.readline()
    readings = 0
    average_temp = 0
    average = ""

    for line in file:
        info = line.split('"')
        if location == info[1].lower():
            temp = line.split(",")
            average_temp += int(temp[0])
            readings += 1
    if readings == 0:
        readings = 0
        average = "Not Applicable"
    else:
        average_temp = average_temp/readings
        average = str(average_temp)[0:5]
        
        
    print("Number of Readings: " + str(readings))
    print("Average Temperature: " + average)
            
#The all stations by state function creates a unique list of location and only adds it to the list if it isn't
    # already within the list. The number of stations is the length of the list.
def all_stations_by_state(input_file, location):
    location = location.lower()
    file = open(input_file, "r")
    file.readline()
    cities = []
    for line in file:
        info = line.split(",")
        if info[-3].lower() == location and info[1] not in cities:   
            cities.append(info[1])
    if len(cities) == 0:
        print("There are no recording stations")
    else:
        print('Recorded Stations')
        print("-----------------")       
        x = 1
        for name in cities:
            print(str(x) + ": " + str(name))
            x = x + 1
        
#This function takes in a month, which is an integer typed in by the user (values 1 through 12). It adds up all the
            # precipetation values for the given month, totals and averages them.

    
def precipitation(input_file, month):
    file = open(input_file, "r")
    file.readline()
    precipitation = 0
    total = 0
    dictionary = {1:'January', 2:'February', 3:'March', 4:'April', 5:'May', 6:'June', \
                  7:'July', 8:'August', 9:'September', 10:'October', 11:'November', \
                  12:'December'}
    for line in file:
        info = line.split(",")
        if info[-6] == str(month):
            precipitation = float(precipitation) + float(info[-5])
            total = total + 1
    average = precipitation / total
    print("Total Precipitation = " + str(precipitation)[0:6])

    print("Average precipitation for the month " + str(dictionary[month]) + " is: " + str(average)[0:4])
    
    
    
        







# -----------------------------------------+
# Do not change anything below this line   |
# with the exception of code related to    |
# option 4.                                |
# -----------------------------------------+

# -----------------------------------------+
# menu                                     |
# -----------------------------------------+
# Prints a menu of options for the user.   |
# -----------------------------------------+

def menu():
    print()
    print("1. Identify coldest temperature.")
    print("2. Identify average temperature for a given location.")
    print("3. Identify all recording station locations by state.")
    print("4. Total and Average Precipitation for a given month")
    print("5. Quit.")
    print()

# -----------------------------------------+
# main                                     |
# -----------------------------------------+
# Repeatedly query the user for options.   |
# -----------------------------------------+

def main():
    input_file = "weather.csv"
    choice = 0
    while (choice != 5):
        menu()
        choice = int(input("Enter your choice: "))
        print()
        if (choice == 1):
            coldest_temperature(input_file)
        elif (choice == 2):
            location = input("Enter desired location (e.g. Miles City, MT): ")
            average_temperature(input_file, location)
        elif (choice == 3):
            state = input("Enter name of state (e.g. Montana): ")
            all_stations_by_state(input_file, state)
        elif (choice == 4):
            month = int(input("Enter an interger(1-12) for what month you want to find the average precipitation: "))
            acceptable_input = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
            if str(month) in str(acceptable_input):
                precipitation(input_file, month)
            else:
                print("Try again: ")
        elif (choice != 5):
            print("That is not a valid option.  Please try again.")
    print("Goodbye!")

# -----------------------------------------+

main()
