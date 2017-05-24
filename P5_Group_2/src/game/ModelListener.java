package game;

public interface ModelListener {
	
	void scoreChanged(int newValue);
	
	void gameFinishedChanged(boolean newValue);
}
