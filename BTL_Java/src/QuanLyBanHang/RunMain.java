package QuanLyBanHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class RunMain {
    public static void main(String[] args) throws SQLException {
        Manage nv=new Manage();
        Scanner sc=new Scanner(System.in);
         ArrayList<Product> listProduct =new ArrayList<Product>();



       //Connect to Sql Server
         Connection conn=SqlServerConnection.getJDBCConnection();
         Statement statement=conn.createStatement();

         //1. read data: select
         String sqlSelect = "select * from Product";
         ResultSet resultSet = statement.executeQuery(sqlSelect);
         while(resultSet.next()){
             String s= resultSet.getString(2);
             System.out.println(s);
         }

         //2. Insert data: insert
         String sqlInsert="insert into Product values ('sp08',N'Sach lap trinh C',3,999,'7/5/2020',N'Singaproe')";
         statement.executeUpdate(sqlInsert);

         //3. update data: update
        String sqlUpdate ="update Product set nameProduct = N'Lập trình java', price=9, quantity=5 where idProduct = 'sp08'";
        statement.executeUpdate(sqlUpdate);

        //4. Delete data: delete
        String sqlDelete ="delete from Product where idProduct = 'sp08'";
        statement.executeUpdate(sqlDelete);




        int menu;
        do{
            System.out.println("=====MANAGE=====");
            System.out.println("1. Staff");
            System.out.println("2. Product");
            System.out.println("3. Order");
            System.out.println("4. Exit");
            System.out.print("Enter your choose: ");
            menu = sc.nextInt();
            switch(menu){
                case 1:{
                    int list;
                    do{
                        System.out.println("1. Insert staff");
                        System.out.println("2. Find staff");
                        System.out.println("3. Delete staff");
                        System.out.println("4. Display list staff");
                        System.out.println("5. Exit");
                        System.out.print("Enter your choose: ");
                        list=sc.nextInt();
                        switch (list){
                            case 1:{
                                nv.insertStaff();
                                break;
                            }
                            case 2:{
                                nv.findStaff();
                                break;
                            }
                            case 3:{
                                nv.deleteStaff();
                                break;
                            }
                            case 4:{
                                nv.displayListStaff();
                                break;
                            }
                        }
                    } while(list!=5);
                    break;
                }
                case 2:{
                    int list;
                    do{
                        System.out.println("1. Insert product");
                        System.out.println("2. Find product");
                        System.out.println("3. Delete product");
                        System.out.println("4. Fix product selling price");
                        System.out.println("5. Display product list by selling price");
                        System.out.println("6. Display product list by quantity");
                        System.out.println("7. Exit");
                        System.out.print("Enter your choose: ");
                        list=sc.nextInt();
                        switch (list){
                            case 1:{
                                nv.insertProduct();
                                break;
                            }
                            case 2:{
                                nv.findProduct();
                                break;
                            }
                            case 3:{
                                nv.deleteProduct();
                                break;
                            }
                            case 4:{
                                nv.editThePrice();
                                break;
                            }
                            case 5:{
                                nv.sortProductByPrice();
                                break;
                            }
                            case 6:{
                                nv.sortProductByQuantity();
                                break;
                            }
                        }
                    } while(list!=7);
                    break;
                }
                case 3:{
                    int list;
                    do{
                        System.out.println("1. Insert order");
                        System.out.println("2. Delete order");
                        System.out.println("3. edit order");
                        System.out.println("4. Display sum of orders");
                        System.out.println("5. Display order list");
                        System.out.println("6. Find order by receiver address");
                        System.out.println("7. Exit");
                        System.out.print("Enter your choose: ");
                        list=sc.nextInt();
                        switch (list){
                            case 1:{
                                nv.addOrder();
                                break;
                            }
                            case 2:{
                                nv.deleteOrder();
                                break;
                            }
                            case 3:{
                                nv.editOrder();
                                break;
                            }
                            case 4:{

                                break;
                            }
                            case 5:{
                                nv.displayOrder();
                                break;
                            }
                            case 6:{
                                nv.findAllOrderByAddress();
                                break;
                            }
                        }
                    } while(list!=7);
                    break;
                }
            }
        } while(menu!=4);
    }
}
