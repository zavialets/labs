package lab_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Library{
    private String libraryName;
    private LocalDate foundingDate;
    private String location;
    private List<Book> books;

    public Library(Builder builder) {
        this.libraryName = builder.labelName;
        this.foundingDate = builder.foundingDate;
        this.location = builder.location;
        this.books = new ArrayList<>();
    }


    public Library() {
    }

    public LocalDate getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(LocalDate date) {
        this.foundingDate = date;
    }


    public String getName() {
        return libraryName;
    }

    public void setName(String name) {
        this.libraryName = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setLibrary(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setLibrary(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public String toString() {
        return "Library - " + libraryName
                + "\n Fouding date - " + foundingDate
                + "\n Adress - " + location;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Library label = (Library) object;
        return libraryName.equals(label.libraryName);
    }

    public int hashCode() {
        return Objects.hash(libraryName);
    }

    public static class Builder {
        private final String labelName;
        private LocalDate foundingDate;
        private String location;


        public Builder(String name) {
            this.labelName = name;
        }

        public Builder foundingDate(LocalDate date) {
            this.foundingDate = date;
            return this;
        }


        public Builder location(String address) {
            this.location = address;
            return this;
        }

        public Library build()  {
            return new Library(this);
        }

    }





}
