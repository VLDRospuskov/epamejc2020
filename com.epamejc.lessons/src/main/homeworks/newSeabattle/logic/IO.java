package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.enums.Messages;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import static homeworks.newSeabattle.data.enums.Messages.CHOOSE_PLAYERS;

public class IO {

    @SneakyThrows
    public static String getNameFromUser() {
        String message = Messages.NAME.toString();
        return Helper.getString(message);
    }

    @SneakyThrows
    public static boolean getManualFieldCreationFromUser() {
        String message = Messages.MANUAL_CREATION.toString();
        return Helper.getString(message).equalsIgnoreCase("yes");
    }

    @SneakyThrows
    public static int getGameType() {
       String message = CHOOSE_PLAYERS.toString();
       return  Helper.getInt(message);
    }
}
