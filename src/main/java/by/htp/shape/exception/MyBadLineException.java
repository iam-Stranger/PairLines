package by.htp.shape.exception;

public class MyBadLineException extends Exception {

    @Override
    public String getMessage() {
        return "Bad line in data file";
    }

}
