package com.controller.addpanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.model.PartsDataList;
import jp.data.view.AddModelPanel;
import jp.data.view.MainView;

/**
 * コンボボックスを選択したときの動作をコントロールするクラス
 * @author kent2
 *
 */
public class ModelSelectComboBoxHandler implements ItemListener{
	private final JTextField partsCodeField;
	private final JComboBox<String> combo;
	private final JLabel mcName;
	private final JLabel substrateName;
	private final JLabel substrateFace;
	private final JLabel RemainingParts;
	private final int row;

	/**
	 * コンストラクタ
	 * @param view
	 * @param addPanel
	 * @param row
	 */
	public ModelSelectComboBoxHandler(MainView view, AddModelPanel addPanel, int row){
		this.partsCodeField = view.getPartsCodeField();
		this.combo = addPanel.getCombo();
		this.mcName = addPanel.getMcName();
		this.substrateName = addPanel.getSubstrateName();
		this.substrateFace = addPanel.getSubstrateFace();
		this.RemainingParts = addPanel.getRemainingParts();
		this.row = row;
	}

	/**
	 * 選択された項目の情報を表示します
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(combo.getSelectedItem().equals("モデルを追加してください")){
			mcName.setText("");
			substrateName.setText("");
			substrateFace.setText("");
			RemainingParts.setText("");
		}else {
			if(PartsDataList.getInstance().getSize() > 0) {
				int t = combo.getSelectedIndex();
				if(!combo.getItemAt(0).equals("モデルを追加してください")) {
					mcName.setText(PartsDataList.getInstance().getMcName(row, t));
					substrateName.setText(PartsDataList.getInstance().getSubstrateName(row, t));
					substrateFace.setText(PartsDataList.getInstance().getSubstrateFace(row, t));
					partsCodeField.requestFocus();
				}
			}
		}
	}

}
