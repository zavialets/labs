package lab_3;

import lab_1.Book;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class bookServiseStream implements bookServiceM{
    private final Set<Book> books;

    public bookServiseStream(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public boolean add(Book book) throws UnsupportedOperationException, ClassCastException {
        return books.add(book);
    }

    @Override
    public boolean remove(Book book) throws UnsupportedOperationException, ClassCastException {
        return books.remove(book);
    }

    @Override
    public boolean remove(int idx) {
        int i = 0;
        for(Book album : books){
            if (i == idx){
                return books.remove(album);
            }
            i++;
        }
        return false;
    }
    @Override
    public List<Book> sortByDate() {
        return getBooks().stream()
                .sorted(Comparator.comparing(Book::getDateOfWriting))
                .collect(Collectors.toList());
    }
    @Override
    public List<Book> sortByGenre() {
        return getBooks().stream()
                .sorted(Comparator.comparing(Book::getGenre))
                .collect(Collectors.toList());
    }
    @Override
    public List<Book> sortByAuthor() {
        return getBooks().stream()
                .sorted(Comparator.comparing(book -> book.getAuthor().getFirstName()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Book> listByDate(LocalDate targetDate) {
        return getBooks().stream()
                .filter(book -> book.getDateOfWriting().equals(targetDate))
                .collect(Collectors.toList());
    }
    @Override
    public Book oldestBook() {
        return getBooks().stream()
                .min(Comparator.comparing(Book::getDateOfWriting))
                .orElse(null);
    }
}


