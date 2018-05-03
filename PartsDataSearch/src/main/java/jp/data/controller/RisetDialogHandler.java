package jp.data.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RisetDialogHandler implements ActionListener {
	private final JDialog dialog;
	private final JTextField partsField;
	private final JComboBox<String> combo;
	private final DefaultComboBoxModel<String> model;
	private final List<Map<String,String>> modelDataSetList;
	private final List<Map<Integer, String>> partsStreamSet;
	private final JLabel stLabel;
	private final JLabel RemainingParts;
	
	public RisetDialogHandler(JDialog dialog,JTextField partsField,JComboBox<String> combo, DefaultComboBoxModel<String> model,
			List<Map<String,String>> modelDataSetList, List<Map<Integer, String>> partsStreamSet,
			JLabel stLabel, JLabel RemainingParts) {
		this.dialog = dialog;
		this.partsField = partsField;
		this.combo = combo;
		this.model = model;
		this.modelDataSetList = modelDataSetList;
		this.partsStreamSet = partsStreamSet;
		this.stLabel = stLabel;
		this.RemainingParts = RemainingParts;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainViewController.fromTime = null;
		partsField.setText("");
		stLabel.setText("");
		RemainingParts.setText("");
		if(! combo.getSelectedItem().equals("モデルを追加してください") && model.getSize() >= 1) {
			int t = model.getSize();
			model.addElement("モデルを追加してください");
		    combo.setSelectedItem("モデルを追加してください");
		    for(int i = 0; i < t; i++) {
				modelDataSetList.remove(0);
				partsStreamSet.remove(0);
		    	model.removeElementAt(0);
				combo.setModel(model);
		    }
		}
		dialog.setVisible(false);
	}

}
