package g43335.stratego.view;

import g43335.stratego.model.PlayerColor;
import g43335.stratego.model.Square;
import java.util.Scanner;

/**
 * This class manage all the display for a match.
 *
 * @author g43335
 */
public class View {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private final Scanner in;

    /**
     * Initialize a scanner for the keyboard.
     */
    public View() {
        in = new Scanner(System.in);
    }

    /**
     * Display a welcome message.
     */
    public void initialize() {
        System.out.println(ANSI_BLUE + "Welcome to Stratego" + ANSI_RESET);
    }

    /**
     * Display a goodbye message.
     */
    public void quit() {
        System.out.println(ANSI_BLUE + "See you soon for a new game"
                + ANSI_RESET);
    }

    /**
     * Display an error message.
     *
     * @param message an error message.
     */
    public void displayError(String message) {
        System.out.println(ANSI_RED_BACKGROUND + message + ANSI_RESET);
    }

    /**
     * Display the different available command.
     */
    public void displayHelp() {
        System.out.println("available command :");
        System.out.println("quit: leave the game");
    }

    /**
     * Ask to enter a command and return this command.
     *
     * @return the inputed command as a String.
     */
    public String askCommand() {
        System.out.println("Please enter your command");
        String command = in.nextLine();
        return command;
    }

    /**
     * Display the game board.
     *
     * @param squares represent each case of the board.
     */
    public void displayBoard(Square[][] squares) {
        String ColorPiece;
        System.out.println("  col# ||  |00|  |01|  |02|  |03|");
        System.out.println("======================================");
        for (int i = 0; i < squares.length; i++) {
            System.out.print("row#0" + i + " || ");
            for (Square square : squares[i]) {
                if (square.getPiece() == null) {
                    System.out.print(" |" + ANSI_WHITE_BACKGROUND
                            + "  " + ANSI_RESET + "| ");
                } else {
                    if (square.getPiece().getColor() == PlayerColor.BLUE) {
                        ColorPiece = ANSI_WHITE_BACKGROUND + ANSI_BLUE
                                + "PE" + ANSI_RESET;
                    } else {
                        ColorPiece = ANSI_WHITE_BACKGROUND + ANSI_RED
                                + "PE" + ANSI_RESET;
                    }
                    System.out.print(" |" + ColorPiece + "| ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Display a message when the game is over.
     */
    public void displayOver() {
        System.out.println(ANSI_RED + "GAME OVER!" + ANSI_RESET);
    }
}
