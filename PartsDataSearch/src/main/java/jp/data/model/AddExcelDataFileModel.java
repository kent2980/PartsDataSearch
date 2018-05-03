package jp.data.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddExcelDataFileModel {
	private String kanriNo;
	private String modelName;
	private String mcName;
	private String mcList;
	private String substrateName;
	private String substrateFace;
	private HashMap<String,String> modelDataSet = new HashMap<>();
	private TreeMap<Integer,String> partsMap= new TreeMap<>();
	
	public AddExcelDataFileModel(String url) {
		
		try (FileInputStream in = new FileInputStream(url);
				Workbook workbook = WorkbookFactory.create(in)){
			
			//管理Noを取得
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			kanriNo = cell.getStringCellValue();
			modelDataSet.put("kanriNo", kanriNo);
			
			//モデル名を取得
			row = sheet.getRow(3);
			cell = row.getCell(1);
			modelName = cell.getStringCellValue();
			modelDataSet.put("modelName", modelName);
			
			//マシン名を取得
			row = sheet.getRow(5);
			cell = row.getCell(1);
			mcName = cell.getStringCellValue();
			int t = mcName.indexOf("-");
			mcName = t == -1 ? mcName : mcName.substring(0, t);
			modelDataSet.put("mcName", mcName);
			
			//マシン構成を取得
			row = sheet.getRow(7);
			cell = row.getCell(1);
			substrateFace = cell.getStringCellValue();
			substrateFace = Normalizer.normalize(substrateFace, Normalizer.Form.NFKC);
			List<String> list = Arrays.asList(substrateFace.split(" "));
			mcList = list.get(0);
			modelDataSet.put("mcList", mcList);
			
			//基板名を取得
			row = sheet.getRow(6);
			cell = row.getCell(1);
			substrateName = cell.getStringCellValue();
			modelDataSet.put("substrateName", substrateName);
			
			//基板面を取得
			substrateFace = list.get(list.size()-1);
			modelDataSet.put("substrateFace", substrateFace);
			
			//部品コードのリストを取得
			int lastRow = sheet.getLastRowNum();
			for(int i = 10; i <= lastRow; i++) {
				row = sheet.getRow(i);
				Cell cell1 = row.getCell(0);
				Cell cell2 = row.getCell(1);
				if(!cell1.getStringCellValue().equals("") && Integer.valueOf(cell1.getStringCellValue()) > 100)
				partsMap.put(Integer.valueOf(cell1.getStringCellValue()), cell2.getStringCellValue());
			}

		} catch (EncryptedDocumentException | InvalidFormatException| IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public String getKanriNo() {
		return kanriNo;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	/**
	 * @return mcName
	 */
	public String getMcName() {
		return mcName;
	}

	/**
	 * @return mcList
	 */
	public String getMcList() {
		return mcList;
	}

	/**
	 * @return substrateName
	 */
	public String getSubstrateName() {
		return substrateName;
	}

	/**
	 * @return substrateFace
	 */
	public String getSubstrateFace() {
		return substrateFace;
	}

	/**
	 * @return modelDataSet
	 */
	public HashMap<String, String> getModelDataSet() {
		return modelDataSet;
	}

	public Map<Integer, String> getPartsMap(){
		//TIM トレイ部品を取り除くコードを記述
		return partsMap;
	}
}
