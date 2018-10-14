package by.yasenchak.task1.parser;

import by.yasenchak.task1.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserImpl implements Parser {

    private List<Double[]> doubleList;
    private static final Pattern DELETE_EXTRA_SPACE = Pattern.compile("[\\s]{2,}");
    private final static Logger log = LogManager.getRootLogger();

    @Override
    public List<Double[]> parserList(List<String> listOfLines) throws ParserException{
        doubleList = new ArrayList<>();
        String[] splitArray;
        Double[] doubleArray;
        for (String line: listOfLines) {
            line = DELETE_EXTRA_SPACE.matcher(line).replaceAll(" ").trim();
            splitArray = line.split(" ");
            try {
                doubleArray = new Double[splitArray.length];
                for (int i = 0; i < splitArray.length; i++) {
                    doubleArray[i] = Double.parseDouble(splitArray[i]);
                }
                doubleList.add(doubleArray);
            } catch (NumberFormatException e){
                log.error("Problems with convert String[] to Double[]", e);
                throw new ParserException("Problems with convert String[] to Double[]", e);
            }
        }
        return doubleList;
    }
}