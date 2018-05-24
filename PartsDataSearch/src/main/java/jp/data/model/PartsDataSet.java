package jp.data.model;

import java.util.Map;

/**
 * モデルごとの内部データを表すクラス
 * @author kent2
 *
 */
public class PartsDataSet {
	private final String kanriNo;
	private final String modelName;
	private final String mcName;
	private final String substrateName;
	private final String substrateFace;
	private final Map<Integer,String> partsList;

	/**
	 * コンストラクタ
	 * @param kanriNo
	 * @param modelName
	 * @param mcName
	 * @param substrateName
	 * @param substrateFace
	 * @param partsList
	 */
	public PartsDataSet(String kanriNo, String modelName, String mcName, String substrateName, String substrateFace,
			Map<Integer, String> partsList) {
		super();
		this.kanriNo = kanriNo;
		this.modelName = modelName;
		this.mcName = mcName;
		this.substrateName = substrateName;
		this.substrateFace = substrateFace;
		this.partsList = partsList;
	}

	/**
	 * このモデルの管理Noを返します
	 * @return 管理No
	 */
	public String getKanriNo() {
		return kanriNo;
	}

	/**
	 * モデル名を返します
	 * @return モデル名
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 使用するマシン名を返します
	 * @return　マシン名
	 */
	public String getMcName() {
		return mcName;
	}

	/**
	 * 基板名を返します
	 * @return　基板名
	 */
	public String getSubstrateName() {
		return substrateName;
	}

	/**
	 * 基板実装面を返します
	 * @return　基板実装面
	 */
	public String getSubstrateFace() {
		return substrateFace;
	}

	/**
	 * このモデルの部品リストを返します
	 * @return 部品リスト
	 */
	public Map<Integer, String> getPartsList() {
		return partsList;
	}

}
