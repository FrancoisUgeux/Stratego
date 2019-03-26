package g43335.stratego;

import g43335.stratego.controller.Controller;
import g43335.stratego.model.Game;
import g43335.stratego.view.View;

/**
 *
 * @author franc
 */
public class mainStratego {
    public static void main(String[] args) {
        Game game = new game;
        View view = new view;
        Controller controller = new controller(game, view);
        game.start();
    }
}
