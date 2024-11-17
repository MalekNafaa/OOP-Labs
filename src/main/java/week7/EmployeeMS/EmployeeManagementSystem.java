package week7.EmployeeMS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {

    private final List<EmployeeRecord> employees = new ArrayList<>();

    public void addEmployee(EmployeeRecord employee) {
        employees.add(employee);
    }

    public List<EmployeeRecord> filterEmployeesWithOverFiveYears() {
        List<EmployeeRecord> longTermEmployees = new ArrayList<>();
        for (EmployeeRecord employee : employees) {
            if (employee.overFiveYears()) {
                longTermEmployees.add(employee);
            }
        }
        return longTermEmployees;
    }

    public double calculateAverageSalary(String position) {
        double totalSalary = 0;
        int count = 0;

        for (EmployeeRecord employee : employees) {
            if (employee.position().equalsIgnoreCase(position)) {
                totalSalary += employee.salary();
                count++;
            }
        }

        return count > 0 ? totalSalary / count : 0;
    }

    public List<EmployeeRecord> findEmployeesByRole(String role) {
        List<EmployeeRecord> roleEmployees = new ArrayList<>();
        for (EmployeeRecord employee : employees) {
            if (employee.position().equalsIgnoreCase(role)) {
                roleEmployees.add(employee);
            }
        }
        return roleEmployees;
    }

    public void printEmployeeDetails(List<EmployeeRecord> employeeList) {
        for (EmployeeRecord employee : employeeList) {
            System.out.println(employee);
        }

}
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.addEmployee(new EmployeeRecord("Alice", "Senior Developer", 80000, LocalDate.of(2015, 5, 20)));
        ems.addEmployee(new EmployeeRecord("Bob", "Junior Developer", 50000, LocalDate.of(2020, 8, 15)));
        ems.addEmployee(new EmployeeRecord("Charlie", "Senior Developer", 85000, LocalDate.of(2016, 3, 10)));
        ems.addEmployee(EmployeeRecord.createIntern("Diana"));

        System.out.println("Employees with over 5 years:");
        List<EmployeeRecord> longTermEmployees = ems.filterEmployeesWithOverFiveYears();
        ems.printEmployeeDetails(longTermEmployees);

        System.out.println("\nAverage Salary for Senior Developers:");
        double averageSalary = ems.calculateAverageSalary("Senior Developer");
        System.out.println("Average Salary: " + averageSalary);

        System.out.println("\nSenior Developers:");
        List<EmployeeRecord> seniorDevelopers = ems.findEmployeesByRole("Senior Developer");
        ems.printEmployeeDetails(seniorDevelopers);
    }

}
