package bykowski.pl.javaspringoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicExample {

    private List<Book> books;

    public BasicExample() {
        init();
        Optional<Book> book = books.stream().filter(element -> element.getTitle().equals("Książka Spring Boot 3")).findFirst();
        book.orElseGet(
                () -> new Book("Spring w akcji", "9782123226803"));
    }

    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Książka Spring Boot 2", "9782123456803"));
        books.add(new Book("Aplikcje internetowe", "9782123456803"));
        books.add(new Book("Java dla zaawansowanych", "9782123456803"));
    }


    public static void main(String[] args) {
        new BasicExample();
    }
}




