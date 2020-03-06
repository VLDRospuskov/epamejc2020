package homework1;

public class trafficLight {

    public String selectColor(String min) {

        if (isNum(min)) {
            if (Integer.parseInt(min) >= 0 && Integer.parseInt(min) < 4) {
                return ("Green");

            } else if (Integer.parseInt(min) >= 4 && Integer.parseInt(min) < 6) {
                return ("Yellow");

            } else if (Integer.parseInt(min) >= 6 && Integer.parseInt(min) <= 10) {
                return ("Red");

            } else {
                return ("Error");

            }
        } else {
            return ("Error");
        }
    }

    private Boolean isNum(String str) {
        return str.matches("[-+]?\\d+");
    }
}
