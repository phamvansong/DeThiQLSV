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
					"jdbc:sqlserver://localhost:1433;databasename=QLSV;integratedSecurity=true", "", "");
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

	public boolean addStudent(Student s) {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getMaSV());
			ps.setString(2, s.getHoTen());
			ps.setString(3, s.getIdClass());
			ps.setDate(4, (Date) s.getNgaySinh());
			ps.setString(5, s.getGioiTinh());
			ps.setString(6, s.getDiaChi());
			ps.setString(7, s.getDienThoai());
			ps.setString(8, s.getKhoaNganh());
			ps.setString(9, s.getLoginSV());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudent(String maSV) {
		String sql = "DELETE STUDENT WHERE MASV = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, maSV);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateStudent(String maSV, Student s) {
		String sql = "UPDATE STUDENT SET HOTEN = ?, IDCLASS = ?, NGAYSINH = ?, GIOITINH = ?, DIACHI = ?, DIENTHOAI = ?, KHOANGANH = ?, LOGINSV = ? WHERE MASV = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getHoTen());
			ps.setString(2, s.getIdClass());
			ps.setDate(3, (Date) s.getNgaySinh());
			ps.setString(4, s.getGioiTinh());
			ps.setString(5, s.getDiaChi());
			ps.setString(6, s.getDienThoai());
			ps.setString(7, s.getKhoaNganh());
			ps.setString(8, s.getLoginSV());
			ps.setString(9, maSV);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Classs> getListClass() {
		ArrayList<Classs> list = new ArrayList<>();
		String sql = "SELECT*FROM CLASS";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classs c = new Classs();
				c.setIdClass(rs.getString(1));
				c.setNameClass(rs.getString(2));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<String> getListIDClass() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT*FROM CLASS";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<String> getListNameClass() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT*FROM CLASS";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Users> getListUsers() {
		ArrayList<Users> list = new ArrayList<>();
		String sql = "SELECT*FROM USERS";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users u = new Users();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setChucnang(rs.getString(3));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
