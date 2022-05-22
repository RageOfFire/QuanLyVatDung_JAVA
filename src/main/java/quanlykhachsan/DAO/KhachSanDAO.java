package quanlykhachsan.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quanlykhachsan.Models.KhachSan;

public class KhachSanDAO {
	private static final String INSERT_SQL = "INSERT INTO vatdung" + " (TenVatDung, SoLuong, TinhTrang, GhiChu) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_BY_ID = "SELECT * FROM vatdung where MaVatDung = ?;";
	private static final String SELECT_ALL = "SELECT * FROM vatdung;";
	private static final String DELETE_SQL = "DELETE FROM vatdung WHERE MaVatDung = ?;";
	private static final String UPDATE_SQL = "UPDATE vatdung SET TenVatDung = ?, SoLuong = ?, TinhTrang = ?, GhiChu = ? WHERE MaVatDung = ?;";
	private static final String SEARCH_SQL = "SELECT * FROM vatdung WHERE TenVatDung LIKE ?;";	
	private String jdbcURL = "jdbc:mysql://localhost:3306/khachsan_btl?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
	protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
	
//	Thêm dữ liệu
	public void insertkhachsan(KhachSan khachsan) throws SQLException  {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
				preparedStatement.setString(1, khachsan.getTenVatDung());
				preparedStatement.setInt(2, khachsan.getSoLuong());
				preparedStatement.setString(3, khachsan.getTinhTrang());
				preparedStatement.setString(4, khachsan.getGhiChu());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
	}
	
	
//	Liệt kê dữ liệu theo mã (dùng để sửa,xóa)
	public KhachSan selectKhachSan(int MaVatDung) {
		KhachSan khachsan = null;
		try (
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) 
        {
			preparedStatement.setInt(1, MaVatDung);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String tenVatDung = rs.getString("TenVatDung");
				int SoLuong = rs.getInt("SoLuong");
				String TinhTrang = rs.getString("TinhTrang");
				String GhiChu = rs.getString("GhiChu");
				khachsan = new KhachSan(MaVatDung, tenVatDung, SoLuong, TinhTrang, GhiChu);
			}
		} catch (SQLException e) {
		    printSQLException(e);
		}
	    return khachsan;
	}
	
//	Liệt kê dữ liệu
	public List<KhachSan> selectAllKhachSan() {
		List<KhachSan> khachsans = new ArrayList<>();
		try (
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) 
        {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int MaVatDung = rs.getInt("MaVatDung");
				String TenVatDung = rs.getString("TenVatDung");
				int SoLuong = rs.getInt("SoLuong");
				String TinhTrang = rs.getString("TinhTrang");
				String GhiChu = rs.getString("GhiChu");
				khachsans.add(new KhachSan(MaVatDung, TenVatDung, SoLuong, TinhTrang, GhiChu));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		    return khachsans;
	}
	
//	Tìm kiếm
	public List<KhachSan> searchKhachSan(String TenVatDung) {
		List<KhachSan> khachsans = new ArrayList<>();
		try (
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);) 
        {
			preparedStatement.setString(1, "%" + TenVatDung + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int MaVatDung = rs.getInt("MaVatDung");
				String TenVatDung1 = rs.getString("TenVatDung");
				int SoLuong = rs.getInt("SoLuong");
				String TinhTrang = rs.getString("TinhTrang");
				String GhiChu = rs.getString("GhiChu");
				khachsans.add(new KhachSan(MaVatDung, TenVatDung1, SoLuong, TinhTrang, GhiChu));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		    return khachsans;
	}
	
//	Xóa
	public boolean deleteKhachSan(int MaVatDung) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(DELETE_SQL);) {
			statement.setInt(1, MaVatDung);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
//	Cập nhật
	public boolean updateKhachHang(KhachSan khachsan) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);) {
			statement.setString(1, khachsan.getTenVatDung());
			statement.setInt(2, khachsan.getSoLuong());
			statement.setString(3, khachsan.getTinhTrang());
			statement.setString(4, khachsan.getGhiChu());
			statement.setInt(5, khachsan.getMaVatDung());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
//	Thông báo lỗi với SQL
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());	
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
}
