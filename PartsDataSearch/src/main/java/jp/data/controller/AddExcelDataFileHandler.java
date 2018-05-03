package jp.data.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jp.data.model.AddExcelDataFileModel;
import jp.data.model.RemainingPartsMathModel;
import jp.data.model.StationSearchModel;
import jp.data.view.RisetDialog;

class AddExcelDataFileHandler implements ActionListener{
	private final JComboBox<String> combo1;
	private final JTextField partsCodeField;
	private final DefaultComboBoxModel<String> model;
	private final List<Map<String,String>> modelDataSetList;
	private final List<Map<Integer, String>> partsStreamSet;
	private final JLabel mcName;
	private final JLabel substrateName;
	private final JLabel substrateFace;
	private final JLabel stLabel;
	private final JLabel RemainingParts;
	private AddExcelDataFileModel data;
	
	AddExcelDataFileHandler(JComboBox<String> combo1,JTextField partsCodeField,DefaultComboBoxModel<String> model,
														List<Map<String,String>> modelDataSetList,JLabel mcName,JLabel substrateName,JLabel substrateFace,
														List<Map<Integer, String>> partsStreamSet, JLabel stLabel , JLabel RemainingParts){
		this.combo1 = combo1;
		this.partsCodeField = partsCodeField;
		this.model = model;
		this.modelDataSetList = modelDataSetList;
		this.mcName = mcName;
		this.substrateName = substrateName;
		this.substrateFace = substrateFace;
		this.partsStreamSet = partsStreamSet;
		this.stLabel = stLabel;
		this.RemainingParts = RemainingParts;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//設定ファイル読み込み
		Path path = Paths.get("setting.ini");
		String read = null;
		try (BufferedReader reader = Files.newBufferedReader(path);){
			for(;;) {
				read = reader.readLine();
				if(read.substring(0, 7).equals("ExelPath")) {
					break;
				}else {
					break;
				}
			}
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		read = read.substring(read.indexOf(":")+1, read.length());
		//fromtimeを設定する ※fromtimeがnullの場合
		if(MainViewController.fromTime == null) {
			MainViewController.fromTime = LocalDateTime.now();
		}
		boolean flag = false;	// <- 追加済みか判定に使用
		int t = combo1.getItemCount();
		String pathcode = read;
		//すでに追加中の場合は追加しない
		if(Files.exists(Paths.get(pathcode))) {
			data = new AddExcelDataFileModel(pathcode);
			for(Map<String, String> map:modelDataSetList) {
				flag = map.get("kanriNo").equals(data.getKanriNo());
				if(flag == true) {
					break;
				}
			}
			//新規追加の場合
			if(flag == false) {
				
				//ST固定であるか検査を行う
				List<Map<Integer,String>> setList = partsStreamSet;
				boolean Inspection = true;
				for(Map<Integer,String> map:setList) {
					for(Integer it : map.keySet()) {
						Inspection = map.get(it).equals(data.getPartsMap().get(it));
						if(Inspection == false) {
							break;
						}
					}
				}

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
		//モデルデータセット
		modelDataSetList.add(data.getModelDataSet());
		//パーツセット
		partsStreamSet.add(data.getPartsMap());
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
		int st = new StationSearchModel().getStationCode(partsStreamSet, partsCodeField.getText());
		stLabel.setText(st == -1 ? "" :String.valueOf(st));
		//残部品を記述する
		int n =	new RemainingPartsMathModel(MainViewController.fromTime, partsStreamSet).getRemainingPartsNumber();
		RemainingParts.setText("残り" + n + "点");
	}
}
