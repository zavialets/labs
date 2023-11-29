package lab_3;
import lab_1.Book;
import java.time.LocalDate;
import java.util.List;

public interface bookServiceM {
    boolean add(Book book);
    boolean remove(Book book);
    boolean remove(int idx);
    List<Book> sortByDate();
    List<Book> sortByGenre();
    List<Book> sortByAuthor();
    List<Book> listByDate(LocalDate targetDate);
    Book oldestBook();

}