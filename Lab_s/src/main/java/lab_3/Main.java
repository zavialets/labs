package lab_3;

import lab_1.Book;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        books.add(new Book.Builder("Book1").genre("Fiction").dateOfWriting(LocalDate.of(2020, 1, 1)).build());
        books.add(new Book.Builder("Book2").genre("Fiction").dateOfWriting(LocalDate.of(2021, 2, 1)).build());
        books.add(new Book.Builder("Book3").genre("Fasntasy").dateOfWriting(LocalDate.of(2019, 3, 1)).build());


        bookServiseStream serviceStream = new bookServiseStream(books);
        bookServiceClassic serviceClassic = new bookServiceClassic(books);


        System.out.println("Sorting by Date (Stream): " + serviceStream.sortByDate());
        System.out.println("Sorting by Date (Classic): " + serviceClassic.sortByDate());

        System.out.println("Sorting by Genre (Stream): " + serviceStream.sortByGenre());
        System.out.println("Sorting by Genre (Classic): " + serviceClassic.sortByGenre());

        System.out.println("Sorting by Author (Stream): " + serviceStream.sortByAuthor());
        System.out.println("Sorting by Author (Classic): " + serviceClassic.sortByAuthor());


        LocalDate targetDate = LocalDate.of(2022, 2, 1);
        System.out.println("List by Date (Stream): " + serviceStream.listByDate(targetDate));
        System.out.println("List by Date (Classic): " + serviceClassic.listByDate(targetDate));

        System.out.println("Oldest Book (Stream): " + serviceStream.oldestBook());
        System.out.println("Oldest Book (Classic): " + serviceClassic.oldestBook());
    }
}
