package game;
import gameEngine.*;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

/**
 * {@code Beaker} is an {@code Actor} that is a 
 * cylindrical container. The beaker moves across 
 * the screen from left to right and bounces off the 
 * wall. The beaker is meant to hold {@code LiquidDrop} 
 * objects.
 * 
 * @author Pratha Bodas and Ryan Mohta
 */
public class Beaker extends Actor { 

	private double speed;
	private double startTime;
	private boolean goToRightEdge = true;
	private boolean goToLeftEdge = false;
	private long currTime;
	private TimerHandler clock;

	/**
	 * Creates a new {@code Beaker} with the specified
	 * starting coordinates and speed of {@code 5}.
	 * @param xPos the starting x-coordinate
	 * @param yPos the starting y-coordinate
	 */
	public Beaker(double xPos, double yPos) {
		this(xPos, yPos, 5);
	}

	/**
	 * Creates a new {@code Beaker} with the specified
	 * starting coordinates and speed.
	 * @param startX the starting x-coordinate
	 * @param startY the starting y-coordinate
	 * @param speed the speed of the beaker
	 */
	public Beaker(double startX, double startY, double speed) {
		super(startX, startY, new Image("file:///images/Beaker.png"));
		this.speed = speed;
	}

	/**
	 * Sets the class instance variable {@code speed} to the
	 * parameter {@code newSpeed}.
	 * @param newSpeed the new speed of this beaker.
	 */
	public void setSpeed(double newSpeed) {
		speed = newSpeed;
	};

	/**
	 * Returns the speed of the {@code Beaker}.
	 * @return the speed of the beaker.
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * Moves the beaker from left to right.
	 */
	@Override
	public void act() {
		clock = new TimerHandler();
		startTime = System.nanoTime();
		currTime = System.currentTimeMillis();
		clock.start();	
	}

	private class TimerHandler extends AnimationTimer {
		@Override
		public void handle(long now) {
			long onesec = 1000 * 1000;
			if (((now - startTime)) > onesec) {
				startTime = now;	
				if (getX() == 0) {
					goToRightEdge = true;
					goToLeftEdge = false;
				} else if (getX() == 800) {
					goToRightEdge = false;
					goToLeftEdge = true;
				}
				
				if (goToRightEdge) 
					moveRight(5,0);
				else
					moveLeft(5,0);
				
				currTime = System.currentTimeMillis();
				if (currTime > 300000)
					clock.stop();
			}
		}
	}	

}
	

