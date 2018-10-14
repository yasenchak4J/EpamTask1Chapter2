package by.yasenchak.task1.reader;

import by.yasenchak.task1.exception.ReadException;

import java.util.List;

public interface Reader {

    List<String> read(String URI) throws ReadException;
    List<String> readOnlyValid(String URI) throws ReadException;
}
