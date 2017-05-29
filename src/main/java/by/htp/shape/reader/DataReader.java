package by.htp.shape.reader;

import by.htp.shape.exception.MyFileNotFoundException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {

    public List<String> readFile(String filename) {
        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(Paths.get(filename), Charset.forName("UTF-8"));
        } catch (IOException e) {
            new MyFileNotFoundException();
        }

        return stringList;
    }


}
