package com.learn.edu4Java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// Considering making this an anonymous class
public class PaddleConroler implements KeyListener {
	private Paddle ponger;
	private int RIGHT_KEY = 39,LEFT_KEY = 37;
	public PaddleConroler(Paddle pon){
		ponger = pon;
	}
	
	@Override
	/**
	 * KeyPressed(KeyEvent e):
	 * moves the paddle to the left and to the right, a certain amount of pixels.
	 * conditions keep paddle from exiting the screen.
	 * note(s):
	 * 	I don't like the button responsiveness
	 */
	public void keyPressed(KeyEvent e) {
		if((e.getKeyCode() == LEFT_KEY) && (ponger.getPosX()> 0 ))
			ponger.setPosX( ponger.getPosX()-10);
		if ((e.getKeyCode() == RIGHT_KEY) && (ponger.getPosX() < ponger.getplayingScreen().getWidth() - ponger.PADDLE_WIDTH))
			ponger.setPosX( ponger.getPosX()+10);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
