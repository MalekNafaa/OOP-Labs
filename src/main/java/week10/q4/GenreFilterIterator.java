package week10.q4;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class GenreFilterIterator implements Iterator<Song> {
    private List<Song> playlist;
    private String targetGenre;
    private int currentIndex;

    public GenreFilterIterator(List<Song> playlist, String targetGenre) {
        this.playlist = playlist;
        this.targetGenre = targetGenre.toLowerCase();
        this.currentIndex = 0;
        moveToNextGenre();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < playlist.size();
    }

    @Override
    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more songs with genre: " + targetGenre);
        }
        Song currentSong = playlist.get(currentIndex);
        currentIndex++;
        moveToNextGenre();
        return currentSong;
    }

    private void moveToNextGenre() {
        while (currentIndex < playlist.size() &&
                !playlist.get(currentIndex).getGenre().toLowerCase().equals(targetGenre)) {
            currentIndex++;
        }
    }
}