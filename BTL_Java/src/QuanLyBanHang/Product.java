package QuanLyBanHang;

import java.util.Scanner;

public class Product implements Comparable<Product>{
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
        System.out.print("ID product: ");
        idProduct=sc.nextLine();
        System.out.print("Name product: ");
        name=sc.nextLine();
        System.out.print("Quantity: ");
        quantity= sc.nextInt();
        sc.nextLine();
        System.out.print("Price: ");
        price=sc.nextInt();
        sc.nextLine();
        System.out.print("Day added: ");
        dayAdded=sc.nextLine();

        System.out.print("Origin: ");
        origin=sc.nextLine();
    }
    public void output(){
        System.out.println("Id product: "+getIdProduct());
        System.out.println("Name product: "+getName());
        System.out.println("Quantity: "+getQuantity());
        System.out.println("Price: "+getPrice());
        System.out.println("Day added: "+getDayAdded());
        System.out.println("Origin: "+getOrigin());
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
