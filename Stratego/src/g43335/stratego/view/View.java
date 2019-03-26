package g43335.stratego.view;

import g43335.stratego.model.Square;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class View {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private Scanner in;

    public View(Scanner in) {
        this.in = new Scanner(System.in);
    }

    public void initialize() {
        System.out.println("Welcome to Stratego");
    }

    public void quit() {
        System.out.println("See you soon for a new game");
    }

    public void displayError(String message) {
        System.out.println(message);
    }

    public void displayHelp() {
        System.out.println("available command :");
        System.out.println("quit: quit the game");
    }

    public String askCommand() {
        System.out.println("Please enter your command");
        String command = in.nextLine();
        return command;
    }

    public void displayBoard(Square[][] squares) {
        System.out.println();
        System.out.println("  col# || | 00 | | 01 | | 02 | | 03 |");
        System.out.println("======================================");
        System.out.println("row#00 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][0] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][0] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][0] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][0] + ANSI_RESET + " |");
        System.out.println("row#00 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][1] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][1] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][1] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][1] + ANSI_RESET + " |");
        System.out.println("row#00 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][2] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][2] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][2] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][2] + ANSI_RESET + " |");
        System.out.println("row#00 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][3] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][3] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][3] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][3] + ANSI_RESET + " |");
        System.out.println();
    }

    public void displayOver() {
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED
                + "GAME OVER!" + ANSI_RESET);
    }
}
