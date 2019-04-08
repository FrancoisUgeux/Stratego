package g43335.stratego.view;

import g43335.stratego.model.Move;
import g43335.stratego.model.Piece;
import g43335.stratego.model.Player;
import g43335.stratego.model.PlayerColor;
import static g43335.stratego.model.PlayerColor.BLUE;
import g43335.stratego.model.Square;
import java.util.List;
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
        System.out.println(ANSI_RED_BACKGROUND + ANSI_WHITE + message + ANSI_RESET);
    }

    /**
     * Display the different available command.
     */
    public void displayHelp() {
        System.out.println("available command :");
        System.out.println("quit: leave the game");
        System.out.println("select row column: select a piece "
                + "at the requested position ");
        System.out.println("moves: display the moves available "
                + "for the selected piece");
        System.out.println("apply movesNumber: move the piece "
                + "with the selected move");
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

    public void displaySelected(Piece piece) {
        switch (piece.getRank()) {
            case 0:
                System.out.print("DR");
                break;
            case 1:
                System.out.print("ES");
                break;
            case 2:
                System.out.print("ÉC");
                break;
            case 3:
                System.out.print("DÉ");
                break;
            case 4:
                System.out.print("SE");
                break;
            case 5:
                System.out.print("LI");
                break;
            case 6:
                System.out.print("CA");
                break;
            case 7:
                System.out.print("CT");
                break;
            case 8:
                System.out.print("CL");
                break;
            case 9:
                System.out.print("GÉ");
                break;
            case 10:
                System.out.print("MA");
                break;
            case 11:
                System.out.print("BO");
                break;
        }
    }

    public void displaySelectedFullName(Piece piece) {
        switch (piece.getRank()) {
            case 0:
                System.out.print("Drapeau");
                break;
            case 1:
                System.out.print("Espion");
                break;
            case 2:
                System.out.print("Éclaireur");
                break;
            case 3:
                System.out.print("Démineur");
                break;
            case 4:
                System.out.print("Sergent");
                break;
            case 5:
                System.out.print("Lieutenant");
                break;
            case 6:
                System.out.print("Capitaine");
                break;
            case 7:
                System.out.print("Commandant");
                break;
            case 8:
                System.out.print("Colonel");
                break;
            case 9:
                System.out.print("Général");
                break;
            case 10:
                System.out.print("Maréchal");
                break;
            case 11:
                System.out.print("Bombe");
                break;
        }
    }

    public void displayMoves(List<Move> moves) {
        for (int i = 0; i < moves.size(); i++) {
            System.out.print(i + " - ");
            if (moves.get(i).getPiece().getColor() == BLUE) {
                System.out.print(ANSI_BLUE);
                displaySelectedFullName(moves.get(i).getPiece());
                System.out.print(ANSI_RESET);
            } else {
                System.out.print(ANSI_RED);
                displaySelectedFullName(moves.get(i).getPiece());
                System.out.print(ANSI_RESET);
            }
            System.out.println(" can move to the row "
                    + moves.get(i).getEnd().getRow() + " and the column "
                    + moves.get(i).getEnd().getColumn());
        }
    }

    public void displayCurrentPlayer(Player player) {
        if (player.getColor() == BLUE) {
            System.out.println("your turn" + ANSI_BLUE
                    + " Blue player" + ANSI_RESET);
        } else {
            System.out.println("Your turn" + ANSI_RED
                    + " Red player" + ANSI_RESET);
        }
    }
}
