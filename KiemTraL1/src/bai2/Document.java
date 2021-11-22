package bai2;
import java.util.Scanner;
public class Document {
    protected int id;
    protected String name;
    protected String publisher;
    protected int price;

    public Document(int id, String name, String publisher, int price) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.price = price;
    }

    public Document() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.print("id: ");
        id=sc.nextInt();
        System.out.print("name: ");
        name=sc.nextLine();
        System.out.print("publisher: ");
        publisher=sc.nextLine();
        System.out.print("price: ");
        price=sc.nextInt();
    }
    public void xuat(){
        System.out.println("id: "+id);
        System.out.println("Name: "+name);
        System.out.println("publisher: "+publisher);
        System.out.println("price: "+price);
    }
}
