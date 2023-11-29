import lab_4.Book;
import lab_4.BookBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class BookTest {

    @Test
    public void testValidBook() {

        int id = 1;
        String title = "The Book Title";
        String genre = "Fiction";
        LocalDate dateOfWriting = LocalDate.now();

        Book validBook = new Book(id, title, genre, dateOfWriting);

        Assert.assertNotNull(validBook);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidBook() {

        int id = 1;
        String title = "";
        String genre = "Fiction";
        LocalDate dateOfWriting = LocalDate.now();

        Book invalidBook = new Book(id, title, genre, dateOfWriting);
    }

    @Test
    public void testValidBookBuilder() {

        String title = "The Book Title";
        String genre = "Fiction";
        LocalDate dateOfWriting = LocalDate.now();

        Book validBook = new BookBuilder()
                .title(title)
                .genre(genre)
                .dateOfWriting(dateOfWriting)
                .build();


        Assert.assertNotNull(validBook);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidBookBuilder() {

        String title = "";
        String genre = "Fiction";
        LocalDate dateOfWriting = LocalDate.now();

        Book invalidBook = new BookBuilder()
                .title(title)
                .genre(genre)
                .dateOfWriting(dateOfWriting)
                .build();
    }
}
