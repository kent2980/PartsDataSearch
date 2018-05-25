package com.controller.addpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.model.FromTimeLoader;
import jp.data.model.PartsDataList;
import jp.data.model.PartsTextFieldModel;
import jp.data.model.RemainingPartsMathModel;
import jp.data.model.StationSearchModel;
import jp.data.view.AddModelPanel;
import jp.data.view.MainView;


/**
 * テキストフィールドに部品コードを入力したときの動作をコントロールするクラス
 * @author kent2
 *
 */
public class PartsTextFieldHandler implements ActionListener{
	private final JTextField field;
	private final JLabel stLabel;
	private final JLabel RemainingParts;
	private LocalDateTime fromTime;
	private final int row;

	/**
	 * コンストラクタ
	 * @param view
	 * @param addPanel
	 * @param row
	 */
	public PartsTextFieldHandler(MainView view, AddModelPanel addPanel, int row){
		this.field = view.getPartsCodeField();
		this.stLabel = addPanel.getStView();
		this.RemainingParts = addPanel.getRemainingParts();
		this.fromTime = FromTimeLoader.getInstance().getFromTime();
		this.row = row;
	}

	/**
	 * 検索結果を表示します
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(PartsDataList.getInstance().getSize() > 0) {
			PartsTextFieldModel textModel = new PartsTextFieldModel(field.getText());
			if(textModel.getValueCode() == 1 || textModel.getValueCode() == 3) {
				String partsName =textModel.getPartsName();
				try {
					int st = new StationSearchModel().getStationCode(PartsDataList.getInstance().getPartsList(row), partsName);
					stLabel.setText(st==-1?"":String.valueOf(st));
				}catch(NullPointerException es) {
					System.out.println("検索対象無し");
				}
				//残部品を記述する
				try {
					int n =	new RemainingPartsMathModel(fromTime, PartsDataList.getInstance().getPartsList(row)).getRemainingPartsNumber();
					RemainingParts.setText("残り" + n + "点");
				}catch(NullPointerException es) {
					System.out.println("検索対象無し");
				}
			}
		}
	}
}
