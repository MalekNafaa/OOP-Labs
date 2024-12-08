package week10.q2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class smallmain {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        List<Integer> grades = Arrays.asList(85, 90, 78, 92);
        Student student = new Student("John Doe", "S123", grades);
        GradeAnalyzer analyzer = new GradeAnalyzer(grades);
        //System.out.println(analyzer.calculateAverage());


        //Access and print the field names and their values for both the GradeAnalyzer and Student classes.


        Field[] fields = student.getClass().getDeclaredFields();
        for(Field field : fields)
        {
            field.setAccessible(true);
            System.out.println("Field: "+field.getName() + " , value: "+field.get(student));
        }
        Field[] fieldsTwo = analyzer.getClass().getDeclaredFields();
        for(Field field : fieldsTwo)
        {
            field.setAccessible(true);
            System.out.println("Field: "+field.getName() + " , value: "+field.get(analyzer));
        }


        Method[] methods = student.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                System.out.print("Invoking method: " + method.getName() + " - ");
                Object result = method.invoke(student);
                if (method.getReturnType() != void.class) {
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Method invoked successfully.");
                }
            }
        }
        Method[] methodsTWo = analyzer.getClass().getDeclaredMethods();
        for (Method method : methodsTWo) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                System.out.print("Invoking method: " + method.getName() + " - ");
                Object result = method.invoke(analyzer);
                if (method.getReturnType() != void.class) {
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Method invoked successfully.");
                }
            }
        }

    }
}
