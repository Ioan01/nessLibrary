package ac.labs.library.repos;

import ac.labs.library.models.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class BookRepository {

    private int id = 0;
    private final LinkedList<Book> books = new LinkedList<>();

    public Book addBook(Book book)
    {
        book.setId(id++);
        books.add(book);

        return book;
    }

    public Iterable<Book> getAllBooksSortedByAuthorAndTitle()
    {
            return books.stream().sorted((o1, o2) -> {
                if (o1.getAuthor().equals(o2.getAuthor()))
                    return o1.getTitle().compareTo(o2.getTitle());
                return o1.getAuthor().compareTo(o2.getAuthor());
            }).toList();
    }

    public Iterable<Book> findBooksByTitle(String title)
    {
        return  books.stream().filter(book -> book.getTitle().contains(title)).toList();
    }

    public boolean deleteBook(String bookTitle,String author)
    {
        return books.removeIf(book -> book.getAuthor().equals(author) && book.getTitle().equals(bookTitle));
    }

    public boolean updateAuthor(String bookTitle,String newAuthor)
    {
        var _book = books.stream().filter(book -> book.getTitle().equals(bookTitle)).findFirst();

        _book.ifPresent(book -> book.setAuthor(newAuthor));

        return _book.isPresent();
    }

    @PostConstruct
    public void seed()
    {
        addBook(new Book().withAuthor("ZAuthor2").withTitle("aaaa2"));
        addBook(new Book().withAuthor("ZAuthor2").withTitle("cccc2"));



        addBook(new Book().withAuthor("Author1").withTitle("cccc1"));
        addBook(new Book().withAuthor("Author1").withTitle("aaaa1"));
        addBook(new Book().withAuthor("Author1").withTitle("bbbb1"));




    }



}
