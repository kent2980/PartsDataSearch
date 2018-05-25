package com.controller;

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

/**
 * コントローラクラス
 * 各種アクションリスナーを割り振ります。
 * @author kent2
 *
 */
public class MainViewController {
	private final JPanel MainPanel;
	private final JTextField partsCodeField;
	private final JLabel newLabel;
	private final RisetDialog dialog;
	private final JButton OkButton;
	private final JButton NgButton;
	//【モデル1】
	private final AddModelPanel addPanel1;
	private final JButton add1Button;
	private final JComboBox<String> combo1;
	private final JLabel batuLabel1;
	private final JLabel RemainingParts1;
	//【モデル2】
	private final AddModelPanel addPanel2;
	private final JButton add2Button;
	private final JComboBox<String> combo2;
	private final JLabel batuLabel2;
	private final JLabel RemainingParts2;
	//【モデル3】
	private final AddModelPanel addPanel3;
	private final JButton add3Button;
	private final JComboBox<String> combo3;
	private final JLabel batuLabel3;
	private final JLabel RemainingParts3;
	//【モデル4】
	private final AddModelPanel addPanel4;
	private final JButton add4Button;
	private final JComboBox<String> combo4;
	private final JLabel batuLabel4;
	private final JLabel RemainingParts4;

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
		partsCodeField.addActionListener(new RecordSetHandler(partsCodeField));
		partsCodeField.addFocusListener(new RecordSetHandler(partsCodeField));
		newLabel.addMouseListener(new CharacterIconCustomHandler(newLabel,dialog));
		NgButton.addActionListener(event -> dialog.setVisible(false));

		//【モデル1】
		partsCodeField.addActionListener(new PartsTextFieldHandler(view, addPanel1, 0));
		OkButton.addActionListener(new RisetDialogHandler(view, addPanel1));
		add1Button.addActionListener(new AddExcelDataFileHandler(view, addPanel1, 0));
		combo1.addItemListener(new ModelSelectComboBoxHandler(view, addPanel1, 0));
		batuLabel1.addMouseListener(new DeleteModelIconCustomHandler(addPanel1, 0));
		RemainingParts1.addMouseListener(new RemainingPartsViewHandler(view, addPanel1, 0));
		//【モデル2】
		partsCodeField.addActionListener(new PartsTextFieldHandler(view, addPanel2, 1));
		OkButton.addActionListener(new RisetDialogHandler(view, addPanel2));
		add2Button.addActionListener(new AddExcelDataFileHandler(view, addPanel2, 1));
		combo2.addItemListener(new ModelSelectComboBoxHandler(view, addPanel2, 1));
		batuLabel2.addMouseListener(new DeleteModelIconCustomHandler(addPanel2, 1));
		RemainingParts2.addMouseListener(new RemainingPartsViewHandler(view, addPanel2, 1));
		//【モデル3】
		partsCodeField.addActionListener(new PartsTextFieldHandler(view, addPanel3, 2));
		OkButton.addActionListener(new RisetDialogHandler(view, addPanel3));
		add3Button.addActionListener(new AddExcelDataFileHandler(view, addPanel3, 2));
		combo3.addItemListener(new ModelSelectComboBoxHandler(view, addPanel3, 2));
		batuLabel3.addMouseListener(new DeleteModelIconCustomHandler(addPanel3, 2));
		RemainingParts3.addMouseListener(new RemainingPartsViewHandler(view, addPanel3, 2));
		//【モデル4】
		partsCodeField.addActionListener(new PartsTextFieldHandler(view, addPanel4, 3));
		OkButton.addActionListener(new RisetDialogHandler(view, addPanel4));
		add4Button.addActionListener(new AddExcelDataFileHandler(view, addPanel4, 3));
		combo4.addItemListener(new ModelSelectComboBoxHandler(view, addPanel4, 3));
		batuLabel4.addMouseListener(new DeleteModelIconCustomHandler(addPanel4, 3));
		RemainingParts4.addMouseListener(new RemainingPartsViewHandler(view, addPanel4, 3));
	}

}
