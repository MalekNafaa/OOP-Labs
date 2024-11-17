package week7.SelasReportPackage;

import java.time.LocalDate;

public class Sale {
    private String productCategory;
    private double amount;
    private LocalDate date;

    public Sale(String productCategory, double amount, LocalDate date) {
        this.productCategory = productCategory;
        this.amount = amount;
        this.date = date;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}