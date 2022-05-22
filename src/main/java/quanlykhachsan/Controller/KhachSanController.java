package quanlykhachsan.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlykhachsan.DAO.KhachSanDAO;
import quanlykhachsan.Models.KhachSan;

@WebServlet("/")
public class KhachSanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachSanDAO ksDAO;

	public void init() {
		ksDAO = new KhachSanDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertKhachHang(request, response);
				break;
			case "/delete":
				deleteKhachSan(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateKhachSan(request, response);
				break;
			case "/list":
				listKhachSan(request, response);
				break;
			case "/search":
				searchKhachSan(request, response);
				break;
			default:
				TrangChu(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void TrangChu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
//	 Liệt kê danh sách
	private void listKhachSan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<KhachSan> listKS = ksDAO.selectAllKhachSan();
		request.setAttribute("listKS", listKS);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vatdung-list.jsp");
		dispatcher.forward(request, response);
	}

	
//	Tìm kiếm
	private void searchKhachSan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<KhachSan> listKS = null;
		String tenVatDung = request.getParameter("Search");
		try {
			listKS = ksDAO.searchKhachSan(tenVatDung);
			request.setAttribute("listKS", listKS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		request.getRequestDispatcher("vatdung-list.jsp").include(request, response);

	}
	
//	Cập nhật
	private void updateKhachSan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int MaVatDung = Integer.parseInt(request.getParameter("MaVatDung"));
		String TenVatDung = request.getParameter("TenVatDung");
		int SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
		String TinhTrang = request.getParameter("TinhTrang");
		String GhiChu = request.getParameter("GhiChu");
		KhachSan ks = new KhachSan(MaVatDung, TenVatDung, SoLuong, TinhTrang, GhiChu);
		try {
			ksDAO.updateKhachHang(ks);
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}

//	Hiển thị form cập nhật
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int MaVatDung = Integer.parseInt(request.getParameter("MaVatDung"));
		KhachSan existingKhachSan = ksDAO.selectKhachSan(MaVatDung);
		RequestDispatcher dispatcher = request.getRequestDispatcher("vatdung-form.jsp");
		request.setAttribute("ks", existingKhachSan);
		dispatcher.forward(request, response);
	}
	
//	Xóa
	private void deleteKhachSan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        int MaVatDung = Integer.parseInt(request.getParameter("MaVatDung"));
        try {
            ksDAO.deleteKhachSan(MaVatDung);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
//	Thêm
	private void insertKhachHang(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
    {
        String TenVatDung = request.getParameter("TenVatDung");
        int SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
        String TinhTrang = request.getParameter("TinhTrang");
        String GhiChu = request.getParameter("GhiChu");
        KhachSan ks = new KhachSan(TenVatDung, SoLuong, TinhTrang, GhiChu);
        try {
            ksDAO.insertkhachsan(ks);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("list");
	}
	
//	Hiển thị form thêm mới
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher  dispatcher = request.getRequestDispatcher("vatdung-form.jsp");
        dispatcher.forward(request, response);
    }
}
