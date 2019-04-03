package g43335.stratego.controller;

import g43335.stratego.model.Model;
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
     * start the game and call view to display the different message and the
     * board.
     */
    public void startGame() {
        view.displayHelp();
        while (!game.isOver()) {
            view.displayBoard(game.getBoard());
            String command = view.askCommand();
            Pattern p = Pattern.compile("(\\d)(\\s)(\\d)");
            Matcher m = p.matcher(command);
            if (command.matches("quit|Quit|QUIT")) {
                view.quit();
                view.displayOver();
                System.exit(0);
            } else if (command.matches("select\\s\\d\\s\\d"
                    + "|Select\\s\\d\\s\\d"
                    + "|SELECT\\s\\d\\s\\d")) {
                m.find(); 
                int row = Integer.parseInt(m.group(1));
                int column = Integer.parseInt(m.group(3));                
                game.select(row,column);

            } else {
                view.displayError(" Wrong command please try again ");
                view.displayHelp();
            }
        }
        if (game.isOver()) {
            view.displayOver();
        }
    }
}
