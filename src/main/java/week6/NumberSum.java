package week6;
import java.util.ArrayList;
import java.util.List;

public class NumberSum {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        double sumEven = 0;
        double sumOdd = 0;

        for (T number : numbers) {
            double num = number.doubleValue();
            if(num%2==0) sumEven += num;
            else sumOdd += num;

        }
        System.out.println("Even: "+sumEven);
        System.out.println("Odd: "+sumOdd);

    }

    public static void main(String[] args) {
    List<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    integerList.add(3);
    integerList.add(4);
    integerList.add(5);

    System.out.println("Integer list:");
    sumEvenOdd(integerList);

    List<Double> doubleList = new ArrayList<>();
    doubleList.add(1.0);
    doubleList.add(2.5);
    doubleList.add(3.0);
    doubleList.add(4.0);
    doubleList.add(5.5);

    System.out.println("\nDouble list:");
    sumEvenOdd(doubleList);
    }
}

