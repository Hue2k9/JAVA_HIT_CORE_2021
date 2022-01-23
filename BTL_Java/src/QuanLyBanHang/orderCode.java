package QuanLyBanHang;

public class orderCode {
    private String orderCode;
    private String userName;
    private String day;

    public orderCode(String orderCode, String userName, String day) {
        this.orderCode = orderCode;
        this.userName = userName;
        this.day = day;
    }

    public orderCode() {
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
