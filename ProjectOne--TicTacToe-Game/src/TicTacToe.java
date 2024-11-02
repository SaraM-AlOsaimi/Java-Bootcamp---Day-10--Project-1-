import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("-----Tic Tac Toe game!-----\nWhat is your name?");
            ;
            String userName = input.nextLine();

            System.out.println("Welcome " + userName + "! Let's go...");


            // 2D array instantiation
            // arr.length = rows length
            //arr[0].length = columns length
            // Index in 2D array = arr[row][column]

            //col 0  col 1  col 2
            char[][] arrayBoard = {{'1', '2', '3'},  //row 0
                    {'4', '5', '6'},  // row 1
                    {'7', '8', '9'}};// row 2

            while (true) {
                displayBoard(arrayBoard);
                playerTurn(arrayBoard, input);
                if (checkWin(arrayBoard, 'X')) {
                    break;// End the game if player wins
                }
                // Check for a draw (if all spots are filled)
                if (isBoardFull(arrayBoard)) {
                    System.out.println("It's a draw");
                    break;// End the game if it's a draw
                }
                System.out.println("----------------");
                computerTurn(arrayBoard);
                if (checkWin(arrayBoard, 'O')) {
                    break; // End the game if computer wins
                }
                if (isBoardFull(arrayBoard)) {
                    System.out.println("It's a draw");
                    break;// End the game if it's a draw
                }

            }

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Chose a valid Spot number from (1-9");
        } catch (InputMismatchException e) {
            System.out.println("Enter a number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void displayBoard(char[][] arrayBoard) {
        System.out.println(" | " + arrayBoard[0][0] + " | " + arrayBoard[0][1] + " | " + arrayBoard[0][2] + " | ");
        System.out.println(" |---|---|---| ");
        System.out.println(" | " + arrayBoard[1][0] + " | " + arrayBoard[1][1] + " | " + arrayBoard[1][2] + " | ");
        System.out.println(" |---|---|---| ");
        System.out.println(" | " + arrayBoard[2][0] + " | " + arrayBoard[2][1] + " | " + arrayBoard[2][2] + " | ");
    }

    public static void placement(char[][] arrayBoard , int userSpotChoice , char symbol){

        switch (userSpotChoice) {
            case 1 : arrayBoard[0][0] = symbol;
                break;
            case 2 : arrayBoard[0][1] = symbol;
                break;
            case 3 : arrayBoard[0][2] = symbol;
                break;
            case 4 : arrayBoard[1][0] = symbol;
                break;
            case 5 : arrayBoard[1][1] = symbol;
                break;
            case 6 : arrayBoard[1][2] = symbol;
                break;
            case 7 : arrayBoard[2][0] = symbol;
                break;
            case 8 : arrayBoard[2][1] = symbol;
                break;
            case 9 : arrayBoard[2][2] = symbol;
                break;
        }
    }

    public static boolean checkSpotAvailability(char[][] arrayBoard, int userSpotChoice){
        switch (userSpotChoice) {
            case 1 :
                return (arrayBoard[0][0] == '1');
            case 2 :
                return (arrayBoard[0][1] == '2');
            case 3 :
                return (arrayBoard[0][2] == '3');
            case 4 :
                return (arrayBoard[1][0] == '4');
            case 5 :
                return (arrayBoard[1][1] == '5');
            case 6 :
                return (arrayBoard[1][2] == '6');
            case 7 :
                return (arrayBoard[2][0] == '7');
            case 8 :
                return (arrayBoard[2][1] == '8');
            case 9 :
                return (arrayBoard[2][2] == '9');
            default:
                System.out.println("Please chose a spot for 0 to 9");
        } return false;
    }

    public static void playerTurn(char[][] arrayBoard , Scanner input){
        int userSpotChoice ;
        while (true) {
            System.out.println("Chose a spot :) (1-9)");
            try {
                userSpotChoice = input.nextInt();
                if (checkSpotAvailability(arrayBoard, userSpotChoice)) {
                    placement(arrayBoard, userSpotChoice, 'X');
                    break;
                } else {
                    System.out.println("Spot not available or out of range. Try again.");
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }
    }

    public static void computerTurn(char[][] arrayBoard) {
        // Compute Turn in play .. generate integers
        Random random = new Random();
        int computeTurn;
        do {
            computeTurn = random.nextInt(9) + 1;
        } while (!checkSpotAvailability(arrayBoard, computeTurn));
        placement(arrayBoard, computeTurn,'O');
    }


    // there is eight ways to win in TicTacToe :
    // Three horizontal lines , three vertical lines , two diagonal lines .
    public static boolean checkWin(char[][] arrayBoard, char symbol) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (arrayBoard[i][0] == symbol && arrayBoard[i][1] == symbol && arrayBoard[i][2] == symbol) {
                displayBoard(arrayBoard);
                System.out.println("Congratulations!");
                return true;
            }
            // Check columns
            if (arrayBoard[0][i] == symbol && arrayBoard[1][i] == symbol && arrayBoard[2][i] == symbol) {
                displayBoard(arrayBoard);
                System.out.println("Player " + symbol + " wins!");
                return true;
            }
        }
        // Check diagonals
        if (arrayBoard[0][0] == symbol && arrayBoard[1][1] == symbol && arrayBoard[2][2] == symbol) {
            displayBoard(arrayBoard);
            System.out.println("Player " + symbol + " wins!");
            return true;
        }
        if (arrayBoard[0][2] == symbol && arrayBoard[1][1] == symbol && arrayBoard[2][0] == symbol) {
            displayBoard(arrayBoard);
            System.out.println("Player " + symbol + " wins!");
            return true;
        }

        return false; // No win
    }
    // method to check for a draw
    public static boolean isBoardFull(char[][] arrayBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrayBoard[i][j] != 'X' && arrayBoard[i][j] != 'O') {
                    return false; // Found an empty spot
                }
            }
        }
        return true; // No empty spots left
    }


}
