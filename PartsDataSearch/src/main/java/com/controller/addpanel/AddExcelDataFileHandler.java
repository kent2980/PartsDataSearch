package com.controller.addpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.model.AddExcelDataFileModel;
import jp.data.model.FromTimeLoader;
import jp.data.model.PartsDataList;
import jp.data.model.PartsDataSet;
import jp.data.model.RemainingPartsMathModel;
import jp.data.model.SettingLoader;
import jp.data.model.StationSearchModel;
import jp.data.view.AddModelPanel;
import jp.data.view.MainView;

/**
 * Addボタンが押された時のイベントリスナークラス
 * 新規のデータ、または内部データに共通性が無い場合は、新規のリストにデータを作成します。
 * 内部データに共通性がある場合は、既存のリストにデータを追加します。
 * @author kent2
 *
 */
public class AddExcelDataFileHandler implements ActionListener{
	private final JComboBox<String> combo1;
	private final JTextField partsCodeField;
	private final DefaultComboBoxModel<String> model;
	private final JLabel mcName;
	private final JLabel substrateName;
	private final JLabel substrateFace;
	private final JLabel stLabel;
	private final JLabel RemainingParts;
	private AddExcelDataFileModel data;
	private final FromTimeLoader fromTimeLoader = FromTimeLoader.getInstance();
	private List<PartsDataSet> modelList;
	private final int row;

	public AddExcelDataFileHandler(MainView view, AddModelPanel addPanel, int row){
		this.combo1 = addPanel.getCombo();
		this.partsCodeField = view.getPartsCodeField();
		this.model = addPanel.getModel();
		this.mcName = addPanel.getMcName();
		this.substrateName = addPanel.getSubstrateName();
		this.substrateFace = addPanel.getSubstrateFace();
		this.stLabel = addPanel.getStView();
		this.RemainingParts = addPanel.getRemainingParts();
		try {
			this.modelList = PartsDataList.getInstance().getModelList(row);
		}catch(IndexOutOfBoundsException e) {
			this.modelList = null;
		}
		this.row = row;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//設定ファイルからエクセルファイルのパスを取得する
		String excelPath = SettingLoader.getInstance().getExcelPath();
		//fromtimeの設定がない場合は設定する
		if(fromTimeLoader.getFromTime() == null) {
			fromTimeLoader.setNowFromTime();
		}
		//フラグを設定する（追加済みか判定に使用）
		boolean flag = false;
		//すでに追加中の場合は追加しない
		if(Files.exists(Paths.get(excelPath))) {
			data = new AddExcelDataFileModel(excelPath);
			//内部データの重複チェックを行う
			try {
				flag = modelList.stream()
								 .anyMatch(s->s.getKanriNo().equals(data.getKanriNo()));
			}catch(NullPointerException es) {
				flag = false;
			}
			//新規追加の場合
			if(flag == false) {

				//ST固定であるか検査を行う
				boolean Inspection = true;


				//ST固定ではない場合は処理の続行を確認する
				if(Inspection == false) {

					//......処理を追記する

				//ST固定の場合は処理を続ける
				}else {
					setExcelData();
				}
			}
			//テキストフィールドのフォーカスを戻す
			partsCodeField.requestFocus();
		}else {
			//ファイルが存在しなかった場合の処理を記述
			}
		partsCodeField.requestFocusInWindow();
	}

	private void setExcelData() {
		int t = combo1.getItemCount();
		//コンボボックス
		model.addElement("  " + data.getKanriNo() + " , " + data.getModelName() + " , " + data.getMcName());
		//
		String kanriNos = data.getKanriNo();
		String modelNames = data.getModelName();
		String mcNames = data.getMcName();
		String substrateNames = data.getSubstrateName();
		String substrateFaces = data.getSubstrateFace();
		Map<Integer,String> partsLists = data.getPartsMap();
		PartsDataSet dataSet = new PartsDataSet(kanriNos, modelNames, mcNames, substrateNames, substrateFaces, partsLists);
		PartsDataList.getInstance().setPartsDataSet(dataSet, row);
		//マシンネームラベル
		mcName.setText(data.getMcName());
		//基板名ラベル
		String SubstrateName = data.getSubstrateName().length() > 7 ? data.getSubstrateName().substring(0, 7) + "..." : data.getSubstrateName();
		substrateName.setText(SubstrateName);
		//基板面ラベル
		substrateFace.setText(data.getSubstrateFace());
		//追加したコンボボックス項目を選択する
		combo1.setSelectedIndex(t);
		//初期メニューは削除する
		if(model.getElementAt(0).equals("モデルを追加してください"))
		model.removeElementAt(t-1);
		//STNoを検索し記述する
		int st = new StationSearchModel().getStationCode(PartsDataList.getInstance().getPartsList(row), partsCodeField.getText());
		stLabel.setText(st == -1 ? "" :String.valueOf(st));
		//残部品を記述する
		int n =	new RemainingPartsMathModel(fromTimeLoader.getFromTime(), PartsDataList.getInstance().getPartsList(row)).getRemainingPartsNumber();
		RemainingParts.setText("残り" + n + "点");
	}
}
