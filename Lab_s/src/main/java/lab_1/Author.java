package lab_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Author{
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String pseudonym;
    private List<Book> books;

    private Author(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.pseudonym = builder.pseudonym;
        this.books = new ArrayList<>(); // Initialize the books list
    }
    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return lastName;
    }

    public void setSecondName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate date) {
        this.dateOfBirth = date;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public String toString() {
        return "Author's first name - " + firstName
                + "\n Second name - " + lastName
                + "\n Date of birth - " + dateOfBirth
                + "\n Pseudonym - " + pseudonym;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Author author = (Author) object;
        return firstName.equals(author.firstName) && lastName.equals(author.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    public static class Builder {
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private final String pseudonym;



        public Builder(String pseudonym) {
            this.pseudonym = pseudonym;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(LocalDate date) {
            this.dateOfBirth = date;
            return this;
        }


        public Author build()  {
            return new Author(this);
        }

    }

}