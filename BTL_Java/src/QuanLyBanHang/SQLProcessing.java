package QuanLyBanHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLProcessing {
    static Connection conn = SqlServerConnection.getJDBCConnection();
    static Statement statement;
    Product sp=new Product();
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
    /*
    public static void updateProduct(String idProduct, String name, int quantity, int price, String dayAdded, String origin){
        String sqlUpdate=
                "update Product set name = N'"+name+"'," +
                        "quantity = "+quantity+
                        "',price="+price+
                        "',dayadded =" +dayAdded+
                        "',origin = "+origin+
                        " where idProduct ='"+idProduct+"'";
    }
     */
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
}
