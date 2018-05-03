package jp.data.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ModelSelectComboBoxHandler implements ItemListener{
	private final JTextField partsCodeField;
	private final JComboBox<String> combo;
	private final List<Map<String,String>> modelDataSetList;
	private final JLabel mcName;
	private final JLabel substrateName;
	private final JLabel substrateFace;
	private final JLabel RemainingParts;
	
	
	ModelSelectComboBoxHandler(JTextField partsCodeField,JComboBox<String> combo,List<Map<String,String>> modelDataSetList,
																JLabel mcName,JLabel substrateName,JLabel substrateFace, JLabel RemainingParts){
		this.partsCodeField = partsCodeField;
		this.combo = combo;
		this.modelDataSetList = modelDataSetList;
		this.mcName = mcName;
		this.substrateName = substrateName;
		this.substrateFace = substrateFace;
		this.RemainingParts = RemainingParts;
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
