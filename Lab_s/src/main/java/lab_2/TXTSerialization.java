package lab_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab_1.Book;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;

public class TXTSerialization implements Serializer {
    private final ObjectMapper txtMapper;

    public TXTSerialization() {
        this.txtMapper = new ObjectMapper();
        txtMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serialize(Book album, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(album.getTitle() + "; "
                    + album.getGenre() + "; "
                    + album.getDateOfWriting() + "; "
                    + album.getAuthor() +
                    album.getLibrary() + "; ");
        }
    }

    @Override
    public Book deserialize(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        reader.close();

        String[] bookData = line.split("; ");
        String title = bookData[0];
        String genre = bookData[1];
        LocalDate dateOfWriting = LocalDate.parse(bookData[2]);

        return new Book.Builder(title)
                .genre(genre)
                .dateOfWriting(dateOfWriting)
                .build();
    }
}