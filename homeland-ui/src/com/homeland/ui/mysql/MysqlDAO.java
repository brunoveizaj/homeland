package com.homeland.ui.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.homeland.ui.models.PhotoDTO;
import com.homeland.ui.utils.CalculatorUtil;

public class MysqlDAO {

	public void sendAsyncPhotoCard() {
		new Thread(() -> {
			sendPhotoCards();
		}).start();
	}

	public void sendPhotoCards() {
		Connection con = null;
		PostgresClient pg = new PostgresClient();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bailiff?useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin", "root", "bv13061990");
			Statement stmt = con.createStatement();

			long START_ID = pg.getLastRid("PC");
			int cnt = 0;
			while (cnt <= 4000000) {
				ResultSet rs = stmt
						.executeQuery("select * from photo_card where ID>" + START_ID + " order by ID limit 50000");

				while (rs.next()) {
					PhotoDTO dto = new PhotoDTO();
					dto.setId(rs.getInt("ID"));
					dto.setIdDoc(rs.getString("IDC"));
					dto.setPhoto(CalculatorUtil.encodeBASE64(rs.getBytes("PHOTO")));

					pg.sendPhotoCard(dto);
					START_ID = dto.getId();
					cnt++;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
