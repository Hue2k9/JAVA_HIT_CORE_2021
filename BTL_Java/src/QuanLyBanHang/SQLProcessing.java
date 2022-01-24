package QuanLyBanHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLProcessing {
    static Connection conn = SqlServerConnection.getJDBCConnection();
    static Statement statement;
    Product sp=new Product();
    NhanVien nv=new NhanVien();
    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<orderCode> readOrderCode(String user, String day){
        List<orderCode> orderCodes=new ArrayList<>();
        String sql="select * from Orders where userName='"+user+"' and day='"+day+"'";

        try {
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                orderCode order=new orderCode(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                orderCodes.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderCodes;
    }
    public boolean addOrderCode(String user,String day){
        String sql="insert into Orders(userName,day)"+"values(?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,day);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addOrder(String user,String codeProduct,int quantity, String orderCode){
        String sql="insert into userOrder(userName,idProduct,quantity,orderCode)"
                +"values(?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,codeProduct);
            ps.setInt(3,quantity);
            ps.setString(4,orderCode);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Account> readAllAccount(){
        String sql="select * from users";
        List<Account> accounts = new ArrayList<>();
        try {
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Account account=new Account(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    public static List<Account> readAdminAccount(){
        String sql="select * from Admin";
        List<Account> accounts = new ArrayList<>();
        try {
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Account account=new Account(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    public boolean addAccountToSQL(Account acc){
        String sql="insert into Users(userName,password,name,phoneNumber,address,email)"+
                "values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,acc.getUsername());
            ps.setString(2,acc.getPassword());
            ps.setString(3,acc.getFullName());
            ps.setString(4,acc.getPhone());
            ps.setString(5,acc.getAddress());
            ps.setString(6,acc.getEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
    public static int findAccount(String userName){
        String sqlFind="select userName from Users where userName='"+userName+"'";
        try {
            return statement.executeUpdate(sqlFind);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

     */
    public static int updateAccount(String userName,String password,String Name, String phoneNumber, String address, String email){
        String sqlUpdate="update Users set password='"+password+"',name=N'"+Name+"' ,phoneNumber='"+phoneNumber+"',address=N'"+address+"',email='"+email+"' where userName='"+userName+"'";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean addProducttoSQL(Product sp){
        String sql="insert into Product(nameProduct,quantity,price,dayAdded,origin)"
                +"values(?,?,?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,sp.getName());
            ps.setInt(2,sp.getQuantity());
            ps.setInt(3,sp.getPrice());
            ps.setString(4,sp.getDayAdded());
            ps.setString(5,sp.getOrigin());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static int findProduct(String idProduct){
        String sqlFind="select * from Product where idProduct='"+idProduct+"'";
        try {
            return statement.executeUpdate(sqlFind);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static int updateProduct(String idProduct,int price){
        String sqlUpdate="update Product set price="+price+" where idProduct='"+idProduct+"'";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static int deleteProduct(String idProduct){
        String sqlDelete = "delete Product where idProduct = '"+idProduct+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public static List<Product> readProductByCode(String idProduct){
        List<Product> products = new ArrayList<>();
        String sql="select * from Product where idProduct='"+idProduct+"'";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Product product=new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                products.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }
    public static List<Product> readAllProduct(){
        List<Product> products = new ArrayList<>();
        String sql="select * from Product";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Product product=new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                products.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }
    // ============Staff===========
    public boolean addStaffToSQL(NhanVien nv){
        String sql="insert into NhanVien(nameStaff,age,gender,addressStaff,totalDays,phoneNumber)"
                +"values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,nv.getName());
            ps.setInt(2,nv.getAge());
            ps.setString(3,nv.getGender());
            ps.setString(4,nv.getAddress());
            ps.setInt(5,nv.getTotalDays());
            ps.setString(6,nv.getPhoneNumber());
          return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int deleteStaff(String idStaff){
        String sqlDelete = "delete NhanVien where idStaff='"+idStaff+"'";
        try{
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static List<NhanVien> readAllStaff(){
        List<NhanVien> nhanViens = new ArrayList<>();
        String sql="select * from NhanVien";
        try {
            ResultSet resultSet=statement.executeQuery(sql);
           while (resultSet.next()){
               NhanVien nhanVien=new NhanVien(
                 resultSet.getString(1),
                 resultSet.getString(2),
                 resultSet.getInt(3),
                 resultSet.getString(4),
                 resultSet.getString(5),
                 resultSet.getInt(6),
                 resultSet.getString(7)
               );
               nhanViens.add(nhanVien);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }

    //============Orders============
    public boolean addOrderToSQL(Order or){
        String sql="insert into Orders(receiver,addressClient,quantity,phoneNumber,idProduct,dayAdded)"
                +"values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,or.getReceiver());
            ps.setString(2,or.getAddress());
            ps.setInt(3,or.getQuantity());
            ps.setString(4,or.getPhoneNumber());
            ps.setString(5,or.getCodeProduct());
            ps.setString(6,or.getDayAdded());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static int updateOrder(String orderCode, String receiver, String address, int quantity, String phone, String codeProduct,String dayAdded){
        String sqlUpdate="update Orders set price='"+orderCode+"','"+receiver+"','"+address+"','"+quantity+"','"+phone+"','"+codeProduct+"','"+dayAdded+"'";
        try{
            return statement.executeUpdate(sqlUpdate);
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public static int deleteOrder(String orderCode){
        String sqlDelete="delete Orders where orderCode='"+orderCode+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public static List<Order> readAllOrder(){
        List<Order> orders = new ArrayList<>();
        String sql="select * from Orders";
        try{
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Order order=new Order(
                  resultSet.getString(1),
                  resultSet.getString(2),
                  resultSet.getString(3),
                  resultSet.getInt(4),
                  resultSet.getString(5),
                  resultSet.getString(6),
                  resultSet.getString(7),
                        resultSet.getString(8)
                );
                orders.add(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

}
