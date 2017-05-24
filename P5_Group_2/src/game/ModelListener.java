package game;

public interface ModelListener {
	
	public void scoreChanged(int newValue);
	
	public void gameFinishedChanged(boolean newValue);
}
