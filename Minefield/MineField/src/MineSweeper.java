import java.util.Scanner;
import java.util.Random;
public class MineSweeper {
    // Class attributes defined
    int rowNumber, colNumber;
    // Total size of the game grid
    int size;
    // Arrays to represent the game map and board
  String[][] map; //game map
  String[][] board; //user game field
    // Scanner to get user input
    Scanner scan = new Scanner(System.in);
    // Random object for generating random numbers
    Random rnd = new Random();
    // Constructor to initialize the game
    public MineSweeper() {
        // //col and row values will be taken from users
        getSizeFromUser();
        // Create arrays for the game map and board
        this.map = new String[this.rowNumber][this.colNumber];
        this.board = new String[this.rowNumber][this.colNumber];
        // Calculate the total size of the game grid
        this.size = this.rowNumber * this.colNumber;
        // Prepare the game and print the first game board
        prepareGame();
        print(board);
        System.out.println(); // Was used println to see both arrays separately
    }
    // Method for getting the dimensions of the game matrix from the user
       public void getSizeFromUser() {
        System.out.println("You're in minesweeper game");
        System.out.println("Enter the dimension you want to play?");
         while (!isValidMatrixSize()) {
            System.out.println("Please enter the row number: ");
            this.rowNumber = scan.nextInt();
            System.out.println("Please enter the column number: ");
            this.colNumber = scan.nextInt();
        }
    }
    // Method to check whether matrix size is valid or not
    public boolean isValidMatrixSize() {
        if (this.rowNumber >= 2 && this.colNumber >= 2) {
            System.out.println("You Started the Game!");
            return true;
        } else {
            System.out.println("Please enter at least 2x2 matrix size for starting Game!");
            return false;
        }
    }
    // Method to prepare the game by preparing the map and placing mines
    public void prepareGame() {
        prepareMap();
        placeMines();
    }
    // Method to prepare the game map and board as default
    public void prepareMap() {
        for (int i = 0; i < this.rowNumber; i++) {
            for (int j = 0; j < this.colNumber; j++) {
                map[i][j] = " -";
                board[i][j] = " -";
            }
        }
    }
    // was placed mines randomly (number of mine : matris size(rowNumber* colNumber)/4)
    public void placeMines() {
        int randRow, randCol, count=0;
         while(count != (size/4)) {
            randRow = rnd.nextInt(this.rowNumber);
            randCol = rnd.nextInt(this.colNumber);
            if (!map[randRow][randCol].equals(" *")) { // this means there is no mine then can placed mine related place
                map[randRow][randCol] = " *";
                count++; // it keeps limit of mine
            }
        }
    }
    // Method to print the 2D array
    public void print(String[][] arr) {
        for (int i = 0; i < arr.length; i++) { // Are printed multi dimensional array
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " "); // Added space to make it neater
            }
            System.out.println();
        }
    }
    // Method for running the game
    public void run() {
        System.out.println("---Game Started---");
        int uncoveredCellCount = 0;
        while (true) {
            print(board);
            System.out.print("Enter Row: ");
            int row = scan.nextInt();
            System.out.print("Enter Column: ");
            int col = scan.nextInt();
            // Check row and column values are valid
            if (isValidPlace(row, col)) {
                if (board[row][col].equals(" -")) {
                    if (!map[row][col].equals(" *")) {
                        int mineCount = countMine(row, col);
                        board[row][col] = " " + mineCount + "";
                        uncoveredCellCount++;
                    } else {
                        System.out.println(" Game Over!");
                        print(map);
                        break;
                    }
                    // Valid if the player has uncovered all the safe cells and achieved victory in the game.
                    if (uncoveredCellCount == (rowNumber * colNumber - size / 4)) {
                        System.out.println("Great job! You've uncovered all the safe cells!");
                        print(board);
                        break;
                    }
                } else {
                    System.out.println("This cell has already been uncovered. Please pick a different one.");
                }
            } else {
                System.out.println("Invalid row or column. Please enter valid values.");
            }
        }
    }
    // Method to determine the count of mines surrounding a specified cell.
    public int countMine(int row, int col) {
        int mineCount = 0;
        // Loop through the neighboring cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                // Valid if the neighboring cell corresponds to a valid coordinate
                if (isValidPlace(newRow, newCol)) {
                    // Check if the neighboring cell contains a mine
                    if (map[newRow][newCol].equals(" *")) {
                        mineCount++;
                    }
                }
            }
        }
        return mineCount;
    }
    // Established a method to check if a place is valid within the game grid
    public boolean isValidPlace(int row, int col) {
        return (row >= 0 && row < rowNumber) && (col >= 0 && col < colNumber);
    }
}
