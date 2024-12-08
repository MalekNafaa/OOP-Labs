package LibraryManagementSystem;

import java.util.Date;

public class Magazine extends Item {
    private int issueNumber;
    private Date publictionDate;

    Magazine(String itemId,String title,String author,boolean isAvailable,int issueNumber,Date publicationDate) {
        super(itemId,title,author,isAvailable);
        this.issueNumber = issueNumber;
        this.publictionDate = publicationDate;
    }
    @Override
    public String getDescription() {
        return super.getDescription() +"Magazine num: "+issueNumber + "date: "+publictionDate;
    }
    void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
    void setPublicationDate(Date publicationDate) {
        this.publictionDate = publicationDate;
    }
    int getIssueNumber(){return issueNumber;}
    Date getPublicationDate(){return publictionDate;}


}
