package com.learn.edu4Java;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This creates the ball:
 *		it uses the move() method to move the ball around the screen
 *		and makes sure that the ball does not leave the screen.
 *
 *	it creates the visuals for the ball with the paint() method
 */
public class Ball {
	public static final int BALL_DIAMETER = 30;
	private int posX;
	private int posY;
	private int ya = 1;
	private int xa = 1;
	
	private PlayScreen playingScreen;

	public Ball(PlayScreen playingScreen, int x, int y) {
		this.setPosX(x);
		posY = y;
		this.playingScreen = playingScreen;
	}
	
	/**
	 * move():
	 * Increments ball position to stay in the bounds of the screen.
	 * 
	 *  	bug(s):
	 *  		not yet debugged
	 *  	note(s):
	 *  		may add collision handling 
	 */
	void move() {
		if (posY > playingScreen.getHeight() - 30)//u can't go past the top
			ya = -1;
		if (posY <= 0)//can't go over the bottom
			ya = 1;
		if (posX > playingScreen.getWidth() - 30)//u can go to the far right 
			xa = -1;
		if (posX <= 0)//can't go to far to the left
			xa = 1;
		
		//these increment the position
		posX += xa;
		posY += ya;
	}

	/**
	 * paint():
	 * chooses ball color then creates the ball at a location (x,y) and size.
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.fillOval(getPosX(), posY, BALL_DIAMETER, BALL_DIAMETER);
	}

	
	public int getYa() {
		return ya;
	}

	public void setYa(int ya) {
		this.ya = ya;
	}

	public int getXa() {
		return xa;
	}

	public void setXa(int xa) {
		this.xa = xa;
	}
	
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the x
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param x the x to set
	 */
	public void setPosX(int x) {
		this.posX = x;
	}
	
}