package com.controller.addpanel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import jp.data.model.FromTimeLoader;
import jp.data.model.RemainingPartsMathModel;
import jp.data.view.AddModelPanel;
import jp.data.view.MainView;
import jp.data.view.RemainingPartsView;

public class RemainingPartsViewHandler implements MouseListener{
	private final RemainingPartsView partsView;
	private final JLabel RemainingParts;
	private final List<Map<Integer, String>> partsStreamSet;
	private final LocalDateTime fromTime;

	public RemainingPartsViewHandler(List<Map<Integer, String>> partsStreamSet, MainView view, AddModelPanel addPanel){
		this.partsView = view.getPartsView();
		this.RemainingParts = addPanel.getRemainingParts();
		this.partsStreamSet = partsStreamSet;
		this.fromTime = FromTimeLoader.getInstance().getFromTime();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		RemainingParts.setForeground(new Color(240,70,80));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		RemainingParts.setForeground(new Color(0,0,0));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		RemainingPartsMathModel math = new RemainingPartsMathModel(fromTime, partsStreamSet);
		Object[][] data = math.getRemainingPartsList();
		Object[] column = {"ST","部品コード"};
		partsView.setTableModel(data, column);
		partsView.setVisible(true);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
