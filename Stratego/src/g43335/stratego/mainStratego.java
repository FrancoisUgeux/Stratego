package g43335.stratego;

import g43335.stratego.controller.Controller;
import g43335.stratego.model.Game;
import g43335.stratego.view.View;

/**
 * Main class leading the view, controller and game to create and play a match.
 *
 * @author G43335
 */
public class mainStratego {

    /**
     * lead the view, controller and game to create and play a match
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View();
        Controller controller = new Controller(game, view);
        controller.initialize();
        controller.startGame();
    }
}
