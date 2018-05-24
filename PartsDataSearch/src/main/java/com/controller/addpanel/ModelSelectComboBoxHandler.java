package com.controller.addpanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.view.AddModelPanel;
import jp.data.view.MainView;

public class ModelSelectComboBoxHandler implements ItemListener{
	private final JTextField partsCodeField;
	private final JComboBox<String> combo;
	private final List<Map<String,String>> modelDataSetList;
	private final JLabel mcName;
	private final JLabel substrateName;
	private final JLabel substrateFace;
	private final JLabel RemainingParts;


	public ModelSelectComboBoxHandler(List<Map<String,String>> modelDataSetList, MainView view, AddModelPanel addPanel){
		this.partsCodeField = view.getPartsCodeField();
		this.combo = addPanel.getCombo();
		this.modelDataSetList = modelDataSetList;
		this.mcName = addPanel.getMcName();
		this.substrateName = addPanel.getSubstrateName();
		this.substrateFace = addPanel.getSubstrateFace();
		this.RemainingParts = addPanel.getRemainingParts();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(combo.getSelectedItem().equals("モデルを追加してください")){
			mcName.setText("");
			substrateName.setText("");
			substrateFace.setText("");
			RemainingParts.setText("");
		}else {
			if(modelDataSetList.size() > 0) {
				int t = combo.getSelectedIndex();
				if(!combo.getItemAt(0).equals("モデルを追加してください")) {
					Map<String,String> data = modelDataSetList.get(t);
					mcName.setText(data.get("mcName"));
					substrateName.setText(data.get("substrateName"));
					substrateFace.setText(data.get("substrateFace"));
					partsCodeField.requestFocus();
				}
			}
		}
	}

}
