package homeworks.seaBattle.data;

public class Configuration {

    private final static int FIELDSIZE = 10;
    private final static int LINCORNUMBER = 1;
    private final static int CRUISERNUMBER = 2;
    private final static int DESTROYERNUMBER = 3;
    private final static int BOATNUMBER = 4;

    private final static int LINCORDECKS = 4;
    private final static int CRUISERDECKS = 3;
    private final static int DESTROYERDECKS = 2;
    private final static int BOATDECKS = 1;

    public static int getFieldSize() {
        return FIELDSIZE;
    }

    public static int getLincorNumber() {
        return LINCORNUMBER;
    }

    public static int getCruiserNumber() {
        return CRUISERNUMBER;
    }

    public static int getDestroyerNumber() {
        return DESTROYERNUMBER;
    }

    public static int getBoatNumber() {
        return BOATNUMBER;
    }

    public static int getLincorDecks() {
        return LINCORDECKS;
    }

    public static int getCruiserDecks() {
        return CRUISERDECKS;
    }

    public static int getDestroyerDecks() {
        return DESTROYERDECKS;
    }

    public static int getBoatDecks() {
        return BOATDECKS;
    }
}
