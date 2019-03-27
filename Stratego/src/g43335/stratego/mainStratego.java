package g43335.stratego;

import g43335.stratego.controller.Controller;
import g43335.stratego.model.Game;
import g43335.stratego.view.View;
import java.util.Scanner;

/**
 *
 * @author franc
 */
public class mainStratego {
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View();
        Controller controller = new Controller(game, view);
        controller.startGame();  
    }
}
