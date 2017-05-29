package by.htp.shape;

import by.htp.shape.entity.Line;
import by.htp.shape.entity.PairLines;
import by.htp.shape.entity.Point;
import by.htp.shape.provider.StorageProvider;
import by.htp.shape.reader.DataReader;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) {

        PairLines pairLines1 = new PairLines(1, new Line(new Point(1, 1), new Point(1, 1)),
                new Line(new Point(1, 1), new Point(1, 1)));

        PairLines pairLines2 = new PairLines(1, new Line(new Point(2, 2), new Point(2, 2)),
                new Line(new Point(2, 2), new Point(2, 2)));

        StorageProvider storageProvider = StorageProvider.getInstance();

        storageProvider.addRecord(pairLines1);
        storageProvider.addRecord(pairLines2);

        PairLines pL0 = storageProvider.getPairLinesById(0);
        PairLines pL1 = storageProvider.getPairLinesById(1);

        //System.out.println(pL0);

        pL0.setFirst(new Point(2,2), new Point(4,2));
        pL0.setSecond(new Point(2,2), new Point(3,4));

        //System.out.println(pL1);

        //pL1.detach(storageProvider);

        pL1.setFirst(new Point(7,1), new Point(4,2));
        pL1.setSecond(new Point(2,2), new Point(7,1));

       // System.out.println(pL1);

//        DataReader dataReader = new DataReader();
//        ArrayList<String> list = (ArrayList<String>) dataReader.readFile("files/data.txt");
//
//        for (String item : list){
//            System.out.println(item);
//        }


    }
}
