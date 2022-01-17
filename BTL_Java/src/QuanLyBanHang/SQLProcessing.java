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

    public boolean addProducttoSQL(Product sp){
        String sql="insert into Product(idProduct,nameProduct,quantity,price,dayAdded,origin)"
                +"values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,sp.getIdProduct());
            ps.setString(2,sp.getName());
            ps.setInt(3,sp.getQuantity());
            ps.setInt(4,sp.getPrice());
            ps.setString(5,sp.getDayAdded());
            ps.setString(6,sp.getOrigin());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
        String sql="insert into NhanVien(idStaff,nameStaff,age,gender,addressStaff,totalDays,phoneNumber)"
                +"values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,nv.getIdStaff());
            ps.setString(2,nv.getName());
            ps.setInt(3,nv.getAge());
            ps.setString(4,nv.getGender());
            ps.setString(5,nv.getAddress());
            ps.setInt(6,nv.getTotalDays());
            ps.setInt(7,nv.getPhoneNumber());
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
                 resultSet.getInt(7)
               );
               nhanViens.add(nhanVien);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }

    //Orders


}
