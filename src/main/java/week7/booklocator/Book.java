package week7.booklocator;

public class Book {
    private String title;
    private String author;
    private int ISBN;
    private Status status;
    public Book(String title,String author,int ISBN,Status status) {
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.status=status;

    }
    public void setTitle(String title){ this.title=title;}
    public void setAuthor(String author){this.author=author;}
    public void setISBN(int ISBN){this.ISBN=ISBN;}
    public void setStatus(Status status){this.status=status;}

    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public int getISBN(){return ISBN;}
    public Status getStatus(){return status;}

    // COME BACK LATER MAYBE THERE WILL BE A PROBLEM HERE ....
    @Override
    public String toString() {
        return  "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", ISBN='" + ISBN + '\'' + ", status=" + status +"}";
    }
}
