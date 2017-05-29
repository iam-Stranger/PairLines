package by.htp.shape.provider;


import by.htp.shape.entity.PairLines;
import by.htp.shape.entity.PairLinesData;
import by.htp.shape.service.DataService;
import by.htp.shape.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class StorageProvider implements Observer {

    private static final StorageProvider instance = new StorageProvider();

    private Logger logger = LogManager.getLogger(StorageProvider.class.getName());

    private HashMap<PairLines, PairLinesData> storageMap = new HashMap<PairLines, PairLinesData>();

    private StorageProvider() {
    }

    public static StorageProvider getInstance() {
        return instance;
    }

    @Override
    public void update(PairLines observed) {
        ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
        DataService dataService = serviceFactoryObject.getDataService();

        int id = observed.getId();
        double angle = 0;
        double distance = 0;

        PairLinesData pairLinesData = getPairLinesDataById(id);
        angle = dataService.calculateAngle(observed.getFirst(), observed.getSecond());
        distance = dataService.calculateDistance(observed.getFirst(), observed.getSecond());

        pairLinesData.setAngle(angle);
        pairLinesData.setDistance(distance);
    }

    public PairLines getPairLinesById(int id) {
        PairLines pairLines = null;

        for (Map.Entry<PairLines, PairLinesData> entry : storageMap.entrySet()) {
            if (entry.getKey().getId() == id) {
                pairLines = entry.getKey();
            }
        }

        return pairLines;
    }

    public void addRecord(PairLines pairLines){
            int id = getNewPairLinesID();
            pairLines.setId(id);
            PairLinesData pairLinesData = new PairLinesData();
            // calculate PairLinesData
            pairLines.attach(this);
            storageMap.put(pairLines, pairLinesData);
            logger.error("Add: "+pairLines.toString());
    }

    private PairLinesData getPairLinesDataById(int id) {
        PairLinesData pairLinesData = null;

        for (Map.Entry<PairLines, PairLinesData> entry : storageMap.entrySet()) {
            if (entry.getKey().getId() == id) {
                pairLinesData = entry.getValue();
            }
        }

        return pairLinesData;
    }

    private int getNewPairLinesID(){
        int id;
        id = storageMap.size();

        return id;
    }

}
