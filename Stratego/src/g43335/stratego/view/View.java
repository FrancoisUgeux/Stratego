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
        System.out.println(Color.BLUE + "Welcome to Stratego" + Color.RESET);
    }

    /**
     * Display a goodbye message.
     */
    public void quit() {
        System.out.println();
        System.out.println(Color.BLUE + "See you soon for a new game"
                + Color.RESET);
    }

    /**
     * Display an error message.
     *
     * @param message an error message.
     */
    public void displayError(String message) {
        System.out.println(Color.RED_BACKGROUND + Color.WHITE + message + Color.RESET);
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
    
//    public void displayAskNbSteps(){
//        System.out.println("Enter the number of steps you want (1/2)");
//    }

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
        System.out.println();
        System.out.println("  col# ||  |00|  |01|  |02|  |03|  |04|");
        System.out.println("======================================");
        for (int i = 0; i < squares.length; i++) {
            System.out.print("row#0" + i + " || ");
            for (Square square : squares[i]) {
                if (square.getPiece() == null) {
                    if (square.isLand()) {
                        System.out.print(" |" + Color.WHITE_BACKGROUND
                                + "  " + Color.RESET + "| ");
                    } else {
                        System.out.print(" |" + Color.BLUE_BACKGROUND
                                + "  " + Color.RESET + "| ");
                    }
                } else {
                    if (square.getPiece().getColor() == PlayerColor.BLUE) {
                        ColorPiece = Color.WHITE_BACKGROUND + Color.BLUE;
                    } else {
                        ColorPiece = Color.WHITE_BACKGROUND + Color.RED;
                    }
                    System.out.print(" |" + ColorPiece);
                    displaySelected(square.getPiece());
                    System.out.print(Color.RESET + "| ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Display a message when the game is over. and display the winner(s).
     *
     * @param winners
     */
    public void displayOver(List<Player> winners) {
        for (Player winner : winners) {
            if (winner.getColor() == BLUE) {
                System.out.println(Color.BLUE + "Congratulation "
                        + winner.getColor() + Color.RESET);
            } else {
                System.out.println(Color.RED + "Congratulation "
                        + winner.getColor() + Color.RESET);
            }
            System.out.println(Color.RED + "GAME OVER!" + Color.RESET);
        }
    }

    /**
     * Display a message when the game is over using the command quit so there
     * is no winner yet.
     */
    public void displayOver() {
        System.out.println("\nAre you not entertained ? why would you leave already ?");
        System.out.print(Color.RED + "GAME OVER!" + Color.RESET);
    }

    /**
     * Display the abbreviation of a piece.
     *
     * @param piece the piece to display.
     */
    public void displaySelected(Piece piece) {
        switch (piece.getRank()) {
            case 0:
                System.out.print("FL");
                break;
            case 1:
                System.out.print("SP");
                break;
            case 2:
                System.out.print("SC");
                break;
            case 3:
                System.out.print("DE");
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
                System.out.print("CR");
                break;
            case 8:
                System.out.print("CL");
                break;
            case 9:
                System.out.print("GE");
                break;
            case 10:
                System.out.print("MA");
                break;
            case 11:
                System.out.print("BO");
                break;
        }
    }

    /**
     * Display the full name of a piece with the right color.
     *
     * @param piece the piece to display.
     */
    public void displaySelectedFullName(Piece piece) {
        switch (piece.getRank()) {
            case 0:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue flag");
                } else {
                    System.out.print("Red Flag");
                }
                break;
            case 1:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Spy");
                } else {
                    System.out.print("Red Spy");
                }
                break;
            case 2:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Scout");
                } else {
                    System.out.print("Red Scout");
                }
                break;
            case 3:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Deminer");
                } else {
                    System.out.print("Red Deminer");
                }
                break;
            case 4:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Sergeant");
                } else {
                    System.out.print("Red Sergeant");
                }
                break;
            case 5:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Lieutenant");
                } else {
                    System.out.print("Red Lieutenant");
                }
                break;
            case 6:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Captain");
                } else {
                    System.out.print("Red Captain");
                }
                break;
            case 7:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Commander");
                } else {
                    System.out.print("Red Commander");
                }
                break;
            case 8:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Colonel");
                } else {
                    System.out.print("Red Colonel");
                }
                break;
            case 9:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue General");
                } else {
                    System.out.print("Red General");
                }
                break;
            case 10:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Marshal");
                } else {
                    System.out.print("Red Marshal");
                }
                break;
            case 11:
                if (piece.getColor() == BLUE) {
                    System.out.print("Blue Bomb");
                } else {
                    System.out.print("Red Bomb");
                }
                break;
        }
    }

    /**
     * Display all the moves available for a selected piece.
     *
     * @param moves is the list of moves available.
     */
    public void displayMoves(List<Move> moves) {
        for (int i = 0; i < moves.size(); i++) {
            System.out.print(i + " - ");
            if (moves.get(i).getPiece().getColor() == BLUE) {
                System.out.print(Color.BLUE);
                displaySelectedFullName(moves.get(i).getPiece());
                System.out.print(Color.RESET);
            } else {
                System.out.print(Color.RED);
                displaySelectedFullName(moves.get(i).getPiece());
                System.out.print(Color.RESET);
            }
            System.out.println(" can move to the row "
                    + moves.get(i).getEnd().getRow() + " and the column "
                    + moves.get(i).getEnd().getColumn());
        }
    }

    /**
     * Display the current player.
     *
     * @param player is the current player.
     */
    public void displayCurrentPlayer(Player player) {
        if (player.getColor() == BLUE) {
            System.out.println("your turn" + Color.BLUE
                    + " Blue player" + Color.RESET);
        } else {
            System.out.println("Your turn" + Color.RED
                    + " Red player" + Color.RESET);
        }
    }

    /**
     * Display the selected piece.
     *
     * @param piece the piece to display.
     */
    public void displaySelectedPiece(Piece piece) {
        if (piece.getColor() == BLUE) {
            System.out.print(Color.BLUE);
            displaySelectedFullName(piece);
            System.out.print(Color.RESET);
            System.out.println(" selected");
        } else {
            System.out.print(Color.RED);
            displaySelectedFullName(piece);
            System.out.print(Color.RESET);
            System.out.println(" selected");
        }
    }
}
