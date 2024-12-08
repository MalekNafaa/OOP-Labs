package LibraryManagementSystem;


import java.util.Date;
import java.util.HashMap;

public class Book extends Item{
    private Gernre genre;
    private int pageCount;

    Book(String itemId,String title,String author,boolean isAvailable,Gernre genre,int pageCount){
        super(itemId,title,author,isAvailable);
        this.genre = genre;
        this.pageCount = pageCount;
    }

    @Override
    public String getDescription(){
        return super.getDescription()+" genre"+ genre+" pagecount "+pageCount;
    }

    void getGenre(Gernre genre){ this.genre = genre; }
    void getPageCount(int pageCount){this.pageCount = pageCount;}

    Gernre getGenre(){return genre;}
    int getPageCount(){return pageCount;}


}
