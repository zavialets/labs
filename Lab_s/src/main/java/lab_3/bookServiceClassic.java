package lab_3;

import lab_1.Book;

import java.util.Set;
import java.time.LocalDate;
import java.util.*;

public class bookServiceClassic implements bookServiceM{
    private final Set<Book> books;

    public bookServiceClassic(Set<Book> books) {
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
        List<Book> sortedBooks = new ArrayList<>(this.getBooks());
        Collections.sort(sortedBooks, Comparator.comparing(Book::getDateOfWriting));
        return sortedBooks;
    }

    @Override
    public List<Book> sortByGenre() {
        List<Book> sortedBooks = new ArrayList<>(this.getBooks());
        Collections.sort(sortedBooks, Comparator.comparing(Book::getGenre));
        return sortedBooks;
    }

    @Override
    public List<Book> sortByAuthor() {
        List<Book> sortedBooks = new ArrayList<>(this.getBooks());
        Collections.sort(sortedBooks, Comparator.comparing(book -> book.getAuthor().getFirstName()));
        return sortedBooks;
    }

    @Override
    public List<Book> listByDate(LocalDate targetDate) {
        List<Book> result = new ArrayList<>();
        for (Book book : this.getBooks()) {
            if (book.getDateOfWriting().equals(targetDate)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public Book oldestBook() {
        List<Book> books = (List<Book>) getBooks();
        if (books.isEmpty()) {
            return null;
        }

        Book oldest = books.get(0);
        for (Book book : books) {
            if (book.getDateOfWriting().isBefore(oldest.getDateOfWriting())) {
                oldest = book;
            }
        }
        return oldest;
    }
}
