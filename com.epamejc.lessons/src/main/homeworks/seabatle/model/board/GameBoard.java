package homeworks.seabatle.model.board;

import homeworks.seabatle.exception.IncorrectShootRequestException;
import homeworks.seabatle.model.players.Player;
import homeworks.seabatle.myenum.StrikeResult;
import homeworks.seabatle.servises.locationservice.LocationService;
import homeworks.seabatle.servises.locationservice.LocationServiceImpl;

import java.util.List;


public class GameBoard {
    private Player playerOne;
    private Player playerTwo;
    private LocationService service;

    public GameBoard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        service = new LocationServiceImpl();
    }

    /**
     * @param request user request with coordinate
     * @param player  player, which field was hit
     * @return enum , contains the information about strike result
     * @throws IncorrectShootRequestException if request is not valid
     */
    public StrikeResult getPlayerStrikeResult(String request, Player player) throws IncorrectShootRequestException {
        Field playerField = player.getField();
        if (request.length() == 2 || request.length() == 3) {
            System.out.println(request);
            int coord = service.getCoordinates(request)[0];
            StrikeResult result = playerField.getStrikeRes(coord);
            return result;
        } else {
            throw new IncorrectShootRequestException(request);
        }

    }

    /**
     * @param coord  integer from 0 to 99
     * @param player player, which field was hit
     * @return enum , contains the information about strike result
     */
    public StrikeResult getPlayerStrikeResult(int coord, Player player) {
        Field playerField = player.getField();
        System.out.println(service.translateRequest(coord));
        return playerField.getStrikeRes(coord);
    }

    /**
     * @return visualization of the battlefield condition
     */
    public String printBattlefield() {
        List<String> pOneField = playerOne.getField().getFieldArray();
        List<String> pTwoField = playerTwo.getField().getFieldArray();
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%29s\n", playerOne.getName(), playerTwo.getName()));

        for (int i = 0; i < pOneField.size(); i++) {
            builder.append(String.format("%s%25s\n", pOneField.get(i), pTwoField.get(i)));
        }
        return builder.toString();
    }

}
