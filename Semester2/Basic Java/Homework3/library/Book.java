package library;
public class Book
{
    String title,author;
    int year,pages;
    boolean borrowable;
    
    public Book(String title,String author,int year,int pages, boolean borrowable)
    {
        this.title=title;
        this.author=author;
        this.year=year;
        this.pages=pages;
        this.borrowable=borrowable;
    }
    public Book(Book b)
    {
        if(b == null) throw new IllegalArgumentException("Just checking if it works :)");
        this.title=b.title;
        this.author=b.author;
        this.year=b.year;
        this.pages=b.pages;
        this.borrowable=b.borrowable;
    }
    public String toString()
    {
        return ("title: "+title + " author: "+author + " year: " + Integer.toString(year) + " pages: " + Integer.toString(pages) + " borrowable: " + Boolean.toString(borrowable) );
        //return (name+" "+ipAddress+" "+Integer.toString(health)+" "+"No vehicle");
    }
    public boolean SameAs(Book b)
    {
        if(title==b.title && author==b.author && year==b.year && pages==b.pages) return true;

        return false;
    }

}