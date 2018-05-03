package jp.data.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.model.PartsTextFieldModel;
import jp.data.model.RemainingPartsMathModel;
import jp.data.model.StationSearchModel;


//イベントを1回に纏める
class PartsTextFieldHandler implements ActionListener{
	private final List<Map<String,String>> modelDataSetList;
	private final List<Map<Integer, String>> partsStreamSet;
	private final JTextField field;
	private final JLabel stLabel;
	private final JLabel RemainingParts;
	
	public PartsTextFieldHandler(List<Map<String,String>> modelDataSetList,List<Map<Integer, String>> partsStreamSet, JTextField field, JLabel stLabel, JLabel RemainingParts){
		this.modelDataSetList = modelDataSetList;
		this.partsStreamSet = partsStreamSet;
		this.field = field;
		this.stLabel = stLabel;
		this.RemainingParts = RemainingParts;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(modelDataSetList.size() > 0) {
			PartsTextFieldModel textModel = new PartsTextFieldModel(field.getText());
			if(textModel.getValueCode() == 1 || textModel.getValueCode() == 3) {
				String partsName =textModel.getPartsName();
				int st = new StationSearchModel().getStationCode(partsStreamSet, partsName);
				stLabel.setText(st == -1 ? "" :String.valueOf(st));
				//残部品を記述する
				int n =	new RemainingPartsMathModel(MainViewController.fromTime, partsStreamSet).getRemainingPartsNumber();
				RemainingParts.setText("残り" + n + "点");
			}
		}
	}
}
