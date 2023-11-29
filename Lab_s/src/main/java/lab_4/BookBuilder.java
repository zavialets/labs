package lab_4;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.time.LocalDate;
import java.util.Set;

public class BookBuilder implements Builder {


        private int idOfBook;
        private String title;
        private String genre;
        private LocalDate dateOfWriting;

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }
        public BookBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookBuilder  dateOfWriting(LocalDate date) {
            this. dateOfWriting= date;
            return this;
        }


    @Override
    public Book build() {
        Book book = new Book(idOfBook,title,genre, dateOfWriting);

        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Book>> errors = validator.validate(book);

            if (!errors.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (ConstraintViolation<Book> val : errors) {
                    sb.append("InvalidValue: ").append(val.getInvalidValue()).append("; ")
                            .append(val.getMessage()).append("\n");
                }
                throw new IllegalArgumentException(sb.toString());
            }

        }

        return book;
    }

    }

