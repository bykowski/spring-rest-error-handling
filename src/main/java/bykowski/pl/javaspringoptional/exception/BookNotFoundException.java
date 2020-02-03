package bykowski.pl.javaspringoptional.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(long id) {
        super("Could not find book: " + id);
    }
}
