package homeworks.seabatle.servises.locationservice;

import homeworks.seabatle.exception.IncorrectInputParseException;

public interface LocationService {

    int[] getCoordinates(String request) throws IncorrectInputParseException;

    String translateRequest(int coord);
}
