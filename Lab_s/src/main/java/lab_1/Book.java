package lab_1;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;



public class Book{
    private int idOfBook;
    private String title;
    private String genre;
    private LocalDate dateOfWriting;
    private Library library;
    private Author author;

    private Book(Builder builder) {
        this.title = builder.title;
        this.genre = builder.genre;
        this.dateOfWriting = builder.dateOfWriting;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public String toString() {
        return "Book's title - " + title
                + "\n Genre - " + genre
                + "\n Date Of Writing - " + dateOfWriting
                + "\n Library- " + library
                + "\n Author - " + author;
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
    public static class Builder {
        private String title;
        private String genre;
        private LocalDate dateOfWriting;



        public Builder(String title) {
            this.title = title;
        }
        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder  dateOfWriting(LocalDate date) {
            this. dateOfWriting= date;
            return this;
        }


        public Book build()  {
            return new Book(this);
        }

    }

}