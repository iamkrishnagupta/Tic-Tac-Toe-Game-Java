//Tic Tac Toe Game in JAVA
import java.util.Scanner;
public class TTT {
  public static void main(String[] args) {
    // making the game board
    char[][] gameBoard = new char[3][3];

    // in the beginning all the spaces will be null/empty, so
    for (int row = 0; row < gameBoard.length; row++) {
      for (int column = 0; column < gameBoard[row].length; column++) {
        gameBoard[row][column] = ' '; // initialized as empty
      }
    }
    char player = 'X'; //let first turn gonna be of player X
    boolean gameOver = false; //firstly, gameover method will be false, because the game isn't over yet

    Scanner input = new Scanner(System.in);
    System.out.println(); //empty line
    System.out.println("TIC TAC TOE GAME IN JAVA");
    System.out.println(); //empty line

    while (!gameOver) { //until gameover==true
      printGameBoard(gameBoard); //firstly print the gameboard
      System.out.println();//empty line
      System.out.println("Player " + player + " turn (Please, enter position) :"); 
      //print the player turn
      int row = input.nextInt(); //take input for row
      int column = input.nextInt(); //take input for column

      if (gameBoard[row][column] == ' ') { //we will only place the value if place is empty

        // if empty we literally need to put the element so
        gameBoard[row][column] = player; // player = value (x or o)
        gameOver = playerWon(gameBoard, player); //only we can know if the game has over by kowing if the playerwon or not
        if (gameOver) { //if gameover, print this
          System.out.println();
          System.out.println("GAMEOVER! Player " + player + " won the game.");

        } else { //if not then change the player
          if (player == 'X') {
            player = 'O'; //here
          } else {
            player = 'X'; //or here
          }
        }
      } else {
        System.out.println();
        System.out.println("ERROR : Invalid Move! Please, Try Again."); //if the place wasn't empty we are displaying an error
      }
    }
    System.out.println("Final Board -");
    printGameBoard(gameBoard); //and in the end printing the gameboard
    System.out.println();
  }

  public static boolean playerWon(char[][] gameBoard, char player) { 
    //putting logic in playerwon function 
    //player will only win the game if one row, one column is full of rowXs or Os
    //or diagonally it is also possible

    // this will check the values for rows
    for (int row = 0; row < gameBoard.length; row++) { // or gameBoard[0].length
      if (gameBoard[row][0] == player && gameBoard[row][1] == player && gameBoard[row][2] == player) {
        return true; //if condition matches, return true
      }
    }

    // this will check the values for columns
    for (int column = 0; column < gameBoard.length; column++) {
      if (gameBoard[0][column] == player && gameBoard[1][column] == player && gameBoard[2][column] == player) {
        return true; //if condition matches, return true
      }
    }

    // this will check the values for both diagonals, since even diagonally there are two possibilites
    if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
      return true;
    }
    if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
      return true;
    }
    //otherwise return false
    return false;
  }
  //this is very basic printgameboard method, we are just printing the gameboard by putting some logic
  public static void printGameBoard(char[][] gameBoard) { 
    System.out.println();
    for (int row = 0; row < gameBoard.length; row++) {
      for (int column = 0; column < gameBoard[row].length; column++) {
        System.out.print(gameBoard[row][column] + "  |  ");
      }
      System.out.println(); // since, we need an new line so, this will print a new line after every row
    }
  }
}

//this is it, you're done with it.
//draw on pen and paper for better understanding.
//thank you!