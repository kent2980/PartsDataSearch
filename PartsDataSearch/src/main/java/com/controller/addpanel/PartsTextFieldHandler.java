package com.controller.addpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.model.FromTimeLoader;
import jp.data.model.PartsTextFieldModel;
import jp.data.model.RemainingPartsMathModel;
import jp.data.model.StationSearchModel;
import jp.data.view.AddModelPanel;
import jp.data.view.MainView;


//イベントを1回に纏める
public class PartsTextFieldHandler implements ActionListener{
	private final List<Map<String,String>> modelDataSetList;
	private final List<Map<Integer, String>> partsStreamSet;
	private final JTextField field;
	private final JLabel stLabel;
	private final JLabel RemainingParts;
	private LocalDateTime fromTime;

	public PartsTextFieldHandler(List<Map<String,String>> modelDataSetList,List<Map<Integer, String>> partsStreamSet, MainView view, AddModelPanel addPanel){
		this.modelDataSetList = modelDataSetList;
		this.partsStreamSet = partsStreamSet;
		this.field = view.getPartsCodeField();
		this.stLabel = addPanel.getStView();
		this.RemainingParts = addPanel.getRemainingParts();
		this.fromTime = FromTimeLoader.getInstance().getFromTime();
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
				int n =	new RemainingPartsMathModel(fromTime, partsStreamSet).getRemainingPartsNumber();
				RemainingParts.setText("残り" + n + "点");
			}
		}
	}
}
