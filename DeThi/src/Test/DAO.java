package Test;

import java.lang.Class;
import java.sql.*;
import java.util.ArrayList;

public class DAO {
	private Connection conn;

	public DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=SOF203LAB6;integratedSecurity=true", "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> getListStudent() {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT*FROM STUDENT";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setMaSV(rs.getString("masv"));
				s.setHoTen(rs.getString("hoten"));
				s.setIdClass(rs.getString("idclass"));
				s.setNgaySinh(rs.getDate("ngaysinh"));
				s.setGioiTinh(rs.getString("gioitinh"));
				s.setDiaChi(rs.getString("diachi"));
				s.setDienThoai(rs.getString("dienthoai"));
				s.setKhoaNganh(rs.getString("khoanganh"));
				s.setLoginSV(rs.getString("loginsv"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
