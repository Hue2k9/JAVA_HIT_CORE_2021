package QuanLyBanHang;
import java.util.ArrayList;
import java.util.Scanner;
public class Order implements Comparable<Order>{
    private String orderCode;
    private String receiver;
    private String address;
    private int quantity;
    private int phoneNumber;
    private String codeProduct;
    private String dayAdded;
    private int sumMoney;

    public Order() {
    }

    public Order(String orderCode, String receiver, String address, int quantity, int phoneNumber, String codeProduct, String dayAdded, int sumMoney) {
        this.orderCode = orderCode;
        this.receiver = receiver;
        this.address = address;
        this.quantity = quantity;
        this.phoneNumber = phoneNumber;
        this.codeProduct = codeProduct;
        this.dayAdded = dayAdded;
        this.sumMoney = sumMoney;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode){
        this.orderCode = orderCode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public int getSumMoney() {
        return getSumMoney();
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getDayAdded() {
        return dayAdded;
    }

    public void setDayAdded(String dayAdded) {
        this.dayAdded = dayAdded;
    }


    public void inputOrder(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Order code: ");
        orderCode=sc.nextLine();
        System.out.print("Receiver: ");
        receiver=sc.nextLine();
        System.out.print("Address: ");
        address=sc.nextLine();
        System.out.print("Phone number: ");
        phoneNumber=sc.nextInt();
        sc.nextLine();
        System.out.print("Code product: ");
        codeProduct=sc.nextLine();
        System.out.print("Day added: ");
        dayAdded=sc.nextLine();
        System.out.print("Quantity: ");
        quantity=sc.nextInt();
        sc.nextLine();

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode='" + orderCode + '\'' +
                ", receiver='" + receiver + '\'' +
                ", address='" + address + '\'' +
                ", quantity=" + quantity +
                ", phoneNumber=" + phoneNumber +
                ", codeProduct='" + codeProduct + '\'' +
                ", dayAdded='" + dayAdded + '\'' +
                ", sumMoney=" + sumMoney +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return 0;
    }
}
