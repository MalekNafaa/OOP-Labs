package week7.SelasReportPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesReport {

    public void generateReport(List<Sale> sales) {
        System.out.println("Full Sales Report:");
        printReport(sales);
    }

    public void generateReport(List<Sale> sales, String productCategory) {
        System.out.println("Sales Report for Category: " + productCategory);
        List<Sale> filteredSales = filterByCategory(sales, productCategory);
        printReport(filteredSales);
    }

    public void generateReport(List<Sale> sales, LocalDate startDate, LocalDate endDate) {
        System.out.println("Sales Report from " + startDate + " to " + endDate);
        List<Sale> filteredSales = filterByDateRange(sales, startDate, endDate);
        printReport(filteredSales);
    }

    private List<Sale> filterByCategory(List<Sale> sales, String productCategory) {
        List<Sale> filteredSales = new ArrayList<>();
        for (Sale sale : sales) {
            if (sale.getProductCategory().equalsIgnoreCase(productCategory)) {
                filteredSales.add(sale);
            }
        }
        return filteredSales;
    }

    // Helper method to filter sales by date range
    private List<Sale> filterByDateRange(List<Sale> sales, LocalDate startDate, LocalDate endDate) {
        List<Sale> filteredSales = new ArrayList<>();
        for (Sale sale : sales) {
            if (!sale.getDate().isBefore(startDate) && !sale.getDate().isAfter(endDate)) {
                filteredSales.add(sale);
            }
        }
        return filteredSales;
    }

    // Helper method to print the report
    private void printReport(List<Sale> sales) {
        double totalRevenue = 0;
        double averageSales = 0;
        int saleCount = 0;
        Map<String, Double> categoryRevenue = new HashMap<>();

        for (Sale sale : sales) {
            totalRevenue += sale.getAmount();
            saleCount++;
            categoryRevenue.put(sale.getProductCategory(),
                    categoryRevenue.getOrDefault(sale.getProductCategory(), 0.0) + sale.getAmount());
        }

        averageSales = saleCount == 0 ? 0 : totalRevenue / saleCount;

        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Sale Amount: $" + averageSales);

        System.out.println("Category Revenue Breakdown:");
        for (Map.Entry<String, Double> entry : categoryRevenue.entrySet()) {
            System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
        }

        System.out.println();
    }
            // THIS WAS SOOOOOOOO BADLY EXPLAINED QUESTION!!!!!!!!!!!!!!! I NEEDED TO FIND OUT EVERYTHING ALONE.
}
