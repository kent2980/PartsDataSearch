package jp.data.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jp.data.view.MainView;
import jp.data.view.RemainingPartsView;
import jp.data.view.RisetDialog;

public class MainViewController {
	static LocalDateTime fromTime;
	private final JPanel MainPanel;
	private final JTextField partsCodeField;
	private final JLabel newLabel;
	private final RisetDialog dialog;
	private final JButton OkButton;
	private final JButton NgButton;
	private final RemainingPartsView partsView;
	//【モデル1】
	private static List<Map<String,String>> modelDataSetList1;
	private static List<Map<Integer, String>> partsStreamSet1;
	private final JButton add1Button;
	private final JComboBox<String> combo1;
	private final DefaultComboBoxModel<String> model1;
	private final JLabel mcName1;
	private final JLabel substrateName1;
	private final JLabel substrateFace1;
	private final JLabel batuLabel1;
	private final JLabel stLabel1;
	private final JLabel RemainingParts1;
	//【モデル2】
	private static List<Map<String,String>> modelDataSetList2;
	private static List<Map<Integer, String>> partsStreamSet2;
	private final JButton add2Button;
	private final JComboBox<String> combo2;
	private final DefaultComboBoxModel<String> model2;
	private final JLabel mcName2;
	private final JLabel substrateName2;
	private final JLabel substrateFace2;
	private final JLabel batuLabel2;
	private final JLabel stLabel2;
	private final JLabel RemainingParts2;
	//【モデル3】
	private static List<Map<String,String>> modelDataSetList3;
	private static List<Map<Integer, String>> partsStreamSet3;
	private final JButton add3Button;
	private final JComboBox<String> combo3;
	private final DefaultComboBoxModel<String> model3;
	private final JLabel mcName3;
	private final JLabel substrateName3;
	private final JLabel substrateFace3;
	private final JLabel batuLabel3;
	private final JLabel stLabel3;
	private final JLabel RemainingParts3;
	//【モデル4】
	private static List<Map<String,String>> modelDataSetList4;
	private static List<Map<Integer, String>> partsStreamSet4;
	private final JButton add4Button;
	private final JComboBox<String> combo4;
	private final DefaultComboBoxModel<String> model4;
	private final JLabel mcName4;
	private final JLabel substrateName4;
	private final JLabel substrateFace4;
	private final JLabel batuLabel4;
	private final JLabel stLabel4;
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
		this.partsView = view.getPartsView();
		//【モデル1】
		this.add1Button = view.getAddPanel1().getAddButton();
		this.model1 = view.getAddPanel1().getModel();
		this.mcName1 = view.getAddPanel1().getMcName();
		this.substrateName1 = view.getAddPanel1().getSubstrateName();
		this.substrateFace1 = view.getAddPanel1().getSubstrateFace();
		this.combo1 = view.getAddPanel1().getCombo();
		this.batuLabel1 = view.getAddPanel1().getBatuLabel();
		this.stLabel1 = view.getAddPanel1().getStView();
		this.RemainingParts1 = view.getAddPanel1().getRemainingParts();
		//【モデル2】
		this.add2Button = view.getAddPanel2().getAddButton();
		this.model2 = view.getAddPanel2().getModel();
		this.mcName2 = view.getAddPanel2().getMcName();
		this.substrateName2 = view.getAddPanel2().getSubstrateName();
		this.substrateFace2 = view.getAddPanel2().getSubstrateFace();
		this.combo2 = view.getAddPanel2().getCombo();
		this.batuLabel2 = view.getAddPanel2().getBatuLabel();
		this.stLabel2 = view.getAddPanel2().getStView();
		this.RemainingParts2 = view.getAddPanel2().getRemainingParts();
		//【モデル3】
		this.add3Button = view.getAddPanel3().getAddButton();
		this.model3 = view.getAddPanel3().getModel();
		this.mcName3 = view.getAddPanel3().getMcName();
		this.substrateName3 = view.getAddPanel3().getSubstrateName();
		this.substrateFace3 = view.getAddPanel3().getSubstrateFace();
		this.combo3 = view.getAddPanel3().getCombo();
		this.batuLabel3 = view.getAddPanel3().getBatuLabel();
		this.stLabel3 = view.getAddPanel3().getStView();
		this.RemainingParts3 = view.getAddPanel3().getRemainingParts();
		//【モデル4】
		this.add4Button = view.getAddPanel4().getAddButton();
		this.model4 = view.getAddPanel4().getModel();
		this.mcName4 = view.getAddPanel4().getMcName();
		this.substrateName4 = view.getAddPanel4().getSubstrateName();
		this.substrateFace4 = view.getAddPanel4().getSubstrateFace();
		this.combo4 = view.getAddPanel4().getCombo();
		this.batuLabel4 = view.getAddPanel4().getBatuLabel();
		this.stLabel4 = view.getAddPanel4().getStView();
		this.RemainingParts4 = view.getAddPanel4().getRemainingParts();
		
