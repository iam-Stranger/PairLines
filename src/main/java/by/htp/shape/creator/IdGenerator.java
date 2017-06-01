package by.htp.shape.creator;


public class IdGenerator {

    private static long currentId = 1000;

    public static long generateNewId() {
        return currentId++;
    }

    public static long getLastId(){ return currentId;}

}
