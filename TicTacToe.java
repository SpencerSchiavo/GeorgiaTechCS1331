/* I worked on the homework assignment alone, using only course materials. */

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private int numPlayers;

    public static void main(String[] args) {
        Scanner promptScan = new Scanner(System.in);
        int numberPlayers = getNumberPlayers(promptScan);

        TicTacToe game = new TicTacToe(numberPlayers);
        if (numberPlayers == 1) {
            game.onePlayerGame(promptScan);
        } else {
            game.twoPlayerGame(promptScan);
        }

    }

    public TicTacToe(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    private void onePlayerGame(Scanner sc) {
        Board board = new Board();
        Location loc;
        Location compLoc;
        Random randGen = new Random();
        boolean isLocValid;
        boolean isCompLocValid;
        System.out.println(board.toString());
        while (board.getGameState() == GameState.ONGOING) {
            loc = getInput("1", sc);
            isLocValid = board.isLocValid(loc);
            while (!isLocValid) {
                loc = getInput("1", sc);
                isLocValid = board.isLocValid(loc);
            }
            board.placeLetter(loc, 'X');
            System.out.println(board.toString());
            if (board.getGameState() == GameState.PLAYER1_WIN) {
                System.out.println("Player 1 wins!");
                break;
            } else if (board.getGameState() == GameState.TIE) {
                System.out.println("It's a tie.");
                break;
            }
            System.out.println("The Computer is making a move...");
            compLoc = new Location(randGen.nextInt(2), randGen.nextInt(2));
            isCompLocValid = board.isLocValid(compLoc);
            while (!isCompLocValid) {
                compLoc = new Location(randGen.nextInt(2), randGen.nextInt(2));
                isCompLocValid = board.isLocValid(compLoc);
            }
            board.placeLetter(compLoc, 'O');
            System.out.println(board.toString());
            if (board.getGameState() == GameState.PLAYER2_WIN) {
                System.out.println("Player 2 wins!");
                break;
            } else if (board.getGameState() == GameState.TIE) {
                System.out.println("It's a tie.");
                break;
            }

        }
    }

    private void twoPlayerGame(Scanner sc) {
        Board board = new Board();
        Location loc;
        Random randGen = new Random();
        boolean isLocValid;
        System.out.println(board.toString());
        while (board.getGameState() == GameState.ONGOING) {
            loc = getInput("1", sc);
            isLocValid = board.isLocValid(loc);
            while (!isLocValid) {
                loc = getInput("1", sc);
                isLocValid = board.isLocValid(loc);
            }
            board.placeLetter(loc, 'X');
            System.out.println(board.toString());
            if (board.getGameState() == GameState.PLAYER1_WIN) {
                System.out.println("Player 1 wins!");
                break;
            } else if (board.getGameState() == GameState.TIE) {
                System.out.println("It's a tie.");
                break;
            }
            System.out.println("Player 2's turn...");
            loc = getInput("2", sc);
            isLocValid = board.isLocValid(loc);
            while (!isLocValid) {
                loc = getInput("2", sc);
                isLocValid = board.isLocValid(loc);
            }
            board.placeLetter(loc, 'O');
            System.out.println(board.toString());
            if (board.getGameState() == GameState.PLAYER2_WIN) {
                System.out.println("Player 2 wins!");
                break;
            } else if (board.getGameState() == GameState.TIE) {
                System.out.println("It's a tie.");
                break;
            }
        }
    }



    // Place your methods here

    /********************************************************
     *                                                      *
     *      DO NOT MODIFY CODE BELOW THIS BOX               *
     *                                                      *
     ********************************************************/

   /**
     * Gets number of players from command line
     * @param sc        for reading from command-line
     * @return number of players (always 1 or 2)
     */
    private static int getNumberPlayers(Scanner sc) {
        boolean repeatPrompt = true;
        int numPlayers = 0;
        while (repeatPrompt) {
            System.out.print("How many players (1 or 2)? ");
            String input = sc.next();
            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers == 1 || numPlayers == 2) {
                    repeatPrompt = false;
                } else {
                    System.out.println("Enter 1 or 2 players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please only enter a number.");
            }
        }
        return numPlayers;
    }

   /**
     * Handles scanner calls and user input
     * @param player    whose turn it is
     * @param sc        for reading from command-line
     * @return int[] holding row, column in that order
     */
    private static Location getInput(String player, Scanner sc) {
        boolean repeatPrompt = true;
        int row = -1;
        int col = -1;
        while (repeatPrompt) {
            System.out.print("Enter desired square for " + player + ": ");
            String input = sc.next();
            input = input.trim();
            String[] splitInput = input.split(",");
            try {
                row = Integer.parseInt(splitInput[0]);
                col = Integer.parseInt(splitInput[1]);
                repeatPrompt = false;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please follow the format 'row,col'; for ex '1,2'");
            }
        }
        Location loc = new Location(row, col);
        return loc;
    }

}


