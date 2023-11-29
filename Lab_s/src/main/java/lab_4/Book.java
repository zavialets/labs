package lab_4;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.Objects;



public class Book{
    @Positive(message = "ID of book must be a positive number")
    private int idOfBook;

    @NotBlank(message = "Title cannot be blank")
    @Pattern(regexp = "[a-zA-Z0-9\\s]+", message = "Title can consist only of letters and digits")
    private String title;

    @NotBlank(message = "Genre cannot be blank")
    @Pattern(regexp = "[a-zA-Z]+", message = "Genre can consist only of letters")
    private String genre;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Date of writing cannot be null")
    private LocalDate dateOfWriting;



    public Book(int idOfBook, String title, String genre, LocalDate dateOfWriting) {
        this.idOfBook = idOfBook;
        this.title = title;
        this.genre = genre;
        this.dateOfWriting = dateOfWriting;
    }

    public int getID() {
        return idOfBook;
    }

    public void setID(int id) {
        this.idOfBook = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(LocalDate date) {
        this.dateOfWriting = date;
    }


    public String toString() {
        return "Book's title - " + title
                + "\n Genre - " + genre
                + "\n Date Of Writing - " + dateOfWriting
                + "\n ID of book - " + idOfBook;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return title.equals(book.title);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }


}