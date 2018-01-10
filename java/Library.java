import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    ArrayList<Book> catalogue;
    int capacity;

    public Library(int capacity){
        this.catalogue = new ArrayList<>();
        this.capacity = capacity;
    }
    public int countBooks() {
        return this.catalogue.size();
    }

    public void addBook(Book newBook) {
        if (isNotFull()){
            this.catalogue.add(newBook);
        }

    }

    public boolean isNotFull() {
        return capacity >= this.catalogue.size();
    }

    public Book yieldBook(){
        return this.catalogue.remove(0);
    }

    public HashMap<String, Integer> organiseByGenre(){
        HashMap<String,Integer> genreCount = new HashMap<>();
//        genreCount.put(key, genreCount.get(key) + 1);
//        HashMap<String, Integer> genreCount = new HashMap<String, Integer>();
        for (Book book: catalogue){
            String genre = book.getGenre();
            if (genreCount.containsKey(genre)){
                int count = genreCount.get(genre) + 1;
                genreCount.replace(genre, count);
            } else {
                genreCount.put(genre, 1);
            }
        }
        return genreCount;
    }
}
