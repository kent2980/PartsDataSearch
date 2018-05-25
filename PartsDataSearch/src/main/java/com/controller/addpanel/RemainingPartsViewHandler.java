package com.controller.addpanel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;

import javax.swing.JLabel;

import jp.data.model.FromTimeLoader;
import jp.data.model.PartsDataList;
import jp.data.model.RemainingPartsMathModel;
import jp.data.view.AddModelPanel;
import jp.data.view.MainView;
import jp.data.view.RemainingPartsView;

/**
 * 
 * @author kent2
 *
 */
public class RemainingPartsViewHandler implements MouseListener{
	private final RemainingPartsView partsView;
	private final JLabel RemainingParts;
	private final LocalDateTime fromTime;
	private final int row;

	public RemainingPartsViewHandler(MainView view, AddModelPanel addPanel, int row){
		this.partsView = view.getPartsView();
		this.RemainingParts = addPanel.getRemainingParts();
		this.fromTime = FromTimeLoader.getInstance().getFromTime();
		this.row = row;
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
		RemainingPartsMathModel math = new RemainingPartsMathModel(fromTime, PartsDataList.getInstance().getPartsList(row));
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
