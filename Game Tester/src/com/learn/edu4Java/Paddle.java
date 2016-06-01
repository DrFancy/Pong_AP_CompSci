package com.learn.edu4Java;

import java.awt.Color;
import java.awt.Graphics2D;

public class Paddle {
	
	private int posX;
	private int posY;
	private PlayScreen playingScreen;
	public final int PADDLE_WIDTH = 100;
	public final int PADDLE_HIEGHT = 20;
	
	
	public Paddle(PlayScreen playingScreen,int pX) {
		this.playingScreen = playingScreen;
		posX = pX;
	}
	/**
	 * paint():
	 * creates the paddle sprite, chooses position then color, then draws.
	 * 
	 * 	note(s):
	 * 		1. make this a drawn image, created in a photo editor.
	 * @param g
	 */
	public void paint(Graphics2D g){
		posY = this.playingScreen.getHeight() - PADDLE_HIEGHT - 10;
		g.setColor(Color.BLUE);
		g.fillRect(posX, posY, PADDLE_WIDTH, PADDLE_HIEGHT);
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}	
	
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public PlayScreen getplayingScreen() {
		return playingScreen;
	}

}
