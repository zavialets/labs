package lab_1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Author author = new Author.Builder("Mark Twain")
                .firstName("Samuel")
                .lastName("Clemens")
                .dateOfBirth(LocalDate.of(1835, 11, 30))
                .build();

        Library library = new Library.Builder("Central Library")
                .foundingDate(LocalDate.of(1900, 1, 1))
                .location("123 Main St")
                .build();

        Book book = new Book.Builder("The Adventures of Tom Sawyer")
                .genre("Fiction")
                .dateOfWriting(LocalDate.of(1876, 1, 1))
                .build();
        library.addBook(book);
        author.addBook(book);


        System.out.println("Author Information:\n" + author);
        System.out.println("\nBook Information:\n" + book);
        System.out.println("\nLibrary Information:\n" + library);
    }
}
