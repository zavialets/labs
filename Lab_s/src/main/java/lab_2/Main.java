package lab_2;

import lab_1.Book;
import lab_2.JsonSerialization;
import lab_2.TXTSerialization;
import lab_2.XmlSerialization;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a sample Book
        Book book = new Book.Builder("Sample Book")
                .genre("Fiction")
                .dateOfWriting(LocalDate.of(2022, 1, 1))
                .build();

        // Create instances of serializers
        Serializer jsonSerializer = new JsonSerialization();
        Serializer txtSerializer = new TXTSerialization();
        Serializer xmlSerializer = new XmlSerialization();

        // Define file paths
        File jsonFile = new File("sample.json");
        File txtFile = new File("sample.txt");
        File xmlFile = new File("sample.xml");

        try {
            // Serialize to JSON
            jsonSerializer.serialize(book, jsonFile);
            System.out.println("Serialized to JSON: " + jsonFile.getAbsolutePath());

            // Serialize to TXT
            txtSerializer.serialize(book, txtFile);
            System.out.println("Serialized to TXT: " + txtFile.getAbsolutePath());

            // Serialize to XML
            xmlSerializer.serialize(book, xmlFile);
            System.out.println("Serialized to XML: " + xmlFile.getAbsolutePath());

            // Deserialize from TXT
            Book deserializedBook = (Book) txtSerializer.deserialize(txtFile);
            System.out.println("Deserialized from TXT:\n" + deserializedBook);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
