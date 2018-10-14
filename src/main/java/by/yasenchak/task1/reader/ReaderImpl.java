package by.yasenchak.task1.reader;

import by.yasenchak.task1.exception.ReadException;
import by.yasenchak.task1.validator.Validator;
import by.yasenchak.task1.validator.ValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderImpl implements Reader {

    private List<String> listOfAllLines;
    private List<String> listOfOnlyValidLines;
    private final static Logger log = LogManager.getRootLogger();
    private final Validator validator = new ValidatorImpl();

    @Override
    public List<String> read(String URI) throws ReadException {
        listOfAllLines = new ArrayList<>();
        Path FILE_PATH = Paths.get(URI);
        try(Stream<String> lineStream = Files.lines(FILE_PATH) ) {

            listOfAllLines = lineStream.collect(Collectors.toList());

        } catch (IOException e) {
            log.error("Problems with file", e);
            throw new ReadException("Problems with file", e);
        }
        return listOfAllLines;
    }

    @Override
    public List<String> readOnlyValid(String URI) throws ReadException{
        listOfAllLines = new ArrayList<>();
        listOfOnlyValidLines = new ArrayList<>();
        Path FILE_PATH = Paths.get(URI);
        try(Stream<String> lineStream = Files.lines(FILE_PATH) ) {

            listOfAllLines = lineStream.collect(Collectors.toList());

            for (String line: listOfAllLines) {
                if (validator.isValid(line)){
                    listOfOnlyValidLines.add(line);
                }
            }
        } catch (IOException e) {
            log.error("Problems with file", e);
            throw new ReadException("Problems with file", e);
        }
        return listOfOnlyValidLines;
    }
}
