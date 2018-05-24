package com.controller.addpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.model.FromTimeLoader;
import jp.data.view.AddModelPanel;
import jp.data.view.MainView;

public class RisetDialogHandler implements ActionListener {
	private final JDialog dialog;
	private final JTextField partsField;
	private final JComboBox<String> combo;
	private final DefaultComboBoxModel<String> model;
	private final List<Map<String,String>> modelDataSetList;
	private final List<Map<Integer, String>> partsStreamSet;
	private final JLabel stLabel;
	private final JLabel RemainingParts;
	private final FromTimeLoader fromTimeLoader = FromTimeLoader.getInstance();

	public RisetDialogHandler(List<Map<String,String>> modelDataSetList, List<Map<Integer, String>> partsStreamSet, MainView view, AddModelPanel addPanel) {
		this.dialog = view.getDialog();
		this.partsField = view.getPartsCodeField();
		this.combo = addPanel.getCombo();
		this.model = addPanel.getModel();
		this.modelDataSetList = modelDataSetList;
		this.partsStreamSet = partsStreamSet;
		this.stLabel = addPanel.getStView();
		this.RemainingParts = addPanel.getRemainingParts();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fromTimeLoader.deleteFromTime();
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
