package g43335.stratego.model;

/**
 *
 * @author franc
 */
public interface Model {

    /**
     *
     */
    void initialize();

    /**
     *
     */
    void start();

    /**
     *
     * @return
     */
    boolean isOver();

    /**
     *
     * @return
     */
    Square[][] getBoard();
}
