package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.enums.Messages;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

public class Input {

    @SneakyThrows
    public static String getNameFromUser() {
        String message = Messages.GETTING_NAME.toString();
        return Helper.getString(message);
    }

}