		//アクションリスナーの設定
		MainPanel.addKeyListener(new MainPanelHandler(partsCodeField));
		partsCodeField.addActionListener(new RecordSetHandler(modelDataSetList1,partsCodeField));
		partsCodeField.addFocusListener(new RecordSetHandler(modelDataSetList1,partsCodeField));
		newLabel.addMouseListener(new CharacterIconCustomHandler(newLabel,dialog));
		NgButton.addActionListener(event -> dialog.setVisible(false));
		
		//【モデル1】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList1, partsStreamSet1,partsCodeField, stLabel1, RemainingParts1));
		OkButton.addActionListener(new RisetDialogHandler(dialog, partsCodeField, combo1, model1, modelDataSetList1, partsStreamSet1, stLabel1,RemainingParts1));
		add1Button.addActionListener(new AddExcelDataFileHandler(combo1,partsCodeField,model1, modelDataSetList1, mcName1, substrateName1, substrateFace1, partsStreamSet1, stLabel1,RemainingParts1));
		combo1.addItemListener(new ModelSelectComboBoxHandler(partsCodeField,combo1, modelDataSetList1, mcName1, substrateName1, substrateFace1, RemainingParts1));
		batuLabel1.addMouseListener(new DeleteModelIconCustomHandler(batuLabel1, combo1, model1, modelDataSetList1, partsStreamSet1));
		RemainingParts1.addMouseListener(new RemainingPartsViewHandler(partsView, RemainingParts1, partsStreamSet1));
		//【モデル2】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList2, partsStreamSet2,partsCodeField, stLabel2, RemainingParts2));
		OkButton.addActionListener(new RisetDialogHandler(dialog, partsCodeField, combo2, model2, modelDataSetList2, partsStreamSet2, stLabel2, RemainingParts2));
		add2Button.addActionListener(new AddExcelDataFileHandler(combo2,partsCodeField,model2, modelDataSetList2, mcName2, substrateName2, substrateFace2, partsStreamSet2, stLabel2,RemainingParts2));
		combo2.addItemListener(new ModelSelectComboBoxHandler(partsCodeField,combo2, modelDataSetList2, mcName2, substrateName2, substrateFace2, RemainingParts2));
		batuLabel2.addMouseListener(new DeleteModelIconCustomHandler(batuLabel2, combo2, model2, modelDataSetList2, partsStreamSet2));
		RemainingParts2.addMouseListener(new RemainingPartsViewHandler(partsView, RemainingParts2, partsStreamSet2));
		//【モデル3】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList3, partsStreamSet3,partsCodeField, stLabel3, RemainingParts3));
		OkButton.addActionListener(new RisetDialogHandler(dialog, partsCodeField, combo3, model3, modelDataSetList3, partsStreamSet3, stLabel3, RemainingParts3));
		add3Button.addActionListener(new AddExcelDataFileHandler(combo3,partsCodeField,model3, modelDataSetList3, mcName3, substrateName3, substrateFace3, partsStreamSet3, stLabel3,RemainingParts3));
		combo3.addItemListener(new ModelSelectComboBoxHandler(partsCodeField,combo3, modelDataSetList3, mcName3, substrateName3, substrateFace3, RemainingParts3));
		batuLabel3.addMouseListener(new DeleteModelIconCustomHandler(batuLabel3, combo3, model3, modelDataSetList3, partsStreamSet3));
		RemainingParts3.addMouseListener(new RemainingPartsViewHandler(partsView, RemainingParts3, partsStreamSet3));
		//【モデル4】
		partsCodeField.addActionListener(new PartsTextFieldHandler(modelDataSetList4, partsStreamSet4,partsCodeField, stLabel4, RemainingParts4));
		OkButton.addActionListener(new RisetDialogHandler(dialog, partsCodeField, combo4, model4, modelDataSetList4, partsStreamSet4, stLabel4, RemainingParts4));
		add4Button.addActionListener(new AddExcelDataFileHandler(combo4,partsCodeField,model4, modelDataSetList4, mcName4, substrateName4, substrateFace4, partsStreamSet4, stLabel4,RemainingParts4));
		combo4.addItemListener(new ModelSelectComboBoxHandler(partsCodeField,combo4, modelDataSetList4, mcName4, substrateName4, substrateFace4, RemainingParts4));
		batuLabel4.addMouseListener(new DeleteModelIconCustomHandler(batuLabel4, combo4, model4, modelDataSetList4, partsStreamSet4));
		RemainingParts4.addMouseListener(new RemainingPartsViewHandler(partsView, RemainingParts4, partsStreamSet4));
	}
}
