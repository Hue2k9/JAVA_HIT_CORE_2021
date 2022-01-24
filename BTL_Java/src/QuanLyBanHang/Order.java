package QuanLyBanHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Order implements Comparable<Order>{
    private String orderCode;
    private String receiver;
    private String address;
    private int quantity;
    private String phoneNumber;
    private int n;
    ArrayList<Product> listProduct=new ArrayList<>();
    ArrayList<Product> listTempProducts =new ArrayList<>();
    private int [] listQuantity;
    private String codeProduct;
    private String dayAdded;
    private int sumMoney;
    private Account acc=new Account();
    private  ArrayList<Account> listAccount = new ArrayList<Account>();
    private  ArrayList<Account> listAdmin=new ArrayList<Account>();
    static Connection conn = SqlServerConnection.getJDBCConnection();

    private Product product=new Product();
    private ArrayList<orderCode> listOrderCodes=new ArrayList<>();
    public Order() {
    }

    public Order(String orderCode, String receiver, String address,int quantity, String phoneNumber, String codeProduct, String dayAdded, int sumMoney) {
        this.orderCode = orderCode;
        this.receiver = receiver;
        this.address = address;
        this.quantity = quantity;
        this.phoneNumber = phoneNumber;
        this.codeProduct = codeProduct;
        this.dayAdded = dayAdded;
        this.sumMoney = sumMoney;
    }

    public Order(String string, String string1, String string2, int anInt, String string3, String string4, String string5, String string6) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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
    public void addAccountToList(){
        List<Account> accounts = SQLProcessing.readAllAccount();
        accounts=SQLProcessing.readAllAccount();
        for(Account s : accounts){
            String userName=s.getUsername().trim();
            String passWord=s.getPassword().trim();
            s.setPassword(passWord);
            s.setUsername(userName);
            listAccount.add(s);
        }
        List<Account> admin= SQLProcessing.readAdminAccount();
        admin=SQLProcessing.readAdminAccount();
        for(Account s: admin){
            String userName=s.getUsername().trim();
            String passWord=s.getPassword().trim();
            s.setPassword(passWord);
            s.setUsername(userName);
            listAdmin.add(s);
        }
    }

    public void inputOrder(String user){
        LogIn logIn=new LogIn();
        Scanner sc=new Scanner(System.in);
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm");
        String strDate = formatter.format(date);
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate1 = formatter1.format(date);
        setDayAdded(strDate);
        int check=0;
        String regexPhone = "^[0-9\\-\\+]{9,15}$";
        SQLProcessing sql = new SQLProcessing();
        addAccountToList();
        for(Account acc : listAdmin){
            if (acc.getUsername().equalsIgnoreCase(user)){
                System.out.print("Receiver: ");
                receiver=sc.nextLine();
                System.out.print("Address: ");
                address=sc.nextLine();
                System.out.print("Phone number: ");
                phoneNumber=sc.nextLine();
                while(!Pattern.matches(regexPhone,phoneNumber)){
                    System.out.println("Phone number does not exist!");
                    System.out.print("Phone number: ");
                    phoneNumber=sc.nextLine();
                }
                boolean code=sql.addOrderCode(user,strDate1);
                List<orderCode> orderCodes=SQLProcessing.readOrderCode(user,strDate1);
                for(orderCode or : orderCodes){
                    String day=or.getDay().trim();
                    setOrderCode(or.getOrderCode());
                }
                check=1;
                break;
            }
        }
        if (check==0){
            for(Account acc : listAccount){
                if (acc.getUsername().equalsIgnoreCase(user)){
                    setReceiver(acc.getFullName());
                    setPhoneNumber(acc.getPhone());
                    setAddress(acc.getAddress());
                    boolean code=sql.addOrderCode(user,strDate1);
                    List<orderCode> orderCodes=SQLProcessing.readOrderCode(user,strDate1);
                   for(orderCode or : orderCodes){
                       String day=or.getDay().trim();
                       setOrderCode(or.getOrderCode());
                   }
                    break;
                }
            }
        }

        System.out.print("Nhap so loai san pham: ");
        n=sc.nextInt();
        sc.nextLine();
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
                    System.out.print("Enter quantity of the product: ");
                    quantity=sc.nextInt();
                    sc.nextLine();
                    s.setQuantity(quantity);
                    listQuantity[k]=quantity;
                    k++;
                    listTempProducts.add(s);
                    boolean add=sql.addOrder(user,s.getIdProduct(),quantity,orderCode);

                }
            }
        }

    }
    public void outPutOrder(String user){
        sumMoney=0;
        int check=0;
        System.out.println("=================================================================================");
        System.out.println("                                    BILL                                   ");
        for(Account acc : listAdmin){
            if (acc.getUsername().equalsIgnoreCase(user)){
                System.out.println("Order code: "+orderCode);
                System.out.println("Receiver: "+receiver);
                System.out.println("Address: "+address+"          Phone number: "+phoneNumber);
                break;
            }
        }
        for(Account acc : listAccount){
            if (acc.getUsername().equalsIgnoreCase(user)){
                System.out.println("Order code: "+orderCode);
                System.out.println("Receiver: "+acc.getFullName());
                System.out.println("Address: "+acc.getAddress()+"          Phone number: "+acc.getPhone());
                break;
            }
        }
        System.out.println("Day added: "+dayAdded);
        System.out.printf("%-15s%-30s%-15s%-15s%-15s\n","Product code","name product","quantity","price","origin");
        int i=0;
        for(Product s: listTempProducts){
            sumMoney+=s.getPrice()*listQuantity[i];
            System.out.printf("%-15s%-30s%-15d%-15d%-15s\n",s.getIdProduct(),s.getName(),listQuantity[i],s.getPrice(),s.getOrigin());
            i++;
        }
        System.out.println("Sum money: "+sumMoney+" VNĐ");
        System.out.println("                                    Thank you!                                   ");
        System.out.println("=================================================================================");
    }
    public void displayOrderListOfUser(String user){
        String sqlselect="select UserOrder.userName, Product.idProduct,Product.nameProduct,userOrder.quantity,userOrder.orderCode,price,day \n" +
                "from userOrder inner join Product \n" +
                "on userOrder.idProduct=Product.idProduct\n" +
                "inner join Orders on userOrder.orderCode=Orders.orderCode\n" +
                "where UserOrder.userName='"+user+"'";
        String sql="select * from userOrder";
        String s;
        int sumMoney=0;
        ResultSet resultSet;
        Statement statement= null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(sqlselect);
            int k=1;
            ArrayList<String> orderCodes=new ArrayList<>();
            String temp = null;
            while (resultSet.next()){
                String s1=resultSet.getString("nameProduct");
                int s2=resultSet.getInt("quantity");
                int s3=resultSet.getInt("price");
                String s4=resultSet.getString("day");
                s=resultSet.getString("orderCode");
                if(k==1){
                    System.out.println("Order code: "+s);
                    System.out.println("Day: "+s4);
                    System.out.printf("%-30s%-20s%-20s\n","Name product","Quantity","Price");
                    temp=s;
                    k=0;
                }
                if(!s.equals(temp)){
                    System.out.println("Sum money: "+sumMoney);
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Order code: "+s);
                    System.out.println("Day: "+s4);
                    System.out.printf("%-30s%-20s%-20s\n","Name product","Quantity","Price");
                    temp=s;
                    sumMoney=0;
                }
                sumMoney+=s3;
                System.out.printf("%-30s%-20d%-20d\n",s1,s2,s3);
            }
            System.out.println("Sum money: "+sumMoney);
            System.out.println("---------------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void displayOrderByAdmin(){

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