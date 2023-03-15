package ac.labs.library.controllers;

import ac.labs.library.models.Book;
import ac.labs.library.pojo.DeleteBook;
import ac.labs.library.pojo.UpdateBook;
import ac.labs.library.repos.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookRepository.addBook(book),HttpStatus.CREATED);
    }

    @GetMapping("/getBooks")
    public Iterable<Book> getBooks()
    {
        return bookRepository.getAllBooksSortedByAuthorAndTitle();
    }

    @PostMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestBody DeleteBook deleteBook)
    {
        if (deleteBook.getTitle() == null || deleteBook.getAuthor() == null)
            return new ResponseEntity<String>("Title and author must be specified", HttpStatus.BAD_REQUEST);

        if (bookRepository.deleteBook(deleteBook.getTitle(), deleteBook.getAuthor()))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<String>("Book not found", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findBooksByTitle")
    public ResponseEntity<Iterable<Book>> findBooksByTitle(@RequestParam(required = false) String title)
    {
        if (title == null)
            title = "";
        return new ResponseEntity<>(bookRepository.findBooksByTitle(title),HttpStatus.OK);
    }

    @PostMapping("/updateBookAuthor")
    public ResponseEntity<String> updateBookAuthor(@RequestBody UpdateBook updateBook)
    {
        if (updateBook.getNewAuthor() == null || updateBook.getTitle() == null)
            return new ResponseEntity<String>("Title or new author not specified", HttpStatus.BAD_REQUEST);

        if (bookRepository.updateAuthor(updateBook.getTitle(),updateBook.getNewAuthor()))
            return new ResponseEntity<String>(HttpStatus.OK);

        return new ResponseEntity<>("Book not found",HttpStatus.NOT_FOUND);
    }


}
