package week6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    //int[] values = {6,5,8,6,11};
    //int[] values = {-1, 6, 9, 8, 12};
    //System.out.println("Smallest :"+smallest(values));
    //System.out.println("Index of smallest: " + indexOfSmallest(values));
    //System.out.println(indexOfTheSmallestStartingFrom(values, 1));
    //System.out.println(indexOfTheSmallestStartingFrom(values, 2));
    //System.out.println(indexOfTheSmallestStartingFrom(values, 4));
    /*int[] values = {3, 2, 5, 4, 8};
    System.out.println(Arrays.toString(values));
    swap(values, 1, 0);
    System.out.println(Arrays.toString(values));
    swap(values, 0, 3);
    System.out.println(Arrays.toString(values));*/
     /* int[] array = {-3, 2, 3, 4, 7, 8, 12};
        Scanner reader = new Scanner(System.in);
        System.out.println("Values of the array: " + Arrays.toString(array));
        System.out.println();
        System.out.println("Enter searched number: ");
        String searchedValue = reader.nextLine();
        System.out.println();
        boolean result = BinarySearch.search(array, Integer.parseInt(searchedValue));
        if (result) {
            System.out.println("Value found in array.");
        } else {
            System.out.println("Value not found in array.");
        }*/
        int[] array = {5, 1, 3, 4, 2};
        printElegantly(array);


    }


    public static int smallest(int[] array)
    {
        int smallest = array[0];
        for(int num : array)
        {
            if(num < smallest) smallest = num;
        }
        return smallest;
    }
    public static int indexOfSmallest(int[] array)
    {
        int smallest = array[0];
        int index = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] < smallest)
            {
                smallest = array[i];
                index = i;
            }
        }
        return index;
    }
    public static int indexOfTheSmallestStartingFrom(int[] array, int index){
        int smallest = array[index];
        int indexOfSmallest = index;
        for(int i = index; i < array.length; i++)
        {
            if(array[i] < smallest)
            {
                smallest = array[i];
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }
    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void printElegantly(int[]array) {
        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1) System.out.print(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
    }
}

class BinarySearch{
    public static boolean search(int[] array, int target)
    {
        int low = 0;
        int high = array.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(array[mid] == target)
            {
                return true;
            }
            if(array[mid] < target){
                low = mid + 1;
            }
            else if(array[mid] > target){
                high = mid - 1;
            }
        }
        return false;
    }
}
