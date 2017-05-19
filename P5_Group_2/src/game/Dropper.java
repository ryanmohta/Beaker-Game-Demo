package game;

import java.awt.event.MouseListener;
import gameEngine.Actor;

public class Dropper extends Actor implements MouseListener {
	private double XPos, YPos;

	public Dropper(int xpos, int ypos){
		super(xpos, ypos, new Image("file:///images/Dropper.png));"));
		this.xPos = xpos;
		this.yPos = ypos;
	}
	
	public void setXPos(double newpos) {
		xPos = newpos;
	}

	public double getXPos() {
		return XPos;
	}

	public void setYPos(double newpos) {
		yPos = newpos;
	}

	public double getYPos() {
		return YPos;
	}

	@Override
	public void act() {
		//method not needed
		
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		LiquidDrop ldrop = new LiquidDrop(e.getX(), e.getY(), 5);
		ldrop.fall();
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		this.setXPos(e.getX());
		this.setYPos(e.getY());
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}