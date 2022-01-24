package QuanLyBanHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnection {
    public static Connection getJDBCConnection(){
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=BTL_Java_QLBH;user=sa;password=123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}
