/*
Create an enumeration type Gender containing the two values Gender.MALE and Gender.FEMALE.
Create class Person to hold personal data: surname, given name (both String), occupation (String), gender (Gender) and year of birth (int).
The class should have a constructor accepting initialisation values for all the attributes.
Create a method toString() in the class, with return type String. This method converts personal data to a formatted string.
Create a sameAs(Person that) method as well, which returns true if (and only if) the current person has the same personal data as the "Person that",
passed as parameter. Be careful with a possibly null parameter. For such a parameter the method should return false.
The Person class and the Gender type should be in package person. Create a main program in package main.
The main program should create two person objects, and checks whether they are the "same".
The result of the comparison and the two objects should be printed on the standard output.
*/
/**
* @author  Sarun Kumar
* @version 1.0
* @since   2022-03-28
*/
package person;

public class Person
{
    String surname,givenName,occupation;
    Gender gender;
    int year;
    public Person(String surname, String givenName,String occupation,Gender gender,int year)
    {
        this.surname=surname;
        this.givenName=givenName;
        this.occupation=occupation;
        this.gender=gender;
        this.year=year;
    /**

     * @param  surName  Surname of a person

     * @param  givName  Givenname of a person

     * @param  occupation  Occupation of a person

     * @param  gender  Gender of a person

     * @param  birthYear  Birth year of a person

     * @return No return

     */
    }

    public String toString()
    {
        return "Surname: "+ surname +  " GivenName: " + givenName + " Occupation: " + occupation + " Gender: "+ gender  + " year: "+ year;
    }
    public boolean sameAs(Person that)
    {
        if(that!=null)
        {
            if(surname==that.surname && givenName==that.givenName && occupation==that.occupation && gender==that.gender && year==that.year) return true;
            else return false;
        }
        else
        return false;
    }
}