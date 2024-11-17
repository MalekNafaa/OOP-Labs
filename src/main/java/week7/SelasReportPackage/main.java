package week7.SelasReportPackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Sample sales data
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale("Electronics", 200.00, LocalDate.of(2023, 1, 15)));
        sales.add(new Sale("Clothing", 50.00, LocalDate.of(2023, 1, 20)));
        sales.add(new Sale("Electronics", 150.00, LocalDate.of(2023, 2, 10)));
        sales.add(new Sale("Groceries", 30.00, LocalDate.of(2023, 2, 15)));
        sales.add(new Sale("Clothing", 75.00, LocalDate.of(2023, 3, 5)));
        sales.add(new Sale("Electronics", 300.00, LocalDate.of(2023, 3, 10)));

        SalesReport report = new SalesReport();

        report.generateReport(sales);

        report.generateReport(sales, "Electronics");

        report.generateReport(sales, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 28));
    }
}
