package jp.data.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SetPartsTextFieldRecordModelTest {
	public static void main(String[] args) {
		LocalDateTime fromtime = LocalDateTime.now();
		LocalDateTime datetime = LocalDateTime.now();
		String partsName = "1S4033811";
		String modelName = "FH1688B0F";
		String mcName = "TIM";
		
		SetPartsTextFieldRecordModel dataset = new SetPartsTextFieldRecordModel(datetime,partsName,modelName,mcName);
		System.out.println("【書き込みテスト1】");
		System.out.println(dataset.setRecord());
		
		datetime = LocalDateTime.now();
		partsName = "1S5022411";
		modelName = "FH1688B0F";
		mcName = "TIM";
		
		dataset = new SetPartsTextFieldRecordModel(datetime,partsName,modelName,mcName);
		System.out.println("【書き込みテスト2】");
		System.out.println(dataset.setRecord());
		
		GetPartsSetRecordModel ss = GetPartsSetRecordModel.getInstance();
		List<Map<String,String>> list = ss.getPartsLisr(fromtime);
		System.out.println("【レコードセット取得テスト】");
		System.out.println(list.getClass() == List.class);
		for(Map<String,String> m:list) {
			System.out.println(m.toString());
		}
		
		List<String> l = list.stream()
											.flatMap(m ->m.entrySet().stream())
											.filter(m -> m.getKey().equals("partscode"))
											.map(m -> m.getValue())
											.collect(Collectors.toList());
		
		System.out.println("【出庫部品】");
		System.out.println(l);
		
		String pathcode = "D://001.xls";
		AddExcelDataFileModel model = new AddExcelDataFileModel(pathcode);
		Map<Integer,String> m2 = model.getPartsMap();
		List<String> l2 = m2.entrySet().stream()
												.map(m -> m.getValue())
												.collect(Collectors.toList());
		System.out.println("【定数表リスト】");
		System.out.println("残り" + l2.size() + "点, " + l2);
		System.out.println("【差分テスト】");
		l2.removeAll(l);
		System.out.println("残り" + l2.size() + "点, " + l2);
	}

}
