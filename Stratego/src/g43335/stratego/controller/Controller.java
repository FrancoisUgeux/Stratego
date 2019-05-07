package g43335.stratego.controller;

import g43335.stratego.model.Model;
import g43335.stratego.model.Move;
import g43335.stratego.model.Player;
import g43335.stratego.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to run the game and the view together.
 *
 * @author g43335
 */
public class Controller {

    private Model game;
    private View view;

    /**
     * assigned a game and view for this instance of controller.
     *
     * @param game the current instance of the Game.
     * @param view the current instance of the View.
     * @throws NullPointerException if the game or the view is null.
     */
    public Controller(Model game, View view) {
        if (game == null || view == null) {
            throw new NullPointerException("game and view cannot be null");
        }
        this.game = game;
        this.view = view;
    }

    /**
     * Initialize the game and the view.
     */
    public void initialize() {
        game.initialize();
        view.initialize();
    }

    /**
     * Start the game and call view to display the different message and the
     * board. Then ask and verify the different command to progress in the game.
     * Select will extract the two int from the command to select a piece. Moves
     * call displayMoves. Apply extract the int from the command and apply the
     * related move.
     */
    public void startGame() {
        view.displayHelp();
        while (!game.isOver()) {
            view.displayBoard(game.getBoard(), game.getCurrent());
            Player current = game.getCurrent();
            view.displayCurrentPlayer(current);
            boolean endTurn = false;
            while (!endTurn) {
                String command = view.askCommand().toLowerCase().trim();
                Pattern p = Pattern.compile("(\\d)(\\s)(\\d)");
                Matcher m = p.matcher(command);
                if (command.matches("quit")) {
                    view.displayOver();
                    view.quit();
                    System.exit(0);
                } else if (command.matches("select\\s\\d\\s\\d")) {
                    try {
                        m.find();
                        int row = Integer.parseInt(m.group(1));
                        int column = Integer.parseInt(m.group(3));
                        game.select(row, column);
                        view.displaySelectedPiece(game.getSelected());
                    } catch (Exception e) {
                        view.displayError(" invalid selection ");
                    }
                } else if (command.matches("moves|move")) {
                    try {
                        view.displayMoves(game.getMoves());
                    } catch (Exception e) {
                        view.displayError(" You must select a piece before ");
                    }
                } else if (command.matches("apply\\s\\d")) {
                    try {
                        Pattern p1 = Pattern.compile("\\d");
                        Matcher m1 = p1.matcher(command);
                        m1.find();
                        int selectedMove = Integer.parseInt(m1.group());
                        if (selectedMove >= 0
                                && selectedMove < game.getMoves().size()) {
                            System.out.println(selectedMove);
                            Move move = game.getMoves().get(selectedMove);
                            game.apply(move);
                            endTurn = true;
                        }
                    } catch (Exception e) {
                        view.displayError(" Invalid command ");
                    }
                } else {
                    view.displayError(" Wrong command please try again ");
                    view.displayHelp();
                }

            }
            if (game.isOver()) {
                view.displayOver(game.getWinners());
            }
        }
    }
}
