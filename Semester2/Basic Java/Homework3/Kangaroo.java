//package Homework3;
public class Kangaroo
{
    String name;
    int age;
    
    public Kangaroo (String name,int age)
    {
        this.name=name;
        this.age=age;
    } 
    public void display(String country)
    {
        System.out.println("Name: "+ name + "\nCountry: "+ country);
        age+=1;
        System.out.println("Age: "+age);
    }
    /*
    public static void main(String args[])
    {
        Kangaroo k1 = new Kangaroo("abc",11);
        k1.display("Gaon"); 
    }
    */
}