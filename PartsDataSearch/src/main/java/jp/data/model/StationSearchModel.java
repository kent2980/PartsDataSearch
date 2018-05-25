package jp.data.model;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Streamから指定された部品コードに一致するステーションを検索するクラス
 * @author kent2
 * @version 0.0.1
 */
public class StationSearchModel {

	/**
	 * 指定された部品に対するステーションを返します <br>
	 * 存在しない場合は、「-1」を返します
	 * @param partsName
	 * @return ステーション
	 */
	public int getStationCode(Map<Integer, String> partsStreamSet1,String partsName) {
		try {
			return (int)partsStreamSet1.entrySet().stream()
									.filter(n -> n.getValue().equals(partsName.toUpperCase()))
									.distinct()
									.map(x -> x.getKey())
									.findFirst().get();
		}catch(NoSuchElementException e) {
			return -1;
		}
	}
}
