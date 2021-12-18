package bai1;
import java.util.*;
import java.util.ArrayList;
public class RunMain {
    public static void main(String[] args){
        List<Person> list = new ArrayList<Person>();
        int n;
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter n: ");
            n=sc.nextInt();
            for(int i=0; i<n; i++){
                Person p=new Person();
                p.input();
                list.add(p);
            }
        }catch (Exception ex){
            System.out.println("Du lieu nhap khong dung");
        }
        finally {
            System.out.println("Finish!");
        }
        System.out.println("Sap xep theo chieu tang dan id: ");
        Collections.sort(list);
        for(Person p : list){
            System.out.println(p.toString());
        }

        System.out.println("Sap xep theo ten: ");
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getName().compareTo(o2.getName())==0)
                    return o1.getAddress().compareTo(o2.getAddress());
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });
        for(Person p : list){
            System.out.println(p.toString());
        }
    }
}
