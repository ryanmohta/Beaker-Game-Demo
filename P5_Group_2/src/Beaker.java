import javax.swing.text.Element;

public class Beaker extends Actor { 
	
	public Beaker(Element elem) {
		super(elem);
	}

	private double xPos, yPos;
	private double speed;
	
	//sets the x-position of the beaker to the parameter newpos
	public void setXPos(double newpos) {
		xPos = newpos;
	};
	
	//@return x-position of the beaker
	public double getXPos() {
		return xPos;
	};

	//sets the y-postion of the beaker to the parameter newpos
	public void setYPos(double newpos) {
		yPos = newpos;
	};

	//@return y-position of the beaker
	public double getYPos() {
		return yPos;
	};
	
	//sets the speed of the beaker to newspeed
	public void setSpeed(double newspeed) {
		speed = newspeed;
	};

	//@return speed of the beaker
	public double getSpeed() {
		return speed;
	};

	@Override
	//Moves the beaker from side to side 
	public void act(long now) {
		
	};
 }
