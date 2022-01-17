package bai1;
import java.util.ArrayList;
public class LopHoc {
    private String maLH;
    private String tenLH;
    private String ngayMo;
    private ArrayList<SinhVien> x;
    private int n;
    private String giaoVien;

    public LopHoc() {
    }

    public LopHoc(String maLH, String tenLH, String ngayMo, ArrayList<SinhVien> x, int n, String giaoVien) {
        this.maLH = maLH;
        this.tenLH = tenLH;
        this.ngayMo = ngayMo;
        this.x = x;
        this.n = n;
        this.giaoVien = giaoVien;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getTenLH() {
        return tenLH;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public String getNgayMo() {
        return ngayMo;
    }

    public void setNgayMo(String ngayMo) {
        this.ngayMo = ngayMo;
    }

    public ArrayList<SinhVien> getX() {
        return x;
    }

    public void setX(ArrayList<SinhVien> x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }
}
