package jp.data.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RemainingPartsMathModel {
	private final LocalDateTime fromtime;
	private final List<Map<Integer, String>> partsStreamSet;
	
	public RemainingPartsMathModel(LocalDateTime fromtime, List<Map<Integer, String>> partsStreamSet){
		this.fromtime = fromtime;
		this.partsStreamSet = partsStreamSet;
	}
	
	public int getRemainingPartsNumber() {
		//パーツリストを取得
		List<Map<Integer, String>> partsMap = partsStreamSet;
		List<String> l2 = partsMap.stream()
															.flatMap(s -> s.entrySet().stream())
															.map(m -> m.getValue())
															.distinct()
															.collect(Collectors.toList());
		//読み取り部品を取得
		GetPartsSetRecordModel ss = GetPartsSetRecordModel.getInstance();
		List<Map<String,String>> list = ss.getPartsLisr(fromtime);
		List<String> l = list.stream()
				.flatMap(m ->m.entrySet().stream())
				.filter(m -> m.getKey().equals("partscode"))
				.map(m -> m.getValue())
				.collect(Collectors.toList());
		//残部品を算出
		l2.removeAll(l);
		
		return l2.size();
	}
	
	public Object[][] getRemainingPartsList(){
		
		//◆ 読み取り部品を取得
		GetPartsSetRecordModel RecordModel = GetPartsSetRecordModel.getInstance();
		List<Map<String,String>> Recordlist = RecordModel.getPartsLisr(fromtime);
			//読み取った部品コードをリストで取得する
			List<String> readList = Recordlist.stream()
																	.flatMap(m ->m.entrySet().stream())
																	.filter(m -> m.getKey().equals("partscode"))
																	.map(m -> m.getValue())
																	.collect(Collectors.toList());
			
		//◆ パーツリストを取得
		List<Map<Integer, String>> partsMap = partsStreamSet;
		List<String> mapKey = partsMap.stream()
															.flatMap(s -> s.entrySet().stream())
															.map(m -> String.valueOf(m.getKey()))
															.collect(Collectors.toList());
		List<String> mapValue = partsMap.stream()
															.flatMap(s -> s.entrySet().stream())
															.map(m -> m.getValue())
															.collect(Collectors.toList());
			//TreeMapに変換する
			Map<String,String> newMap = new TreeMap<>();
			for(int i = 0;i < mapKey.size(); i++) {
				newMap.put(mapKey.get(i), mapValue.get(i));
			}
		
		//◆ パーツリストから読み取り部品を削除する
		newMap.values().removeAll(readList);
		
		//◆ 2次元配列を取り出す
		String[][] newArray = new String[newMap.size()][2];
		int i = 0;
		for(Entry<String,String> entry:newMap.entrySet()) {
			newArray[i][0] = "  " + entry.getKey();
			newArray[i][1] = "  " + entry.getValue();
			i++;
		}
		
		//◆ 結果
		return newArray;
	}
	
}
