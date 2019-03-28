package g43335.stratego.controller;

import g43335.stratego.model.Model;
import g43335.stratego.view.View;

/**
 * This class is used to run the game and the view together
 * @author franc
 */
public class Controller {

    private Model game;
    private View view;

    /**
     *
     * @param game the current instance of the Game
     * @param view the current instance of the View
     */
    public Controller(Model game, View view) {
        if (game == null || view == null) {
            throw new NullPointerException("game and view cannot be null");
        }
        this.game = game;
        this.view = view;
    }

    /**
     *Initialize the game and the view
     */
    public void initialize() {
        game.initialize();
        view.initialize();
    }

    /**
     * start the game and call view to display the different message and the board
     */
    public void startGame() {
        view.displayHelp();
        while (!game.isOver()) {
            view.displayBoard(game.getBoard());
            if ("quit".equals(view.askCommand())) {
                view.displayOver();
                System.exit(0);
            }
        }
        if (game.isOver()) {
            view.displayOver();
        }
    }
}
