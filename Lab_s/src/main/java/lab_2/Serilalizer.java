package lab_2;

import lab_1.Book;

import java.io.File;
import java.io.IOException;

interface Serializer {
    void serialize(Book ob, File file) throws IOException;
    Object deserialize(File file) throws IOException;

}