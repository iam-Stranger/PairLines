package by.htp.shape.exception;

public class MyFileNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Data file is not found";
    }

}
