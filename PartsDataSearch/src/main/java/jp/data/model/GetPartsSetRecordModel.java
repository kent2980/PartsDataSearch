package jp.data.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPartsSetRecordModel {
	private static GetPartsSetRecordModel model = new GetPartsSetRecordModel();
	
	private GetPartsSetRecordModel(){
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		try {
			GetPartsSetRecordModel.con = DriverManager.getConnection("jdbc:sqlite:database//record_data.sqlite");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static GetPartsSetRecordModel getInstance() {
		return model;
	}
	
	private static Connection con;
	
	public List<Map<String,String>> getPartsLisr(LocalDateTime fromTime){
		List<Map<String,String>> list = new  ArrayList<>();
		String sql = "SELECT * FROM PartsTextFieldRecord WHERE DateTime >= ?";
		
		try(PreparedStatement pstmt = GetPartsSetRecordModel.con.prepareStatement(sql)){
			String fromtime = fromTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			pstmt.setString(1, fromtime);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String,String> map = new HashMap<>();
				map.put("datetime", rs.getString(2));
				map.put("partscode", rs.getString(3));
				map.put("modelname", rs.getString(4));
				map.put("mcname", rs.getString(5));
				map.put("using", rs.getString(6));
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
}
