package com.controller.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

import jp.data.model.PartsTextFieldModel;
import jp.data.model.SetPartsTextFieldRecordModel;

public class RecordSetHandler implements ActionListener,FocusListener{
	private final List<Map<String,String>> modelDataSetList;
	private final JTextField field;

	public RecordSetHandler(List<Map<String,String>> modelDataSetList, JTextField field) {
		this.modelDataSetList = modelDataSetList;
		this.field = field;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PartsTextFieldModel textModel = new PartsTextFieldModel(field.getText());
		String partsName =textModel.getPartsName();
		field.setText(partsName);
		if(field.getText().equals("1列目のバーコードを読んでください")) {
			field.setFont(new Font("メイリオ", Font.BOLD, 24));
		}else {
			field.setFont(new Font("Lucida Sans", Font.PLAIN, 50));
		}
		if(modelDataSetList.size() > 0) {
			if(textModel.getValueCode() == 1 || textModel.getValueCode() == 3) {
				String modelName = modelDataSetList.get(0).get("modelName");
				String mcName = modelDataSetList.get(0).get("mcName");
				new SetPartsTextFieldRecordModel(LocalDateTime.now(),partsName,modelName,mcName).setRecord();
			}
		}
		field.selectAll();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if(field.getText().equals("1列目のバーコードを読んでください")) {
			field.setText("");
			field.setFont(new Font("Lucida Sans", Font.PLAIN, 50));
		}
		field.selectAll();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
