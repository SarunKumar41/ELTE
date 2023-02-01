package main;

import utils.Gender;
import utils.Person;

public class Main
{
    public static void main(String args[])
    {
        Person p1 =new Person("Sarun","Gandu","Student",2002,Gender.MALE);
        Person p3 =new Person("Sarun","Gandu","Student",2002,Gender.MALE);
        Person p2 = new Person("Bosdk","Backchod","Actor",2003,Gender.FEMALE);
        //boolean ha = p1.sameAs(p3);
        System.out.println (p1 == p2);
        System.out.println (p1.equals(p2));
        System.out.println (p2);
    }
}