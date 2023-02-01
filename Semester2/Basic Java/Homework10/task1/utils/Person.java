package utils;
import java.util.Objects;
public class Person
{
    String givenName,surName,occupation;
    int yoB;
    Gender gender;

    public Person(String givenName,String surName,String occupation,int yoB,Gender gender)
    {
        this.givenName = givenName;
        this.surName = surName;
        this.occupation = occupation;
        this.yoB = yoB;
        this.gender = gender;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(givenName).append(" ").append(surName);
        sb.append("\nOccupation : ").append(occupation);
        sb.append("\nYear of Birth : ").append(yoB);
        sb.append("\nGender : ").append(gender);
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    public Boolean sameAs(Person that)
    {
        if (that == null){ return false;}

        return ((that.givenName == this.givenName) && (that.surName == this.surName) && (that.occupation == this.occupation) && (that.yoB == this.yoB) && (that.gender == this.gender));
    }

    @Override 
    public boolean equals(Object that)
    {
        if (that == null)
        {
            return false;
        }
        else if (that instanceof Person)
        {
            Person thatPerson = (Person)that;
            return ((thatPerson.givenName == givenName) && (thatPerson.surName == surName) && (thatPerson.occupation == occupation) && (thatPerson.yoB == yoB) && (thatPerson.gender == gender));
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(givenName,surName,occupation,yoB,gender);
    }
}   