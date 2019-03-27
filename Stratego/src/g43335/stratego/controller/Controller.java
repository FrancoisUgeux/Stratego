package g43335.stratego.controller;

import g43335.stratego.model.Model;
import g43335.stratego.view.View;

/**
 *
 * @author franc
 */
public class Controller {
    private Model game;
    private View view;

    public Controller(Model game, View view) {
        if(game == null || view == null){
            throw new NullPointerException("game and view cannot be null");
        }
        this.game = game;
        this.view = view;
    }
    public void initialize(){
        game.initialize();
        view.initialize();
    }
    public void startGame(){
        view.displayHelp();
        while(!game.isOver()){
            view.displayBoard(game.getBoard());
            view.askCommand();
            if("quit".equals(view.askCommand())){
                
            }
        }
        if(game.isOver()){
            view.displayOver();
        }
    }
}
