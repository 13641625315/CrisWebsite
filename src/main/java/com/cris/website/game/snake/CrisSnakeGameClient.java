package com.cris.website.game.snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class CrisSnakeGameClient {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame("CrisSnakeGame");
		Dimension dimension = new Dimension();// 实例化Dimension对象
		dimension.setSize(640, 500);
		jFrame.setSize(dimension);
		jFrame.setBackground(Color.WHITE);

		CrisSnakeGameMenuBar mb = new CrisSnakeGameMenuBar(jFrame);// 创建菜单栏MenuBar
		jFrame.setJMenuBar(mb);

		jFrame.add(new CrisSnakeGameMainPanel(), BorderLayout.CENTER);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}

}
