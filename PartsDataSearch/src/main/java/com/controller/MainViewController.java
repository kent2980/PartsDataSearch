package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.controller.addpanel.AddExcelDataFileHandler;
import com.controller.addpanel.DeleteModelIconCustomHandler;
import com.controller.addpanel.ModelSelectComboBoxHandler;
import com.controller.addpanel.PartsTextFieldHandler;
import com.controller.addpanel.RemainingPartsViewHandler;
import com.controller.addpanel.RisetDialogHandler;
import com.controller.main.CharacterIconCustomHandler;
import com.controller.main.MainPanelHandler;
import com.controller.main.RecordSetHandler;

import jp.data.view.AddModelPanel;
import jp.data.view.MainView;
import jp.data.view.RisetDialog;

public class MainViewController {
	private final JPanel MainPanel;
	private final JTextField partsCodeField;
	private final JLabel newLabel;
	private final RisetDialog dialog;
	private final JButton OkButton;
	private final JButton NgButton;
	//【モデル1】
	private static List<Map<String,String>> modelDataSetList1;
	private static List<Map<Integer, String>> partsStreamSet1;
	private final AddModelPanel addPanel1;
	private final JButton add1Button;
	private final JComboBox<String> combo1;
	private final JLabel batuLabel1;
	private final JLabel RemainingParts1;
	//【モデル2】
	private static List<Map<String,String>> modelDataSetList2;
	private static List<Map<Integer, String>> partsStreamSet2;
	private final AddModelPanel addPanel2;
	private final JButton add2Button;
	private final JComboBox<String> combo2;
	private final JLabel batuLabel2;
	private final JLabel RemainingParts2;
	//【モデル3】
	private static List<Map<String,String>> modelDataSetList3;
	private static List<Map<Integer, String>> partsStreamSet3;
	private final AddModelPanel addPanel3;
	private final JButton add3Button;
	private final JComboBox<String> combo3;
	private final JLabel batuLabel3;
	private final JLabel RemainingParts3;
	//【モデル4】
	private static List<Map<String,String>> modelDataSetList4;
	private static List<Map<Integer, String>> partsStreamSet4;
	private final AddModelPanel addPanel4;
	private final JButton add4Button;
	private final JComboBox<String> combo4;
	private final JLabel batuLabel4;
	private final JLabel RemainingParts4;

	static {
		modelDataSetList1 = new ArrayList<>();
		modelDataSetList2 = new ArrayList<>();
		modelDataSetList3 = new ArrayList<>();
		modelDataSetList4= new ArrayList<>();
		partsStreamSet1 = new ArrayList<>();
		partsStreamSet2 = new ArrayList<>();
		partsStreamSet3 = new ArrayList<>();
		partsStreamSet4 = new ArrayList<>();
	}

