package week10.q4;

import java.util.ArrayList;
import java.util.List;

public class minimain {
    public static void main(String[] args){
    List<Song> playlist = new ArrayList<>();

        playlist.add(new Song("Enta Omri", "Umm Kulthum", "Classic"));
        playlist.add(new Song("Alf Leila Wa Leila", "Umm Kulthum", "Classic"));
        playlist.add(new Song("Ahwak", "Abdel Halim Hafez", "Romantic"));
        playlist.add(new Song("Gana El Hawa", "Abdel Halim Hafez", "Romantic"));
        playlist.add(new Song("Siret El Hob", "Umm Kulthum", "Classic"));
        playlist.add(new Song("Mawood", "Abdel Halim Hafez", "Romantic"));

    String targetGenre = "Classic";
    GenreFilterIterator iterator = new GenreFilterIterator(playlist, targetGenre);

        System.out.println("Songs with genre: " + targetGenre);
        while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
}
}
