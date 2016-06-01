package com.learn.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShapeTester extends JPanel {
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.fillOval(100, 100,  300, 300);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(100+150, 100+150, 10, 10);
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("my frame");
		ShapeTester shapes = new ShapeTester();
		frame.add(shapes);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
