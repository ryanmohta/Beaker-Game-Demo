package game;

/**
 * An interface for listeners of the {@link Model} class.
 *
 * @author Ryan Mohta
 */
public interface ModelListener {

	/**
	 * Performs a certain action when the score is changed.
	 */
	void scoreChanged(int newValue);

	/**
	 * Performs a certain action when the state of the game
	 * being finished is changed.
	 */
	void gameFinishedChanged(boolean newValue);
}
