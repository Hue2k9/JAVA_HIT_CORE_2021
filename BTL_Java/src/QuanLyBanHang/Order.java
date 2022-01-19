package QuanLyBanHang;
import java.util.ArrayList;
import java.util.Scanner;
public class Order implements Comparable<Order>{
    private String orderCode;
    private String receiver;
    private String address;
    private int quantity;
    private int phoneNumber;
    private int n;
    ArrayList<Product> listProduct=new ArrayList<>();
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
        System.out.print("Day added: ");
        dayAdded=sc.nextLine();
        sc.nextLine();
        System.out.println("Nhap so loai san pham: ");
        n=sc.nextInt();
        for(int i=0; i<n; i++){
            Product sp1 = new Product();
            System.out.print("Enter code product: ");
            String codeProduct=sc.nextLine();
            int count=0;
            for(Product sp:listProduct){
                if (sp.getIdProduct().equals(codeProduct)){
                  count=1;
                    System.out.print("Quantity Product: ");
                    quantity=sc.nextInt();
                  break;
                }
                else
                    count++;
            }
            if (count==listProduct.size())
                System.out.println("The product is not available");
        }
    }
    public void outPutOrder(){
        System.out.println("Order code: "+orderCode);
        System.out.println("Receiver: "+receiver);
        System.out.println("Address: "+address);
        System.out.println("Phone number: "+phoneNumber);
        System.out.println("Day added: "+dayAdded);
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