	public MainViewController(MainView view){
		this.MainPanel = view.getMainPanel();
		this.partsCodeField = view.getPartsCodeField();
		this.newLabel = view.getNewLabel();
		this.dialog = view.getDialog();
		this.OkButton = view.getDialog().getOkButton();
		this.NgButton = view.getDialog().getNgButton();
		//【モデル1】
		this.addPanel1 = view.getAddPanel1();
		this.add1Button = view.getAddPanel1().getAddButton();
		this.combo1 = view.getAddPanel1().getCombo();
		this.batuLabel1 = view.getAddPanel1().getBatuLabel();
		this.RemainingParts1 = view.getAddPanel1().getRemainingParts();
		//【モデル2】
		this.addPanel2 = view.getAddPanel2();
		this.add2Button = view.getAddPanel2().getAddButton();
		this.combo2 = view.getAddPanel2().getCombo();
		this.batuLabel2 = view.getAddPanel2().getBatuLabel();
		this.RemainingParts2 = view.getAddPanel2().getRemainingParts();
		//【モデル3】
		this.addPanel3 = view.getAddPanel3();
		this.add3Button = view.getAddPanel3().getAddButton();
		this.combo3 = view.getAddPanel3().getCombo();
		this.batuLabel3 = view.getAddPanel3().getBatuLabel();
		this.RemainingParts3 = view.getAddPanel3().getRemainingParts();
		//【モデル4】
		this.addPanel4 = view.getAddPanel4();
		this.add4Button = view.getAddPanel4().getAddButton();
		this.combo4 = view.getAddPanel4().getCombo();
		this.batuLabel4 = view.getAddPanel4().getBatuLabel();
		this.RemainingParts4 = view.getAddPanel4().getRemainingParts();

		//アクションリスナーの設定
		MainPanel.addKeyListener(new MainPanelHandler(partsCodeField));
		partsCodeField.addActionListener(new RecordSetHandler(modelDataSetList1,partsCodeField));
		partsCodeField.addFocusListener(new RecordSetHandler(modelDataSetList1,partsCodeField));
		newLabel.addMouseListener(new CharacterIconCustomHandler(newLabel,dialog));
		NgButton.addActionListener(event -> dialog.setVisible(false));

		//【モデル1】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList1, partsStreamSet1,view, addPanel1));
		OkButton.addActionListener(new RisetDialogHandler(modelDataSetList1, partsStreamSet1, view, addPanel1));
		add1Button.addActionListener(new AddExcelDataFileHandler(view, addPanel1, 1));
		combo1.addItemListener(new ModelSelectComboBoxHandler(modelDataSetList1, view, addPanel1));
		batuLabel1.addMouseListener(new DeleteModelIconCustomHandler(modelDataSetList1, partsStreamSet1, addPanel1));
		RemainingParts1.addMouseListener(new RemainingPartsViewHandler(partsStreamSet1, view, addPanel1));
		//【モデル2】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList2, partsStreamSet2,view, addPanel2));
		OkButton.addActionListener(new RisetDialogHandler(modelDataSetList2, partsStreamSet2, view, addPanel2));
		add2Button.addActionListener(new AddExcelDataFileHandler(view, addPanel2, 2));
		combo2.addItemListener(new ModelSelectComboBoxHandler(modelDataSetList2, view, addPanel2));
		batuLabel2.addMouseListener(new DeleteModelIconCustomHandler(modelDataSetList2, partsStreamSet2, addPanel2));
		RemainingParts2.addMouseListener(new RemainingPartsViewHandler(partsStreamSet2, view, addPanel2));
		//【モデル3】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList3, partsStreamSet3,view, addPanel3));
		OkButton.addActionListener(new RisetDialogHandler(modelDataSetList3, partsStreamSet3, view, addPanel3));
		add3Button.addActionListener(new AddExcelDataFileHandler(view, addPanel3, 3));
		combo3.addItemListener(new ModelSelectComboBoxHandler(modelDataSetList3, view, addPanel3));
		batuLabel3.addMouseListener(new DeleteModelIconCustomHandler(modelDataSetList3, partsStreamSet3, addPanel3));
		RemainingParts3.addMouseListener(new RemainingPartsViewHandler(partsStreamSet3, view, addPanel3));
		//【モデル4】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList4, partsStreamSet4,view, addPanel4));
		OkButton.addActionListener(new RisetDialogHandler(modelDataSetList4, partsStreamSet4, view, addPanel4));
		add4Button.addActionListener(new AddExcelDataFileHandler(view, addPanel4, 4));
		combo4.addItemListener(new ModelSelectComboBoxHandler(modelDataSetList4, view, addPanel4));
		batuLabel4.addMouseListener(new DeleteModelIconCustomHandler(modelDataSetList4, partsStreamSet4, addPanel4));
		RemainingParts4.addMouseListener(new RemainingPartsViewHandler(partsStreamSet4, view, addPanel4));
	}

	public static List<Map<String, String>> getModelDataSetList(int row) {
		switch(row) {
		case 1:
			return modelDataSetList1;
		case 2:
			return modelDataSetList2;
		case 3:
			return modelDataSetList3;
		case 4:
			return modelDataSetList4;
		default:
			return null;
		}
	}

	public static List<Map<Integer, String>> getPartsStreamSet(int row) {
		switch(row) {
		case 1:
			return partsStreamSet1;
		case 2:
			return partsStreamSet2;
		case 3:
			return partsStreamSet3;
		case 4:
			return partsStreamSet4;
		default:
			return null;
		}
	}

}
