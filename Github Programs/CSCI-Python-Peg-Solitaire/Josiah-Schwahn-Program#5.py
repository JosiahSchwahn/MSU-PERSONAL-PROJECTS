import numpy as np
import string

# ---------------------------------------
# CSCI 127, Joy and Beauty of Data      |
# Program 5: Peg Rectangle Solitaire    |
# Your Name Josiah Schwahn              |
# Last Modified: April 4th, 2019        |
# ---------------------------------------
# A modified game of Peg Solitaire
# that tests your skills and abilties
# to play the game! It also tells you how
# dumb you are (or maybe that's just me).
# ---------------------------------------

# ---------------------------------------
# Start of PegRectangleSolitaire Class  |
# ---------------------------------------

class PegRectangleSolitaire:

    def __init__(self, rows, columns, empty_row, empty_col):
        self.board = np.full((rows, columns), True)
        self.board[empty_row][empty_col] = False
        self.pegs_left = rows * columns - 1
        
# ---------------------------------------

    def __str__(self):
        answer = "   "
        for column in range(self.board.shape[1]):
            answer += " " + str(column + 1) + "  "
        answer += "\n"
        answer += self.separator()
        for row in range(self.board.shape[0]):
            answer += str(row + 1) + " |"
            for col in range(self.board.shape[1]):
                if self.board[row][col]:
                    answer += " * |"
                else:
                    answer += "   |"
            answer += "\n"
            answer += self.separator()
        return answer
    
# ---------------------------------------

    def separator(self):
        answer = "  +"
        for _ in range(self.board.shape[1]):
            answer += "---+"
        answer += "\n"
        return answer

# ---------------------------------------
# Make Move Method that takes the users input and adjusts the board
# ---------------------------------------

    def make_move(self, row_start, col_start, row_end, col_end):
        mid_row = int((row_start + row_end) / 2)
        mid_col = int((col_start + col_end) / 2)
        self.board[row_start][col_start] = False 
        self.board[row_end][col_end] = True
        self.board[mid_row][mid_col] = False
        self.pegs_left = self.pegs_left - 1
        
# ---------------------------------------
# Legal Move Method that tests in the users make move is legal
# and is a valid move in the rules of Peg Rectangle Solitaire Class
# ---------------------------------------        


    def legal_move(self, row_start, col_start, row_end, col_end):
        mid_row = int((row_start + row_end) / 2)
        mid_col = int((col_start + col_end) / 2)
        x_distance = abs(col_end - col_start)
        y_distance = abs(row_end - row_start)


        if self.board[row_end][col_end] == False:
            if self.board[row_start][col_start] == True: #2nd was row_end befpre
                if self.board[mid_row][mid_col] == True:
                    if x_distance == 2 or y_distance == 2:
                        return True
                
# ---------------------------------------
# Game Won Method that finds if the game is
# finished by counting the remaining pegs|
# ---------------------------------------
    def game_won(self):
        if self.pegs_left == 1:
            return True
       
# ---------------------------------------
# Final Message Method that if either the game is won
# or the user wants to quit, tells you how smart you are
# depedning on the amount of remaining pegs left|
# ---------------------------------------

    def final_message(self):
        if self.pegs_left == 1:
            print("Number of Pegs left: " + str(self.pegs_left))
            print("You're a genius")
        if self.pegs_left == 2:
            print("Number of Pegs left: " + str(self.pegs_left))
            print("You're pretty smart ")
        if self.pegs_left == 3:
            print("Number of Pegs left: " + str(self.pegs_left))
            print("You're just average ")
        if self.pegs_left >= 4:
            print("Number of Pegs left: " + str(self.pegs_left))
            print("You're just plain dumb ")
        
        
        


# ---------------------------------------
# End of PegRectangleSolitaire Class    |
# ---------------------------------------

def get_choice(low, high, message):
    message += " [" + str(low) + " - " + str(high) + "]: "
    legal_choice = False
    while not legal_choice:
        legal_choice = True
        answer = input(message)
        for character in answer:
            if character not in string.digits:
                legal_choice = False
                print("That is not a number, try again.")
                break 
        if legal_choice:
            answer = int(answer)
            if (answer < low) or (answer > high):
                legal_choice = False
                print("That is not a valid choice, try again.")
    return answer

# ---------------------------------------

def main():
    print("Welcome to Peg Rectangle Solitaire!")
    print("-----------------------------------\n")
    
    rows = get_choice(1, 9, "Enter the number of rows")
    columns = get_choice(1, 9, "Enter the number of columns")
    row = get_choice(1, rows, "Enter the empty space row") - 1
    column = get_choice(1, columns, "Enter empty space column") - 1   
    game = PegRectangleSolitaire(rows, columns, row, column)
    print()

    keep_going = "yes"
    print(game)
    while (not game.game_won() and keep_going.lower() == "yes"):
        row_start = get_choice(1, rows, "Enter the row of the peg to move") - 1
        col_start = get_choice(1, columns, "Enter the column of the peg to move") - 1
        row_end = get_choice(1, rows, "Enter the row where the peg lands") - 1
        col_end = get_choice(1, columns, "Enter the column where the peg lands") - 1
        if game.legal_move(row_start, col_start, row_end, col_end):
            game.make_move(row_start, col_start, row_end, col_end)
        else:
            print("Sorry.  That move is now allowed.")
        print()
        print(game)
        if not game.game_won():
            keep_going = input("Do you want to continue (yes or no): ")

    game.final_message()


# ---------------------------------------

main()
