package week6;

public class StringUtils {
    public static boolean included(String word,String searched)
    {
        if(word == null || searched == null) return false;

        String insensitiveword = word.trim().toUpperCase();
        String searchedword = searched.trim().toUpperCase();

        return insensitiveword.contains(searchedword);
    }
}
