package g43335.stratego.view;

import g43335.stratego.model.Square;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class View {

    private Scanner in;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

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
        System.out.println(squares);
    }

    public void displayOver() {
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_RED + "GAME OVER!");
    }
}
