package jp.data.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 設定ファイルを読み込むためのシングルトンクラス
 * 設定ファイルを一度だけ読み込みます。
 * @author kent2
 *
 */
public class SettingLoader {
	private static SettingLoader loader = new SettingLoader();
	private String excelPath;

	/**
	 * コンストラクタ
	 * 設定ファイルを読み込む
	 */
	private SettingLoader(){
		Path path = Paths.get("setting.ini");
		//設定ファイル読み込み
		try (BufferedReader reader = Files.newBufferedReader(path);){
			//読み込みを行うエクセルファイルのパスを取得する
			excelPath = reader.lines()
						 .filter(s->s.indexOf("ExcelPath")>0)
						 .findFirst()
						 .get();
			excelPath = excelPath.substring(excelPath.indexOf(":")+1, excelPath.length());
			//ファイルを使用できない場合はデフォルトのパスを取得する
		} catch (IOException e1) {
			excelPath = "C\\://001.xls";
		}
	}

	/**
	 * このクラスのインスタンスを返します
	 * @return SettingLoaderインスタンス
	 */
	public static SettingLoader getInstance() {
		return loader;
	}

	/**
	 * エクセルファイルのパスを取得します
	 * @return エクセルファイルのパス
	 */
	public String getExcelPath() {
		return excelPath;
	}
}
