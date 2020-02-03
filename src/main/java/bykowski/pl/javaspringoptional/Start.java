package bykowski.pl.javaspringoptional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Start {

    private BookRepo bookRepo;

    @Autowired
    public Start(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
        bookRepo.save(new Book("Książka Spring Boot 2", "9782123456803"));
        bookRepo.save(new Book("Aplikcje internetowe", "9782123456803"));
        bookRepo.save(new Book("Java dla zaawansowanych", "9782123456803"));
    }
}
