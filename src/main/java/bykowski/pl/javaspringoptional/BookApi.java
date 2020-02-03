package bykowski.pl.javaspringoptional;

import bykowski.pl.javaspringoptional.exception.BookNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookApi {

    private BookRepo bookRepo;

    public BookApi(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable long id) {
        return bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/book/{id}")
    public Book getBook(@RequestBody Book newBook, @PathVariable long id) {
        return bookRepo.findById(id)
                .map(element -> {
                    element.setTitle(newBook.getTitle());
                    element.setIsbn(newBook.getIsbn());
                    return bookRepo.save(element);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookRepo.save(newBook);
                });
    }

}
