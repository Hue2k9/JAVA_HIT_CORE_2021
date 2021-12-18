package bai1;
import java.util.Scanner;
public class Person implements Comparable <Person>{
   private int id;
   private String name;
   private String address;

   public Person(int id, String name, String address) {
      this.id = id;
      this.name = name;
      this.address = address;
   }

   public Person() {
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

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
   public void input(){
      Scanner sc=new Scanner(System.in);
      System.out.print("id: ");
      id=sc.nextInt();
      sc.nextLine();
      System.out.print("Name: ");
      name=sc.nextLine();
      System.out.print("Address: ");
      address=sc.nextLine();
   }
   @Override
   public String toString() {
      return "Person{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", address='" + address + '\'' +
              '}';
   }
   @Override
   public int compareTo(Person o){
      if (this.id>o.id)
         return 1;
      else if (this.id<o.id)
         return -1;
      else
         return 0;
   }
}
