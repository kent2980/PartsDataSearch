package jp.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * モデルごとの内部データを保持するためのシングルトンクラス
 * 行とインデックスを指定して使用します。
 * @author kent2
 *
 */
public class PartsDataList {
	private final static PartsDataList instance = new PartsDataList();
	private List<List<PartsDataSet>> modelList = new ArrayList<>();

	private PartsDataList() {

	}

	/**
	 * このクラスのインスタンスを返します
	 * @return インスタンス
	 */
	public static PartsDataList getInstance() {
		return instance;
	}

	/**
	 * 指定行のモデルごと内部データを返します
	 * @param row　行
	 * @return　モデルごと内部データ
	 */
	public List<PartsDataSet> getModelList(int row){
		return modelList.get(row);
	}

	/**
	 * 指定行にモデルごとの内部データを追加します。
	 * @param partsDataSet
	 * @param row
	 */
	public void setPartsDataSet(PartsDataSet partsDataSet, int row) {
		//Listの要素数を検査する
		try {
			modelList.get(row);
		}catch(IndexOutOfBoundsException e) {
			modelList.add(new ArrayList<PartsDataSet>());
		}
		//データを追加します
		modelList.get(row).add(partsDataSet);
	}

	/**
	 * 指定モデルの管理Noを返します
	 * データが存在しない場合はNullを返します。
	 * @return 管理No
	 */
	public String getKanriNo(int row, int index) {
		try {
			String kanriNo = modelList.get(row).get(index).getKanriNo();
			return kanriNo;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 指定モデル名を返します
	 * データが存在しない場合はNullを返します。
	 * @return モデル名
	 */
	public String getModelName(int row, int index) {
		try {
			String modelName = modelList.get(row).get(index).getModelName();
			return modelName;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 指定モデルの使用するマシン名を返します
	 * データが存在しない場合はNullを返します。
	 * @return　マシン名
	 */
	public String getMcName(int row, int index) {
		try {
			String mcName = modelList.get(row).get(index).getMcName();
			return mcName;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 指定モデルの基板名を返します
	 * データが存在しない場合はNullを返します。
	 * @return　基板名
	 */
	public String getSubstrateName(int row, int index) {
		try {
			String substrateName = modelList.get(row).get(index).getSubstrateName();
			return substrateName;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 指定モデルの基板実装面を返します
	 * データが存在しない場合はNullを返します。
	 * @return　基板実装面
	 */
	public String getSubstrateFace(int row, int index) {
		try {
			String substrateFace = modelList.get(row).get(index).getSubstrateFace();
			return substrateFace;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 指定モデルの部品リストを返します
	 * データが存在しない場合はNullを返します。
	 * @return 部品リスト
	 */
	public Map<Integer, String> getPartsList(int row) {
		try {
			Map<Integer, String> partsList = modelList.get(row).stream()
													  .flatMap(s->s.getPartsList().entrySet().stream())
											          .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
			return partsList;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 指定モデルの部品リストを返します
	 * データが存在しない場合はNullを返します。
	 * @return 部品リスト
	 */
	public Map<Integer, String> getPartsList(int row, int index) {
		try {
			Map<Integer, String> partsList = modelList.get(row).get(index).getPartsList();
			return partsList;
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 指定行のインデックスの数を返します
	 * 指定業が存在しない場合は-1を返します
	 * @param 行
	 * @return インデックスのサイズ
	 */
	public int getRowSize(int row) {
		try {
			int size = modelList.get(row).size();
			return size;
		}catch(IndexOutOfBoundsException e) {
			return -1;
		}
	}

	/**
	 * このクラスが保持するデータ数を返します
	 * @return データ数
	 */
	public int getSize() {
		return modelList.size();
	}

	/**
	 * 引数のパーツリストと比較してST固定であるか検査します
	 * @param row　行
	 * @param partsDataMap　パーツリスト
	 * @return　判定結果
	 */
	public boolean isDuplicationPartsList(int row, Map<Integer,String> partsDataMap) {
		for(int i = 0; i < modelList.get(row).size(); i++) {
		}
		return false;
	}

	/**
	 * 全てのデータを削除します。
	 */
	public void removeAll() {
		modelList = new ArrayList<>();
	}

	public void remove(int row, int index) {
		modelList.get(row).remove(index);
	}
}
