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
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private Scanner in;

    public View(Scanner in) {
        this.in = new Scanner(System.in);
    }

    public void initialize() {
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_BLUE
                + "Welcome to Stratego" + ANSI_RESET);
    }

    public void quit() {
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_BLUE
                + "See you soon for a new game" + ANSI_RESET);
    }

    public void displayError(String message) {
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK
                + message + ANSI_RESET);
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
        for (int i = 0; i < squares.length; i++) {
            System.out.print("row#0" + i + " || ");
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j] == null) {
                    System.out.print(ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET);
                } else{
                    // getColor => variable || 
                    //getcolor = square[i][j].getcolor 
                    System.out.print("|" + ANSI_WHITE_BACKGROUND + squares[i][j] + ANSI_RESET);
                }
            }
        }
        /*
        System.out.println("row#00 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][0] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][0] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][0] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][0] + ANSI_RESET + " |");
        System.out.println("row#01 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][1] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][1] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][1] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][1] + ANSI_RESET + " |");
        System.out.println("row#02 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][2] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][2] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][2] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][2] + ANSI_RESET + " |");
        System.out.println("row#03 || | "
                + ANSI_BLACK_BACKGROUND + squares[0][3] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[1][3] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[2][3] + ANSI_RESET + " | | "
                + ANSI_BLACK_BACKGROUND + squares[3][3] + ANSI_RESET + " |");
        System.out.println();
         */
    }

    public void displayOver() {
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED
                + "GAME OVER!" + ANSI_RESET);
    }
}
