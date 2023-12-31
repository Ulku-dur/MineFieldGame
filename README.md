
# MineSweeper Project README

## Introduction
This is a simple console-based implementation of the classic Minesweeper game in Java. The game initializes a minefield based on user-specified dimensions, places mines randomly, and allows the player to uncover cells while avoiding mines.

## Classes

### Main Class
- **Main.java**: The entry point of the program. It creates an instance of the MineSweeper class and calls its `run` method.

### MineSweeper Class
#### Attributes
- `rowNumber`: Number of rows in the game matrix.
- `colNumber`: Number of columns in the game matrix.
- `size`: Total size of the game grid.
- `map`: 2D array representing the game map.
- `board`: 2D array representing the user's game field.
- `scan`: Scanner object for user input.
- `rnd`: Random object for generating random numbers.

#### Methods

##### Constructors
- `MineSweeper()`: Initializes the game by obtaining the dimensions from the user, creating arrays for the game map and board, and preparing the game.

##### User Input
- `getSizeFromUser()`: Prompts the user to enter the dimensions of the game matrix.
- `isValidMatrixSize()`: Checks if the entered matrix size is valid.

##### Game Preparation
- `prepareGame()`: Calls methods to prepare the game map and place mines.
- `prepareMap()`: Initializes the game map and board with default values.
- `placeMines()`: Places mines randomly in the game map.

##### Printing
- `print(String[][] arr)`: Prints a 2D array.

##### Game Logic
- `run()`: Main method to run the game. Manages user input, uncovers cells, and checks for game over or victory.
- `isValidPlace(int row, int col)`: Checks if a given coordinate is within the game grid.
- `countMine(int row, int col)`: Counts the number of mines surrounding a specified cell.

## How to Play
1. Run the program.
2. Enter the desired dimensions for the game matrix (at least 2x2).
3. The game will start, and you can enter row and column coordinates to uncover cells.
4. The game ends if you uncover a mine (Game Over) or successfully uncover all safe cells (Victory).

Have fun playing Minesweeper!
