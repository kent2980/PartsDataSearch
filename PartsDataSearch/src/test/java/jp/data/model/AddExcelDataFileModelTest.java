package jp.data.model;


public class AddExcelDataFileModelTest {

	public static void main(String[] args) {
		String pathcode = "D:\\Users\\kent\\Documents\\業務改善\\作業フォルダ\\001.xls";
		
			AddExcelDataFileModel model = new AddExcelDataFileModel(pathcode);
			System.out.println("【管理Noを取得】 " + model.getKanriNo());
			System.out.println("【モデル名を取得】 " + model.getModelName());
			System.out.println("【基板名を取得】 " + model.getSubstrateName());
			System.out.println("【基板面を取得】 " + model.getSubstrateFace());
			System.out.println("【マシン構成を取得】 " + model.getMcList());
			System.out.println("【マシン名】 " + model.getMcName());
			model.getPartsMap().entrySet().stream()
						.forEach(System.out::println);
			int count = (int)model.getPartsMap().entrySet().stream().count();
			System.out.println("部品点数" + count + "品目");
			model = null;
	}

}
