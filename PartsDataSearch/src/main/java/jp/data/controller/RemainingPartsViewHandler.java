package jp.data.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import jp.data.model.RemainingPartsMathModel;
import jp.data.view.RemainingPartsView;

public class RemainingPartsViewHandler implements MouseListener{
	private final RemainingPartsView partsView;
	private final JLabel RemainingParts;
	private final List<Map<Integer, String>> partsStreamSet;
	
	RemainingPartsViewHandler(RemainingPartsView partsView, JLabel RemainingParts, List<Map<Integer, String>> partsStreamSet){
		this.partsView = partsView;
		this.RemainingParts = RemainingParts;
		this.partsStreamSet = partsStreamSet;
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
		RemainingPartsMathModel math = new RemainingPartsMathModel(MainViewController.fromTime, partsStreamSet);
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
