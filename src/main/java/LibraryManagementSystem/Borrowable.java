package LibraryManagementSystem;

public interface Borrowable {
    double applyLateFee(int daysLate);
    String getDescription();

}
