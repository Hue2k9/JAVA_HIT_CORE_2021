package QuanLyBanHang;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Formatter;
public class Product  implements Comparable<Product> {
    private String idProduct;
    private String name;
    private int quantity;
    private int price;
    private String dayAdded;
    private String origin;
    public Product() {
    }

    public Product(String idProduct, String name, int quantity, int price, String dayAdded, String origin) {
        this.idProduct = idProduct;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.dayAdded = dayAdded;
        this.origin = origin;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDayAdded() {
        return dayAdded;
    }

    public void setDayAdded(String dayAdded) {
        this.dayAdded = dayAdded;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        /*
        System.out.print("ID product: ");
        idProduct=sc.nextLine();
         */
        System.out.print("Name product: ");
        name=sc.nextLine();
        System.out.print("Quantity: ");
        quantity= sc.nextInt();
        sc.nextLine();
        System.out.print("Price: ");
        price=sc.nextInt();
        sc.nextLine();
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy");
        String strDate = formatter.format(date);
        dayAdded=strDate;
        /*
        System.out.print("Day added: ");
        dayAdded=sc.nextLine();
  */
        System.out.print("Origin: ");
        origin=sc.nextLine();
    }
    public void output(){
        System.out.printf("%-15s%-40s%-15d%-15d%-15s%s\n",getIdProduct(),getName(),getQuantity(),getPrice(),getDayAdded(),getOrigin());

    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", dayAdded='" + dayAdded + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (this.price>o.price)
            return 1;
        else if (this.price<o.price)
            return -1;
        else
            return 0;
    }
}
