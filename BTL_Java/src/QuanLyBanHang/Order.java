package QuanLyBanHang;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Order implements Comparable<Order>{
    private String orderCode;
    private String receiver;
    private String address;
    private int quantity;
    private int phoneNumber;
    private int n;
    ArrayList<Product> listProduct=new ArrayList<>();
    ArrayList<Product> listTempProducts =new ArrayList<>();
    private int [] listQuantity;
    private String codeProduct;
    private String dayAdded;
    private int sumMoney;
    private Product product=new Product();
    public Order() {
    }

    public Order(String orderCode, String receiver, String address,int quantity, int phoneNumber, String codeProduct, String dayAdded, int sumMoney) {
        this.orderCode = orderCode;
        this.receiver = receiver;
        this.address = address;
        this.quantity = quantity;
        this.phoneNumber = phoneNumber;
        this.codeProduct = codeProduct;
        this.dayAdded = dayAdded;
        this.sumMoney = sumMoney;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getN() {
        return n;
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
        System.out.print("Receiver: ");
        receiver=sc.nextLine();
        System.out.print("Address: ");
        address=sc.nextLine();
        System.out.print("Phone number: ");
        phoneNumber=sc.nextInt();
        sc.nextLine();
        System.out.print("Day added: ");
        dayAdded=sc.nextLine();
        System.out.println("Nhap so loai san pham: ");
        n=sc.nextInt();
        sc.nextLine();
        //Bang san pham
        SQLProcessing sql=new SQLProcessing();
        List<Product> products=SQLProcessing.readAllProduct();

        for(Product s: products){
            String id=s.getIdProduct().trim();
            String day=s.getDayAdded().trim();
            s.setIdProduct(id);
            s.setDayAdded(day);
            s.output();
        }
        int k=0;
        listQuantity = new int[n];
        for(int i=0; i<n; i++){
            System.out.print("Enter code product: ");
            String codeProduct=sc.nextLine();
            for(Product s: products){
                if (codeProduct.equalsIgnoreCase(s.getIdProduct())){
                     listTempProducts.add(s);
                    System.out.print("Enter quantity of the product: ");
                    quantity=sc.nextInt();
                    listQuantity[k]=quantity;
                    k++;
                   sc.nextLine();
                }
            }
        }

    }
    public void outPutOrder(){
        for(Product s: listProduct){
            s.output();
        }
        sumMoney=0;
        System.out.println("=================================================================================");
        System.out.println("                           BILL                                   ");
        System.out.println("Order code: "+orderCode);
        System.out.println("Receiver: "+receiver);
        System.out.println("Address: "+address+"          Phone number: "+phoneNumber);
        System.out.println("Day added: "+dayAdded);
        System.out.printf("%-15s%-30s%-15s%-15s%-15s\n","Product code","name product","quantity","price","origin");
        int i=0;
        for(Product s: listTempProducts){
            sumMoney+=s.getPrice()*listQuantity[i];
            i++;
            System.out.printf("%-15s%-30s%-15s%-15s%-15s\n",s.getIdProduct(),s.getName(),listQuantity[i],s.getPrice(),s.getOrigin());
        }
        System.out.println("Sum money: "+sumMoney+" VND");
        System.out.println("                            Thank you!");
        System.out.println("=================================================================================");
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
