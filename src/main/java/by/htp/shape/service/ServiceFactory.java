package by.htp.shape.service;

import by.htp.shape.service.impl.PairLinesService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final DataService dataService = new PairLinesService();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public DataService getDataService() {
        return dataService;
    }

}
