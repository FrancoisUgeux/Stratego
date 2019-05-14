package g43335.stratego.model;

import java.util.List;

/**
 *
 * @author G43335
 */
public class Moves {

    private List<Move> history;

    public Moves(List<Move> history) {
        this.history = history;
    }

    public List<Move> getHistory() {
        return history;
    }

    public void add(Move move) {
        history.add(move);
    }

    public Move removeLast() {
        if (history.isEmpty()) {
            throw new IllegalArgumentException("History cannot be empty");
        }
        return history.get(history.size() - 1);
    }

    public boolean lastOwn(Player player) {
        boolean samePlayer = false;
        if (history.get(history.size() - 1).getPiece().getColor()
                == player.getColor());
        {
            samePlayer = true;
        }
        return samePlayer;
    }
}
