package game;

import java.util.ArrayList;

/**
 * The {@code Model} class is a class that provides data
 * to the {@link BeakerWorld} and {@link Game} classes.
 * This data includes the score for the game and whether
 * or not the game is finished or not.
 *
 * @author Ryan Mohta
 */
public class Model {
	private int score;
	private boolean gameFinished;
	private ArrayList<ModelListener> listeners;

	/**
	 * Initializes a new {@code Model} with a score of {@code 0}.
	 */
	public Model() {
		this(0);
	}

	/**
	 * Initializes a new {@code Model} with the specified score.
	 * @param score the score.
	 */
	public Model(int score) {
		this.score = score;
		this.gameFinished = false;
		listeners = new ArrayList<>();
	}

	/**
	 * Returns the current score.
	 * @return the current score.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the current score to the new score.
	 * Additionally, notifies all the {@link ModelListener}
	 * objects that the score was changed.
	 * @param newScore the new score.
	 */
	public void setScore(int newScore) {
		score = newScore;
		for(ModelListener mL : listeners) {
			mL.scoreChanged(newScore);
		}
	}

	/**
	 * Increases the current score by {@code 1}.
	 */
	public void incrementScore() {
		setScore(score + 1);
	}

	/**
	 * Returns whether or not the game is finished.
	 * @return whether or not the game is finished.
	 */
	public boolean getGameFinished() {
		return gameFinished;
	}

	/**
	 * Sets whether or not the game is finished. Additionally,
	 * notifies all the {@link ModelListener} objects that the
	 * {@code gameFinished} variable was changed.
	 * @param gameFinished whether or not the game is finished.
	 */
	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
		for(ModelListener mL : listeners) {
			mL.gameFinishedChanged(gameFinished);
		}
	}

	/**
	 * Toggles the state of the game being finished or not.
	 */
	public void toggleGameFinished() {
		setGameFinished(!gameFinished);
	}

	/**
	 * Adds the specified {@link ModelListener} to the game.
	 * @param mL the {@link ModelListener} to be added.
	 */
	public void addModelListener(ModelListener mL) {
		listeners.add(mL);
	}
}
