package jp.data.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SetPartsTextFieldRecordModel {
	private final String dateTime;
	private final String partsCode;
	private final String modelName;
	private final String mcName;
	
	public SetPartsTextFieldRecordModel(LocalDateTime dateTime,String partsCode, String modelName, String mcName) {
		this.dateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.partsCode = partsCode.toUpperCase();
		this.modelName = modelName;
		this.mcName = mcName;
	}
	
	public boolean setRecord() {
		String sql = "INSERT INTO PartsTextFieldRecord (DateTime,PartsCode,ModelName,McName) VALUES ( ?, ?, ?, ?)";
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		try(	Connection con = DriverManager.getConnection("jdbc:sqlite:database/record_data.sqlite");
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, dateTime);
			stmt.setString(2, partsCode);
			stmt.setString(3, modelName);
			stmt.setString(4, mcName);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
	}
}
