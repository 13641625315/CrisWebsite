package com.cris.website.game.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CrisSnakeGameMenuBar extends JMenuBar {
	private static final long serialVersionUID = -5835525168933249917L;

	public CrisSnakeGameMenuBar(JFrame jFrame) {
		setPreferredSize(new Dimension(640, 20));
		addMenuSystem(jFrame);
		addMenuAbout(jFrame);
	}

	private void addMenuSystem(JFrame jFrame) {
		JMenu menuSystem = new JMenu("System");
		JMenuItem mItemNew = new JMenuItem("New Game");
		JMenuItem mItemPause = new JMenuItem("Pause");
		JMenuItem mItemExit = new JMenuItem("Exit");
		mItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuSystem.add(mItemNew);
		menuSystem.add(mItemPause);
		// 加入分割线
		menuSystem.addSeparator();
		menuSystem.add(mItemExit);
		this.add(menuSystem);
	}

	private void addMenuAbout(JFrame jFrame) {
		JMenu menuAbout = new JMenu("Other");
		JMenuItem mItemAbout = new JMenuItem("About");
		mItemAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame aboutf = new JFrame("About");
				JLabel lab = new JLabel("CrisSnakeGame V0.1 2017", JLabel.CENTER);
				aboutf.add(lab);
				Dimension aboutd = new Dimension();// 实例化Dimension对象
				aboutd.setSize(350, 180);
				aboutf.setSize(aboutd);
				aboutf.setBackground(Color.WHITE);
				aboutf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				aboutf.setResizable(false);
				aboutf.setLocationRelativeTo(jFrame);
				aboutf.setVisible(true);
			}
		});
		menuAbout.add(mItemAbout);
		this.add(menuAbout);
	}
}
