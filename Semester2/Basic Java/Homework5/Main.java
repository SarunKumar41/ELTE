import person.Person;
import person.Gender;
class Main
{
    public static void main(String args[])
    {
        Person me = new Person("Kumar","Sarun","Student",Gender.MALE,2002);
        Person mySelf = new Person("Kumar","Sarun","Student",Gender.MALE,2002);

        System.out.println(me.sameAs(mySelf));
        System.out.println(me.toString());
        System.out.println(mySelf.toString());
    }
}