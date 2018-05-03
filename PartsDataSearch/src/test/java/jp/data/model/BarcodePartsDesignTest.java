package jp.data.model;

import java.util.Scanner;

import jp.data.model.PartsTextFieldModel;

public class BarcodePartsDesignTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("【部品検索テストを行います。】");
		System.out.println("部品コードを入力してください");
		String testWord = s.nextLine();
		PartsTextFieldModel ps = new PartsTextFieldModel(testWord);
		System.out.println("【出力結果】 " + ps.getPartsName());
		s.close();
		ps = null;
	}

}
