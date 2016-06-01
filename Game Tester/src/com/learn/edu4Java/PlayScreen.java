package com.learn.edu4Java;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/*
 * Expected additions:
 * 	1. make the spawn point of the ball, and paddle random
 * 	2. add a sound(will be toggled by the M), 
 * 	3. back ground timer
 *	4. Pause functionality(game freezes, and the word pause appears on the screen)
 *	5. Increasing game difficulty
 */
public class PlayScreen extends JPanel {

	Ball ball = new Ball(this, 150, 0);
	Paddle paddle = new Paddle(this,30 );
	
	/**
	 * constructor:
	 * creates a KeyListener that takes the input that controls the paddle
	 * and adds it to the screen.
	 */
	public PlayScreen(){
		KeyListener controler = new PaddleConroler(paddle);
		addKeyListener(controler);
		setFocusable(true);
	}
	/**
	 * move():
	 * moves the ball then checks for collisions 
	 * between the ball and the paddle
	 */
	private void move() {
		ball.move();
		checkCollision();
	}
	 
	/**
	 * checkCollision():
	 * checks whether the ball the paddle have touched based on the x and y coordinate values
	 * held by the sprites that represent them, with the addition of Length, width, or diameter when necessary.
	 * First it checks whether the ball is just outside or in the paddle, If this is true then it checks whether
	 * is at the either sides of the paddle.
	 * 
	 * 		bug(s):
	 * 		the ball can get stuck in the paddle if the paddle is move in such
	 * 		a way that the paddle is going in the same direction. 
	 * 			Currently that means the ball gets stuck if the ball collides from the sides
	 * 	 		and the paddle goes in the same x direction.
	 * 				*possible fix* after ever collision have the ball be redrawn outside of the paddle
	 * 		note(s):
	 * 		1. Don't forget to test out the AABB collision:
	 * 			!(paddle.getPosX()+ paddle.PADDLE_WIDTH < ball.getPosX())||(ball.getPosX()+ ball.BALL_WIDTH < paddle.getPosX()||
	 * 			paddle.getPosY() + paddle.PADDLE_HIEGHT < ball.getPosY())||(ball.getPosY()+ ball.BALL_HEIGHT < paddle.getPosY())
	 * 		2. I'm considering moving the collision detecting to another method
	 */
	public void checkCollision(){
		if (
				(ball.getPosY()+ Ball.BALL_DIAMETER >=  paddle.getPosY() && ball.getPosY() <= paddle.getPosY() + paddle.PADDLE_HIEGHT)&&
				(ball.getPosX()+ Ball.BALL_DIAMETER >=  paddle.getPosX() && ball.getPosX() <= paddle.getPosX() + paddle.PADDLE_WIDTH)
			){
			if(
					ball.getPosX()+Ball.BALL_DIAMETER == paddle.getPosX() || 
					ball.getPosX() == paddle.getPosX()+paddle.PADDLE_WIDTH
				){
				ball.setXa(ball.getXa()*-1);
			}else 
				ball.setYa(ball.getYa()*-1);
			}
	}
	
	@Override
	/**
	 * paint():
	 * Overrides the paint in the JComponent class clears the PlayScreen then 
	 * draws smooth edged rectangles and circles
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		paddle.paint(g2d);ball.paint(g2d);
	}
	

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		PlayScreen playingScreen = new PlayScreen();
		frame.add(playingScreen);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			playingScreen.move();
			playingScreen.repaint();
			Thread.sleep(5);
		}
	}
}