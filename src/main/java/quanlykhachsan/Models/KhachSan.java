package quanlykhachsan.Models;

public class KhachSan {
	private int MaVatDung;
	private String tenVatDung;
	private int SoLuong;
	private String TinhTrang;
	private String ghiChu;
	

	public KhachSan(int maVatDung, String tenVatDung, int soLuong, String tinhTrang, String ghiChu) {
		this.MaVatDung = maVatDung;
		this.tenVatDung = tenVatDung;
		this.SoLuong = soLuong;
		this.TinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
	}
	
	public KhachSan(String tenVatDung, int soLuong, String tinhTrang, String ghiChu) {
		this.tenVatDung = tenVatDung;
		this.SoLuong = soLuong;
		this.TinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
	}
	

	public int getMaVatDung() {
		return MaVatDung;
	}
	public void setMaVatDung(int maVatDung) {
		MaVatDung = maVatDung;
	}
	public String getTenVatDung() {
		return tenVatDung;
	}
	public void setTenVatDung(String tenVatDung) {
		this.tenVatDung = tenVatDung;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public String getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}

