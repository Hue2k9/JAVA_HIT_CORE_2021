package bai1;

public class SinhVien extends Nguoi{
    private String maSv;
    private String nganh;
    private int khoaHoc;

    public SinhVien() {
    }

    public SinhVien(String maSv, String nganh, int khoaHoc) {
        this.maSv = maSv;
        this.nganh = nganh;
        this.khoaHoc = khoaHoc;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(int khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

}
