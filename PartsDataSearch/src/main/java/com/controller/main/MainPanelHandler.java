package com.controller.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class MainPanelHandler implements KeyListener{
	private final JTextField field;

	public MainPanelHandler(JTextField field) {
		this.field = field;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		field.requestFocusInWindow();
		field.setText(String.valueOf(e.getKeyChar()));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
