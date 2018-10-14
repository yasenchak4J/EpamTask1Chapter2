package by.yasenchak.task1.parser;

import by.yasenchak.task1.exception.ParserException;

import java.util.List;

public interface Parser {

    List<Double[]> parserList(List<String> listOfLines) throws ParserException;
}
