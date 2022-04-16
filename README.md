# tictactoe
Goal: To create a working, player vs ai tic-tac-toe game using Java, using only linear data structures and the minimax algorithm. The goal is to design the game such that the player never wins.

Logic: 
- Create a 2d 3x3 string array that starts with dashes in each position
- Create a loop that alternates between the X player and computer, and allows the player to input an integer that corresponds to their desired position of input
- Keep checking if the game has been won by X or O using a suitable algorithm
- create the minimax method that uses the recursive minimax algorithm to find the best move for computer
- the game can never be won by the player
