package week6;

import java.util.ArrayList;
import java.util.List;

public class ListOfAnyType<T>
{
    private List<T> list = new ArrayList<>();

    public List<T> getListReversed()
    {
        List<T> reversed = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--)
        {
            reversed.add(list.get(i));
        }
        return reversed;
    }
    public void add(T something)
    {
        list.add(something);
    }


    public static void main(String[] args)
    {
        ListOfAnyType<String> list = new ListOfAnyType<>();
        list.add("malek");
        list.add("niga");
        System.out.println(list.getListReversed());


    }
}
