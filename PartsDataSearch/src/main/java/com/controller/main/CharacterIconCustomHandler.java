package com.controller.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jp.data.view.RisetDialog;

public class CharacterIconCustomHandler implements MouseListener{
	private JLabel newLabel;
	private static ImageIcon iconDark;
	private static ImageIcon iconLight;
	private final RisetDialog dialog;

	static {
		URL url1 = CharacterIconCustomHandler.class.getResource("/picture/newIcon/mickyDark.png");
		iconDark = new ImageIcon(url1);

		URL url2 = CharacterIconCustomHandler.class.getResource("/picture/newIcon/micky.jpg");
		iconLight = new ImageIcon(url2);
	}

	public CharacterIconCustomHandler(JLabel newLabel ,RisetDialog dialog){
		this.newLabel = newLabel;
		this.dialog = dialog;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		newLabel.setIcon(iconDark);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		newLabel.setIcon(iconLight);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		newLabel.setIcon(iconLight);
		dialog.setVisible(true);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		newLabel.setIcon(iconDark);
	}

}
